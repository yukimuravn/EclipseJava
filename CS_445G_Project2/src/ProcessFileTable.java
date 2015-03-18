import java.util.ArrayList;
import java.util.List;


public class ProcessFileTable {
	long processID;
	List<ThreadFile> threadFileList;
	
	public ProcessFileTable(long processid)
	{
		this.processID = processid;
		threadFileList = new ArrayList<ThreadFile>();
	}
	
	public void addThreadFile(ThreadFile file)
	{
		threadFileList.add(file);
	}
	
	public long getID()
	{
		return processID;
	}
	
	public void displayToScreen()
	{
		System.out.println("processID: " + processID);
		for (ThreadFile threadFile : threadFileList) {
			System.out.printf("[%s][%d]\n", threadFile.getName(), threadFile.getHandleIndex());
		}
	}
}
