package mainApp;

import java.util.ArrayList;

/**
 * Class: TotalNumberOf1
 * @author R_004
 * <br>Purpose: Used to determine a chromosome's fitness depending on the total number of 1s in its genes
 * <br>For example: 
 * <pre>
 *    FitnessFunction func1 = new TotalNumberOf1(chromosome);
 * </pre>
 */
public class FitnessTotalNumberOf1 implements FitnessFunction {
	
	@Override
	public int determineFitness(ArrayList<Integer> genes) {
		// TODO Auto-generated method stub
		int fitness = 0;
		
		for(int i = 0; i < genes.size(); i++) {
			if(genes.get(i) == 1) fitness++;
		}
		
		return fitness;
	}
}
