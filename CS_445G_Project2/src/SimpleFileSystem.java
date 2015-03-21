
public class SimpleFileSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimulatedDisk disk = new SimulatedDisk();
		
		/*
		 * creating thread p1
		 */
		Thread p1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				disk.create("file1", 7);
				disk.write("file1");
				//System.out.println(disk.read("file1"));
				disk.close("file1");
				disk.create("file2", 3);
				disk.write("file2");
				//System.out.println(disk.read("file2"));
				disk.close("file2");
			}
		});
		/*
		 * create ProcessFileTable for Thread 1 with index = 0
		 */
		disk.createProcessFileTable(p1.getId(), 0);
		/*
		 * starting thread p1
		 */
		p1.start();
		
		/*
		 * creating thread p2
		 */
		Thread p2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				disk.open("file1");
				System.out.println("content of file1: " + disk.read("file1")); // read the content of file1 and display to screen
				disk.close("file1");
			}
		});
		/*
		 * create ProcessFileTable for Thread 2 with index = 1
		 */
		disk.createProcessFileTable(p2.getId(), 1);
		
		/*
		 * creating thread p3
		 */
		Thread p3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				disk.open("file2");
				System.out.println("content of file2: " + disk.read("file2")); // read the content of file2 and display to screen
				disk.close("file2");
			}
		});
		/*
		 * create ProcessFileTable for Thread 3 with index = 2
		 */
		disk.createProcessFileTable(p3.getId(), 2);
		
		/*
		 * start p2 and p3 after p1 is completed
		 */
		try {
			p1.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		p2.start();
		p3.start();
		
		
		try {
			p2.join();
			p3.join();
		} catch (InterruptedException e) {
			// TODO: handle exception.
			e.printStackTrace();
		}

		disk.displayToScreen();		
	}

}
