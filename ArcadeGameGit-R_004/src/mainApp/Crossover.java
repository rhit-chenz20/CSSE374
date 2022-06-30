package mainApp;

import java.util.ArrayList;
import java.util.Random;

public class Crossover extends SelectionDecorator {

	public Crossover(Selection newSelection) {
		super(newSelection);
	}


	@Override
	public void reproduce() {
		elitism();
		determineParent();
		crossover();
		mutate();
	}
	
	private void crossover() {
		for(int i = 0;i < Math.min(getCurGen().size() / 2 - 1, getCurGen().size() - getE()); i+=2)
			{
				int parent1Index = i;
				int parent2Index = i + 1;
				int child1Index = parent1Index + Math.max(getCurGen().size() / 2, getE());
				int child2Index = parent2Index + Math.max(getCurGen().size() / 2, getE());

				Chromosome parent1 = getCurGen().get(i);
				Chromosome parent2 = getCurGen().get(i + 1);
				ArrayList<Integer> child1 = new ArrayList<Integer>();
				ArrayList<Integer> child2 = new ArrayList<Integer>();
				
				Random ran = new Random(); 
				int changeIndex = ran.nextInt(parent1.getGenes().size());
				
				for(int j = 0;j < parent1.getGenes().size();j++)
				{
					if(j < changeIndex) {
						child1.add(parent1.getGenes().get(j));
						child2.add(parent2.getGenes().get(j));
					}else {
						child1.add(parent2.getGenes().get(j));
						child2.add(parent1.getGenes().get(j));
					}
					
				}
				Chromosome child11 = new Chromosome(child1, "Chromosome" + child1Index + ".txt");
				addNextGen(child11);
				if(child2Index < getCurGen().size()) {
					Chromosome child22 = new Chromosome(child2, "Chromosome" + child2Index + ".txt");
					addNextGen(child22);
				}
					
			}
	}

}
