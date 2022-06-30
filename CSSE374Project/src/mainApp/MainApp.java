package mainApp;

import java.util.ArrayList;

/**
 * Class: MainApp
 * @author R_004
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {


	
	public MainApp() {
		ArrayList<Integer> genes = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			genes.add(1);
		}
		Chromosome test = new Chromosome(genes);
		Chromosome test1 = new Chromosome(test.genes);
		System.out.println(test1.genes == test.genes);
		System.out.println(test1.genes.equals(test.genes));
	}
	
	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		
	} // main

}