
public class SimulatedDisk {
	public static final int DATA_BLOCK_SIZE = 2048;
	public static final int BLOCK_NUMBERS = 512; // Total is 512 blocks, 1 is for VolumeControlBlock, 1 is for FlatDirectory
	SystemWideFileTable systemWideFileTable;
	VolumeControlBlock volumeControlBlock;
	FlatDirectory flatDirectory;	
	Object[] array_blocks;
	ProcessFileTable[] array_processfiletable;
	
	/*
	 * initialize SimulatedDisk()
	 */
	public SimulatedDisk()
	{
		super();
		systemWideFileTable = new SystemWideFileTable();
		volumeControlBlock = new VolumeControlBlock(BLOCK_NUMBERS, DATA_BLOCK_SIZE);
		flatDirectory = new FlatDirectory();
		array_processfiletable = new ProcessFileTable[3]; // 3 ProcessFileTable for 3 threads
		
		/*
		 *  initialize the array_blocks of disk
		 *  with the index 0 is VolumeControlBlock
		 *  and index 1 is FlatDirectory
		 *  the rest of the array is allocated by the file1, file2... (total 510 blocks)
		 */
		array_blocks = new Object[BLOCK_NUMBERS];
		array_blocks[0] = volumeControlBlock;
		array_blocks[1] = flatDirectory;				
	}
	
	public void createProcessFileTable(long processID, int index)
	{
		ProcessFileTable pft = new ProcessFileTable(processID);
		array_processfiletable[index] = pft;
	}
	
	/*
	 * allocate a file to array_blocks
	 * start from the index = 2
	 */
	public SimulatedFile allocateFile(SimulatedFile file)
	{
		
		int size = file.getFileSize();
		int flag = 2;
		int index_flag = 2;
		
		for (int i = 2; i < BLOCK_NUMBERS; i++) {			
			if (array_blocks[i] == null) {
				flag++;
				if (flag == 3) {
					index_flag = i;
				}	
				if (flag == size) {
					// allocate file from index_flag
					for (int j = index_flag; j < (index_flag+size); j++) {
						this.array_blocks[j] = file;
					}
					file.setStartBlockNumber(index_flag);
					return file;
				}
			}
			else {
				flag = 2;
				index_flag = 2;
			}
		} 
		
		return file;
	}
	
	/*
	 * Create a file with a specified size. 
	 * The size is in terms of the number of blocks
	 * When create a file, automatically open that file
	 * and add it to the FlatDirectory and SystemWideOpenFileTable
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
			flatDirectory.addFile(this.allocateFile(new_file));
			volumeControlBlock.updateFreeBlockArray(array_blocks);
			System.out.println("creating " + fName);
			this.open(fName);
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
		 * check if file_name is already opened/exist 
		 * in the SystemWideFileTable
		 */
		if (systemWideFileTable.getOpenedFile(fName) == null) {
			/*
			 * if file_name is not opened or exist then
			 * get file from FlatDirectory
			 * and add to SystemWideFileTable
			 * in this project we assume that no file was opened twice
			 */
			SimulatedFile file = flatDirectory.getFile(fName);
			systemWideFileTable.addOpenedFile(file);
			
			/*
			 * after adding file to the SystemWideFileTable
			 * create ThreadFile by getting from SystemWideFileTable
			 * and add to ProcessFileTable
			 */
			ThreadFile tFile = systemWideFileTable.getThreadFile(fName);
			for (int i = 0; i < array_processfiletable.length; i++) {
				if (array_processfiletable[i].getID() == Thread.currentThread().getId()) {
					array_processfiletable[i].addThreadFile(tFile);
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
	 * (remove that file in the SystemWideFileTable and ProcessFileTable)
	 */
	public void close(String fName)
	{	
		/*
		 * check if file_name is already opened or exist in the SystemWideFileTable
		 */
		if (systemWideFileTable.getOpenedFile(fName) != null) {
			/*
			 * if file_name is opened or exist then
			 * remove that file from ProcessFileTable
			 */
			for (int i = 0; i < array_processfiletable.length; i++) {
				if (array_processfiletable[i].getID() == Thread.currentThread().getId()) {
					ProcessFileTable pft = array_processfiletable[i];
					pft.removeThreadFile(fName);
					break;
				}
			}
			
			/*
			 * remove that file from SystemWideFileTable
			 */
			systemWideFileTable.removeOpenedFile(fName);
			
			System.out.println("closing " + fName);
		}
		else {
			System.out.println("can not close() " + fName + " :file_name is not exist");
		}
	}
	
	/*
	 * read a file to a local variable
	 * return a String content of the file
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
	 * display the output
	 */
	public void displayToScreen()
	{
		/*
		for (int i = 0; i < array_processfiletable.length; i++) {
			ProcessFileTable pft = array_processfiletable[i];
			pft.displayToScreen();
		}
		*/
		/*
		for (int i = 0; i < array_blocks.length; i++) {
			if (array_blocks[i] == null) {
				System.out.println("null");
			}
			else {
				System.out.println("Allocated");
			}
		}
		*/
		/*
		VolumeControlBlock vcb = (VolumeControlBlock) array_blocks[0];
		vcb.displayToScreen();
		*/
		
		//systemWideFileTable.displayToScreen();
		//flatDirectory.displayToScreen();
		//System.out.println("free_block_count = " + volumeControlBlock.getFreeBlockCount());
	}
}
