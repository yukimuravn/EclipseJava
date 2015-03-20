
public class ThreadFile {
	String file_name;
	int handle_index;
	
	public ThreadFile(String fName, int index)
	{
		super();
		this.file_name = fName;
		this.handle_index = index;
	}
	
	public String getName()
	{
		return file_name;
	}
	
	public int getHandleIndex()
	{
		return handle_index;
	}
}
