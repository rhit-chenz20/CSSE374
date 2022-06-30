package mainApp;

public class ChromosomeTarget extends Chromosome {
	private static ChromosomeTarget uniqueInstance;

	private ChromosomeTarget(String filename) {
		super(ChromosomeEditor.readFile(filename), filename);
	}

	public static synchronized ChromosomeTarget getInstance(String filename) {
		if (uniqueInstance == null) {
			uniqueInstance = new ChromosomeTarget(filename);
		}
		return uniqueInstance;
	}
	
	public void changeFile(String name) {
		filename = name;
		genes = ChromosomeEditor.readFile(name);
	}
}
