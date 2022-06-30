package singleton.subclass;

public class Singleton {
	protected static Singleton uniqueInstance;
 
	// other useful instance variables here
 
	protected Singleton() {}
 
	public static synchronized Singleton getInstance() {
		System.out.println("I'm calling Singleton's getInstance");
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
			System.out.println("...and creating a new instance");
		}
		return uniqueInstance;
	}
 
	// other useful methods here
}
