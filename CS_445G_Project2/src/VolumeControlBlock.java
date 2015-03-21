
public class VolumeControlBlock {
	/*
	 * this is 4 variables of VolumeControlBlock
	 */
	int number_of_blocks;
	int size_of_block;
	int free_block_count;
	boolean[] free_block_array;
	
	/*
	 * create VolumeControlBlock with 
	 * the default number_of_blocks = 512 
	 * and size_of_block = 2048
	 */
	public VolumeControlBlock(int numofblock, int sizeofblock)
	{
		super();
		this.number_of_blocks = numofblock;
		this.size_of_block = sizeofblock;
		this.free_block_array = new boolean[number_of_blocks]; //510
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
	 * update free_block_array based on the array_blocks of disk
	 */	
	public void updateFreeBlockArray(Object[] array_blocks)
	{		
		free_block_array[0] = true; // this is for VolumeControlBlock
		free_block_array[1] = true; // this is for FlatDirectory
		for (int i = 2; i < array_blocks.length-2; i++) {
			if (array_blocks[i] == null) {
				free_block_array[i] = false;
			}
			else {
				free_block_array[i] = true;
			}
		}
	}
	
	public void displayToScreen()
	{
		for (int i = 0; i < free_block_array.length; i++) {
			if (free_block_array[i] == true) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
	}
}
