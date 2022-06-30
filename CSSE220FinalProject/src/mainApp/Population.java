package mainApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 
 * @author chenz20
 *
 */

public class Population {
	private ArrayList<Chromosome> chromosomes;
	private HammingDiversity diver;
	private DataGraph graph;
	private Random ran;
	private FitnessFunction fitF;
	private Selection sel;
	private int generation;

	public Population(DataGraph data, int populationSize, int genoLength, 
			FitnessFunction fitF, Selection sel) {
		this.graph = data;
		this.fitF = fitF;
		this.sel = sel;
		this.diver = new HammingDiversity();
		this.chromosomes = new ArrayList<Chromosome>();	
		this.generation = 0;
		this.ran = new Random();
		ArrayList<Integer> allFit = new ArrayList<>();
		for(int i = 0;i < populationSize; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j < genoLength; j++) {
				temp.add(ran.nextInt(2));
			}
			Chromosome temc = new Chromosome(temp, i+".txt");
			temc.setFitness(this.fitF.determineFitness(temp));
			allFit.add(temc.fitness);
			chromosomes.add(temc);
		}
		checkOdd();
		this.graph.clearAll();
	}
	
	public void step() {
		this.sel.setCurGen(chromosomes);
		this.sel.reproduce();
		for(int i = 0; i < this.chromosomes.size(); i++) {
			Chromosome temp = new Chromosome(this.sel.getNextGen().get(i).getGenes(), 
					this.sel.getNextGen().get(i).getFilename());
			temp.setFitness(this.fitF.determineFitness(temp.getGenes()));
			this.chromosomes.set(i, temp);
		}
		generation++;
//		popcom update here
//		popcom.update(getAllFitness());
		Collections.sort(this.chromosomes);
//		best chro update here
//		bestFit.update(chromosomes.get(0).getGenes());
		int max = chromosomes.get(0).getFitness();
		int min = chromosomes.get(chromosomes.size() - 1).getFitness();
		int totalFitness = 0;
		for(int i = 0;i < this.chromosomes.size();i++)
		{
			totalFitness += chromosomes.get(i).getFitness();
			
		}
		int div = this.diver.calculateDiver(chromosomes);
		this.graph.update((Integer)(totalFitness / chromosomes.size()), max, min, div);
	}

	private void checkOdd() {
		if(this.chromosomes.size() != 1 && this.chromosomes.size() % 2 != 0) {
			chromosomes.remove(chromosomes.size() - 1);
		}
	}

	public int getGeneration() {
		return this.generation;
	}
}
