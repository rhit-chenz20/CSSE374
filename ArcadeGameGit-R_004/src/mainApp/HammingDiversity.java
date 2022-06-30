package mainApp;

import java.util.ArrayList;


/**
 * Class: HammingDiversity
 * @author R_004
 * <br>Purpose: Used to calculate the hamming diversity of a population
 * <br>For example: 
 * <pre>
 *    HammingDiversity diver = new HammingDiversity();
 * </pre>
 */

public class HammingDiversity {

	public int calculateDiver(ArrayList<Chromosome> pop) {
		int genoLength = pop.get(0).getGenes().size();
		int pairs = 0;
		int numberOfPairs = (genoLength * (genoLength - 1)) / 2;

		for(int i = 0; i < genoLength; i++) {
			int num1 = 0;
			int num0 = 0;
			for(int j = 0; j < pop.size(); j++) {
				if(pop.get(j).getGenes().get(i) == 1) num1++;
				else num0++;
			}
			
			pairs += (num0 * num1);
		}
		
		
		return pairs / numberOfPairs;
	}
}

	