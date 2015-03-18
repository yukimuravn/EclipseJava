import java.util.ArrayList;
import java.util.List;


public class SimulatedDisk {
	SystemWideFileTable systemWideFileTable;
	VolumeControlBlock volumeControlBlock;
	FlatDirectory flatDirectory;	
	List<Object> array_blocks;
	List<ProcessFileTable> processFileTableList;
	
	/*
	 * initialize SimulatedDisk()
	 */
	public SimulatedDisk()
	{
		super();
		systemWideFileTable = new SystemWideFileTable();
		volumeControlBlock = new VolumeControlBlock();
		flatDirectory = new FlatDirectory();
		array_blocks = new ArrayList<Object>();
		processFileTableList = new ArrayList<>();
	}
	
	public void createProcessFileTable(long processID)
	{
		ProcessFileTable pft = new ProcessFileTable(processID);
		processFileTableList.add(pft);
	}

	/*
	 * create a file with a specified size. The size is in terms of the number of blocks
	 */
	public void create(String fName, int size)
	{	
		/*
		 * check if the file_name is exist in FlatDirectory
		 */
		if (flatDirectory.getFile(fName) == null) {
			/*
			 * if file_name is not exist in FlatDirectory
			 * then creating a file, VolumeControlBlock will allocate the file
			 * and then add to FlatDirectory
			 */
			SimulatedFile new_file = new SimulatedFile(fName, size);
			flatDirectory.addFile(volumeControlBlock.allocateFile(new_file));
			System.out.println("creating " + fName);
		}
		else {
			System.out.println("can not create(): " + fName + " is existed");
		}
	}
	
	/*
	 * open a file, and update system-wide and per-process open file tables
	 */
	public void open(String fName)
	{
		/*
		 * check if file_name is already opened or exist in the SystemWideFileTable
		 */
		if (systemWideFileTable.getOpenedFile(fName) == null) {
			/*
			 * if file_name is not opened or exist then
			 * get file from FlatDirectory
			 * and add to SystemWideFileTable
			 */
			SimulatedFile file = flatDirectory.getFile(fName);
			systemWideFileTable.addOpenedFile(file);
			
			/*
			 * after adding file to the SystemWideFileTable
			 * create ThreadFile by getting from SystemWideFileTable
			 * and add to ProcessFileTable
			 */
			ThreadFile tFile = systemWideFileTable.getThreadFile(fName);
			for (int i = 0; i < processFileTableList.size(); i++) {
				if (processFileTableList.get(i).getID() == Thread.currentThread().getId()) {
					processFileTableList.get(i).addThreadFile(tFile);
					break;
				}
			}
			
			System.out.println("opening " + fName);
		}
		else {
			System.out.println(fName + " is already opened");
		}		
	}
	
	/*
	 * close a file, and update system-wide and per-process open file tables
	 */
	public void close(String fName)
	{	
		/*
		 * check if file_name is already opened or exist in the SystemWideFileTable
		 */
		if (systemWideFileTable.getOpenedFile(fName) != null) {
			/*
			 * if file_name is opened or exist then
			 * get file from FlatDirectory
			 * and remove that file from SystemWideFileTable
			 */
			SimulatedFile file = flatDirectory.getFile(fName);
			systemWideFileTable.removeOpenedFile(file);
			System.out.println("closing " + fName);
		}
		else {
			System.out.println("can not close() " + fName + " :file_name is not exist");
		}
	}
	
	/*
	 * read a file to a local variable
	 */
	public String read(String fName)
	{
		System.out.println("reading " + fName);
		String result;
		/*
		 * check if the file is already exist in FlatDirectory
		 */
		SimulatedFile file = flatDirectory.getFile(fName);
		if (file != null) {
			result = file.getFileContent();
		}
		else {
			result = null;
		}
		return result;		
	}
	
	/*
	 * write specified content to selected free blocks
	 * write content to the char[] of the file
	 */
	public void write(String fName)
	{
		System.out.println("writing " + fName);
		/*
		 * check if the file is already exist in FlatDirectory
		 */
		SimulatedFile file = flatDirectory.getFile(fName);
		if (file != null) {
			file.setFileContent();
		}
		else {
			System.out.println(fName + " is not exist");
		}
	}
	
	/*
	 * not for the project
	 * personal use
	 * see the output
	 */
	public void displayToScreen()
	{
		for (ProcessFileTable pft : processFileTableList) {
			pft.displayToScreen();
		}
		//systemWideFileTable.displayToScreen();
		//flatDirectory.displayToScreen();
		//System.out.println("free_block_count = " + volumeControlBlock.getFreeBlockCount());
	}
}
