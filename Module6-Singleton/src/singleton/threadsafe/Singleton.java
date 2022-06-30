package singleton.threadsafe;

public class Singleton {
	private static Singleton uniqueInstance;
 
	// other useful instance variables here
 
	private Singleton() {}
	private int counter = 0;
	
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
	public String getDescription() {
		return "I'm a thread safe Singleton!";
	}
	
	public synchronized void incrementCounter(int howMuch){
		this.counter = this.counter + howMuch;
	}
	
	public synchronized int getCounter(){
		return this.counter;
	}
}
