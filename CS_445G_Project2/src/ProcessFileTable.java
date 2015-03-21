import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProcessFileTable {
	long processID;
	List<ThreadFile> threadFileList;
	
	public ProcessFileTable(long processid)
	{
		this.processID = processid;
		threadFileList = Collections.synchronizedList(new ArrayList<ThreadFile>());
	}
	
	public void addThreadFile(ThreadFile file)
	{
		synchronized (file) {
			threadFileList.add(file);
		}		
	}
	
	public void removeThreadFile(String file_name)
	{
		Iterator<ThreadFile> iterator = threadFileList.iterator();
		while (iterator.hasNext()) {
			ThreadFile rmFile = iterator.next();
			if (rmFile.getName().equals(file_name)) {
				iterator.remove();
				break;
			}			
		}			
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
