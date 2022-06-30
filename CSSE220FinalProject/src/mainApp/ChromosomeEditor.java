package mainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**Class: ChromosomeReader
 * @author R_004
 * 
 * <br>Purpose: Used to create, stored, and get information of chromosome from a txt file
 * <br>For example: 
 * <pre>
 *    ChromosomeEditor editor = new ChromosomeEditor();
 * </pre>
 */
public class ChromosomeEditor {
	
	/**
	 * ensures: write genes into existing file; if doesn't exist, create it
	 * @param fileName of file storing chromosome
	 * @param inputGenes genes of chromosome that's either new or changed from old chromosome
	 */
	public static void writeFile(String fileName, ArrayList<Integer> inputGenes) {
	
		PrintWriter pw = null;
		
		try {
			
			pw = new PrintWriter("chromosomes/" + fileName);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		for(int i : inputGenes) {
			pw.println(i);
		}
		
		pw.close();
	}
	
	/**
	 * ensures: scan the file and store all integers in genes
	 * @param fileName of the wanted file
	 */
	public static ArrayList<Integer>  readFile(String fileName) {
		ArrayList<Integer> genes = new ArrayList<Integer>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("chromosomes/" + fileName));
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "is not found");
			e.printStackTrace();
			return genes;
		}
		
		while (scanner.hasNext()) {
			int gene = scanner.nextInt();
			genes.add(gene);
		}
		
		scanner.close();
		return genes;
		
	}
}
