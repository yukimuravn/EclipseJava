import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SystemWideFileTable {
	List<SimulatedFile> openedFileList;

	public SystemWideFileTable()
	{
		openedFileList = Collections.synchronizedList(new ArrayList<SimulatedFile>());
	}
	
	/*
	 * add file to the System-Wide Open File Table
	 * used for open() function of disk
	 */
	public void addOpenedFile(SimulatedFile newfile)
	{
		synchronized (newfile) {
			openedFileList.add(newfile);
		}		
	}
	
	/*
	 * remove file from the System-Wide Open File Table
	 * used for close() function of disk
	 */
	public void removeOpenedFile(String file_name)
	{
		Iterator<SimulatedFile> iterator = openedFileList.iterator();
		while (iterator.hasNext()) {
			SimulatedFile file = iterator.next();
			if (file.file_name.equals(file_name)) {
				iterator.remove();
				break;
			}	
		}	
	}
	
	public SimulatedFile getOpenedFile(String fName)
	{
		synchronized (fName) {
			for (SimulatedFile file : openedFileList) {
				if (file.getFileName().equals(fName)) {
					return file;
				}
			}
			return null;
		}		
	} 
	
	public ThreadFile getThreadFile(String fName)
	{
		synchronized (fName) {
			for (int i = 0; i < openedFileList.size(); i++) {
				if (openedFileList.get(i).getFileName().equals(fName)) {
					ThreadFile tFile = new ThreadFile(fName, i);
					return tFile;
				}
			}
			return null;
		}		
	}
	
	public void displayToScreen()
	{
		System.out.println("SystemWideFileTable");
		for (SimulatedFile simulatedFile : openedFileList) {
			System.out.println("[" + simulatedFile.getFileName() + "]" + "[" + simulatedFile.fcb.getFirstDataBlock() +"]" + "[" + simulatedFile.fcb.getFileSize() + "]");
		}
	}
}
