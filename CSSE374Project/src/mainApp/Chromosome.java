package mainApp;

import java.util.ArrayList;
import java.util.Random;

public class Chromosome {
	private ArrayList<Integer> genes;
	private int fitness;
	
	public Chromosome(ArrayList<Integer> newgene) {
		ArrayList<Integer> genes = new ArrayList<Integer>();
		for(int i = 0; i < newgene.size(); i++) {
			genes.add(newgene.get(i));
		}
		this.genes = genes;
		this.fitness = -1;
	}
	
	public Chromosome(Chromosome that) {
		this(that.genes);
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
	}
	
	public void mutateAll(double rate) {
		for(int i = 0; i < genes.size(); i++) {
			mutate(i,rate);
		}
	}
	
	public void determine2() {
		
	}
}
