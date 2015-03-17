import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SystemWideFileTable {
	List<SimulatedFile> openedFileList;
	
	public SystemWideFileTable()
	{
		openedFileList = new ArrayList<SimulatedFile>();
	}
	
	/*
	 * add file that opened to the System-Wide Open File Table
	 */
	
	public void addOpenedFile(SimulatedFile newfile)
	{
		openedFileList.add(newfile);
	}
	
	public void removeOpenedFile(SimulatedFile openedfile)
	{
		Iterator<SimulatedFile> iterator = openedFileList.iterator();
		while (iterator.hasNext()) {
			SimulatedFile file = iterator.next();
			if (file.file_name.equals(openedfile.file_name)) {
				iterator.remove();
				break;
			}	
		}
	}
	
	public SimulatedFile getOpenedFile(String fName)
	{
		for (SimulatedFile file : openedFileList) {
			if (file.getFileName().equals(fName)) {
				return file;
			}
		}
		return null;
	} 
	
	public void displayToScreen()
	{
		System.out.println("SystemWideFileTable");
		for (SimulatedFile simulatedFile : openedFileList) {
			System.out.println("[" + simulatedFile.getFileName() + "]" + "[" + simulatedFile.fcb.getFirstDataBlock() +"]" + "[" + simulatedFile.fcb.getFileSize() + "]");
		}
	}
}
