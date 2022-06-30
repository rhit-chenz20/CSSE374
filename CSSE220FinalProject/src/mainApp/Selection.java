package mainApp;

import java.util.ArrayList;

/**
 * Class: Selection
 * @author R_004
 * <br>Purpose: An interface to select parents usind different methods and reproduce
 * <br>Restrictions: Cannot be initialized as Selection itself
 * <br>For example: 
 * <pre>
 *    Selection selection = new RoutteleWheel(population, 0.1, true, 20);
 * </pre>
 */
 

public interface Selection {

	abstract void determineParent();
	abstract void reproduce();
	abstract void duplicateParent();
	abstract void mutate();
	abstract void elitism();
	
	abstract ArrayList<Chromosome> getNextGen();
	abstract ArrayList<Chromosome> getCurGen();
	abstract ArrayList<Chromosome> getParent();
	abstract int getE();
	abstract double getMuta();
	
	abstract void addCurGen(Chromosome input);
	abstract void addParent(Chromosome input);
	abstract void addNextGen(Chromosome input);
	
	abstract void setCurGen(ArrayList<Chromosome> pop);
	abstract void setMutationRate(double input);
	abstract void setElitismNum(int input);
}
