package singleton.chocolate;
 
public class ChocolateController {
	public static void main(String args[]) {
		System.out.println("We can do other things before lazy instantiation of the boiler.");
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		boiler.fill();
		boiler.boil();
		boiler.drain();

		System.out.println("Now we try to create another one, without luck.");
		// will return the existing instance
		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
		System.out.println("Boiler 2 is empty? "+boiler2.isEmpty());
		System.out.println("Bolier 2 is boiled? "+boiler2.isBoiled());
	}
}
