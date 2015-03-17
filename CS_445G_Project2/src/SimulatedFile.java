
public class SimulatedFile {
	String file_name;
	int start_block_number;
	int file_size;
	char[] file_content;
	FileControlBlock fcb;
	
	public SimulatedFile(String filename, int filesize)
	{
		super();
		this.file_name = filename;
		this.file_size = filesize;
	}
	
	public String getFileName()
	{
		return file_name;
	}
	
	public int getFileSize()
	{
		return file_size;
	}
		
	public FileControlBlock getFCB()
	{
		return fcb;
	}
	
	public int getStartBlockNumber()
	{
		return start_block_number;
	}
	
	public void setStartBlockNumber(int num)
	{
		this.start_block_number = num;
	}
	
	public void setFCB() {
		this.fcb = new FileControlBlock(file_size, start_block_number);
	}
}
