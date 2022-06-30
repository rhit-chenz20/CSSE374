package mainApp;

import java.util.ArrayList;

/**
 * Class: FitnessFunction
 * @author R_004
 * <br>Purpose: An interface to determine the fitness of a chromosome using different methods
 * <br>Restrictions: Cannot be initialized as FitnessFunction itself
 * <br>For example: 
 * <pre>
 *    FitnessFunction func1 = new ConsecutiveFunction(chromosome);
 * </pre>
 */
 

public interface FitnessFunction {
	public int determineFitness(ArrayList<Integer> genes);
}
