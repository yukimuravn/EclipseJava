import java.util.Arrays;


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
	
	/*
	 * getFileContent() is used for the read() function of the disk
	 * convert char[] to String
	 * @return String
	 */
	public String getFileContent()
	{
		return Arrays.toString(file_content);
	}
	
	/*
	 * set the content of the file based on the size
	 * the content is the number of character A
	 * i.e: 
	 * file1 (size = 2) => content is 'A''A'
	 * file2 (size = 4) => content is 'A''A''A'
	 */
	public void setFileContent()
	{
		file_content = new char[file_size];
		for (int i = 0; i < file_size; i++) {
			file_content[i] = 'A';
		}
	}
	
	public void setStartBlockNumber(int num)
	{
		this.start_block_number = num;
	}
	
	public void setFCB() {
		this.fcb = new FileControlBlock(file_size, start_block_number);
	}
}
