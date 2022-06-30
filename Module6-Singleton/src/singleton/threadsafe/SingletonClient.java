package singleton.threadsafe;

public class SingletonClient {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getDescription());

	/* To Do:  Create a couple of threads that both use
	 * the counter in this Singleton, have them run with
	 * random time breaks built in (to ensure switching),
	 * and prove that the Singleton captures all the 
	 * intended counting.
	 */
		int r1 = 9;
		int r2 = 10;
		
		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < r1; i++) {
					singleton.incrementCounter(1);
					System.out.println("Thread 1: "+singleton.getCounter());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				System.out.println("1 Finished "+singleton.getCounter());
			}
			
		};
		
		Thread t1 = new Thread(run1);
		t1.start();
		
		Runnable run2 = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < r2; i++) {
					singleton.incrementCounter(1);
					System.out.println("Thread 2: "+singleton.getCounter());
					try {
						Thread.sleep(i*100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("2 Finished with "+singleton.getCounter());
				
			}
			
		};
		
		Thread t2 = new Thread(run2);
		t2.start();
		
		
	}
}
