
public class FileControlBlock {
	int filesize;
	int first_data_block;
	
	public FileControlBlock(int size, int firstdatablock)
	{
		super();
		this.filesize = size;
		this.first_data_block = firstdatablock;
	}
	
	/*
	 * get() methods
	 */
	public int getFileSize()
	{
		return filesize;
	}
	
	public int getFirstDataBlock()
	{
		return first_data_block;
	}
	
	/*
	 * set() methods
	 */

}
