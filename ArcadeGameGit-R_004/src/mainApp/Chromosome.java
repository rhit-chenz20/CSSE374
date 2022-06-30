package mainApp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class: Chromosome
 * @author R_004
 * <br>Purpose: get, store, and manipulate the information of a chromosome
 * <br>For example: 
 * <pre>
 *    Chromosome chromosome = new ChromosomeComponent("chromosome1.txt");
 * </pre>
 */
public class Chromosome implements Comparable<Chromosome>{
	protected ArrayList<Integer> genes;
	protected String filename;
	protected int fitness;
	
	public Chromosome(ArrayList<Integer> genes, String filename) {
		this.filename = filename;
		ChromosomeEditor.writeFile(filename, genes);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < genes.size(); i++) {
			temp.add(Integer.valueOf(genes.get(i)));
		}
		this.genes = temp;
		this.fitness = -1;
	}
	
	public Chromosome(Chromosome that) {
		this(that.genes, that.filename);
	}
	
	public Chromosome(String filename) {
		this(ChromosomeEditor.readFile(filename), filename);
	}
	
	public void mutate(int index, double rate) {
		Random ran = new Random();
		double num = ran.nextDouble(100);
		if(num < rate) {
			if(genes.get(index) == 1) {
				genes.set(index, 0);
			}else {
				genes.set(index, 1);
			}
		}
		ChromosomeEditor.writeFile(filename, genes);
	}
	
	public void mutateAll(double rate) {
		for(int i = 0; i < genes.size(); i++) {
			Random ran = new Random();
			double num = ran.nextDouble(100);
			if(num < rate) {
				if(genes.get(i) == 1) {
					genes.set(i, 0);
				}else {
					genes.set(i, 1);
				}
			}
		}
		ChromosomeEditor.writeFile(filename, genes);
	}

	@Override
	public int compareTo(Chromosome other) {
		if(this.fitness < other.fitness)
			return 1;
		else if (this.fitness > other.fitness)
			return -1;
		else
		return 0;  
	}
	
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	public int getFitness() {
		return this.fitness;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public ArrayList<Integer> getGenes(){
		return this.genes;
	}
}
