package mainApp;

import java.util.ArrayList;

/**
 * Class: FitnessTargetGenes
 * @author R_004
 * <br>Purpose: Used to determine a chromosome's fitness depending on how many genes are identical to a target chromosome
 * <br>For example: 
 * <pre>
 *    FitnessFunction func1 = new FitnessTargetGenes(chromosome, targetChromosome);
 * </pre>
 */
public class FitnessTargetGenes implements FitnessFunction {
	private ChromosomeTarget target;

	public FitnessTargetGenes(ChromosomeTarget target) {
		this.target = target;
	}

	@Override
	public int determineFitness(ArrayList<Integer> genes) {
		int fitness = 0;
		for(int i = 0; i < Math.min(target.getGenes().size(), genes.size()); i++) {
			if(target.getGenes().get(i) == genes.get(i)) fitness++;
		}
		return fitness;
	}
	
}
