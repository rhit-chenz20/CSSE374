package mainApp;


/**
 * Class: MainApp
 * @author R_004
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {

	private DataGraphComponent graph;

	
	public MainApp() {
		graph = new DataGraphComponent();

	}
	
	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
	} // main

}