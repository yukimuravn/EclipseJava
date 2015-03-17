
public class VolumeControlBlock {	
	public static final int DATA_BLOCK_SIZE = 2048;
	public static final int BLOCK_NUMBERS = 510; // Total is 512 blocks, 1 is for VolumeControlBlock, 1 is for FlatDirectory
	int number_of_blocks;
	int size_of_block;
	int free_block_count;
	boolean[] free_block_array;
	
	public VolumeControlBlock()
	{
		super();
		this.number_of_blocks = BLOCK_NUMBERS;
		this.size_of_block = DATA_BLOCK_SIZE;
		this.free_block_array = new boolean[number_of_blocks];
	}

	public int getNumberOfBlocks()
	{
		return number_of_blocks;
	}
	
	public int getSizeOfBlock()
	{
		return size_of_block;
	}
	
	public int getFreeBlockCount()
	{
		int i = 0;
		for (int j = 0; j < free_block_array.length; j++) {
			if (free_block_array[j] == false) {
				i++;
			}
		}
		return i;
	}
	
	public boolean[] getFreeBlockArray()
	{
		return free_block_array;
	}
	
	/*
	 * check the free_block_array to allocate the file, and then update the free_block_array
	 */	
	public SimulatedFile allocateFile(SimulatedFile file)
	{
		int size = file.getFileSize();
		int flag = 0;
		int index_flag = 0;
		
		for (int i = 0; i < free_block_array.length; i++) {			
			if (free_block_array[i] == false) {
				flag++;
				if (flag == 1) {
					index_flag = i;
				}	
				if (flag == size) {
					// allocate file from index_flag
					for (int j = index_flag; j < (index_flag+size); j++) {
						this.free_block_array[j] = true;
					}
					file.setStartBlockNumber(index_flag);
					return file;
				}
			}
			else {
				flag = 0;
				index_flag = 0;
			}
		} 
		
		return file;
	}
	
}
