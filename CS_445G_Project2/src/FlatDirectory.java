import java.util.ArrayList;
import java.util.List;


public class FlatDirectory {
	List<SimulatedFile> file_list;
	
	public FlatDirectory()
	{
		file_list = new ArrayList<SimulatedFile>();
	}
	
	public void addFile(SimulatedFile file)
	{
		file.setFCB();
		file_list.add(file);
	}
	
	public SimulatedFile getFile(String fName)
	{
		for (SimulatedFile file : file_list) {
			if (file.getFileName().equals(fName)) {
				return file;
			}
		}
		return null;
	}
	
	public void displayToScreen()
	{
		System.out.println("FlatDirectory");
		for (SimulatedFile simulatedFile : file_list) {
			System.out.println("[" + simulatedFile.getFileName() + "]" + "[" + simulatedFile.getStartBlockNumber() +"]" + "[" + simulatedFile.getFileSize() + "]");
		}
	}
}
