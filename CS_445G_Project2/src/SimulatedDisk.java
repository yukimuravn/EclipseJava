import java.util.ArrayList;
import java.util.List;


public class SimulatedDisk {
	SystemWideFileTable systemWideFileTable;
	VolumeControlBlock volumeControlBlock;
	FlatDirectory flatDirectory;	
	List<Object> array_blocks;
	
	
	/*
	 * init SimulatedDisk()
	 */
	public SimulatedDisk()
	{
		super();
		systemWideFileTable = new SystemWideFileTable();
		volumeControlBlock = new VolumeControlBlock();
		flatDirectory = new FlatDirectory();
		array_blocks = new ArrayList<Object>();
	}
	

	/*
	 * create a file with a specified size. The size is in terms of the number of blocks
	 */
	public void create(String fName, int size)
	{
		System.out.println("creating " + fName);	
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
		}
		else {
			System.out.println(fName + " is exist");
		}
		
		//flatDirectory.displayToScreen();
		//System.out.println("free_block_count = " + volumeControlBlock.getFreeBlockCount());
	}
	
	/*
	 * open a file, and update system-wide and per-process open file tables
	 */
	public void open(String fName)
	{
		System.out.println(" opening " + fName);
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
		System.out.println(" closing " + fName);
		SimulatedFile file = flatDirectory.getFile(fName);
		systemWideFileTable.removeOpenedFile(file);
	}
	
	/*
	 * read a file to a local variable
	 */
	public void read(String fName)
	{
		System.out.println(" reading " + fName);
	}
	
	/*
	 * write specified content to selected free blocks
	 */
	public void write(String fName)
	{
		System.out.println(" writing " + fName);
	}
	
	public void displayToScreen()
	{
		systemWideFileTable.displayToScreen();
	}
}
