package mainApp;

import java.util.ArrayList;

/**
 * Class: ConsecutiveFunction
 * @author R_004
 * <br>Purpose: Used to determine a chromosome's fitness depending on the longest length of consecutive 1s in its genes
 * <br>For example: 
 * <pre>
 *    FitnessFunction func1 = new ConsecutiveFunction(chromosome);
 * </pre>
 */
public class FitnessConsecutive implements FitnessFunction {
	@Override
	public int determineFitness(ArrayList<Integer> genes) {
		int record = 0;
		int count = 0;
		for(int i = 0; i < genes.size(); i++) {
			if(genes.get(i) == 1) {
				count++;
				if(count > record) record = count;
			}else {
				count = 0;
			}
		}
		return record;
	}
}
