
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
				//disk.write("file1");
				//disk.close("file1");
				disk.create("file2", 3);
				disk.create("file2", 3);
				//disk.write("file2");
				//disk.close("file2");
			}
		});
		
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
				//disk.read("file1");
				//disk.close("file1");
			}
		});
		
		/*
		 * creating thread p3
		 */
		Thread p3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				disk.open("file2");
				//disk.read("file2");
				//disk.close("file2");
			}
		});
		
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
		//System.out.println(p2.getName());
		p3.start();
	}

}
