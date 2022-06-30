package mainApp;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Class: RoutteleWheel
 * @author R_004
 * <br>Purpose: Used to determine parents of next generation by routtele wheel selection
 * <br>For example: 
 * <pre>
 *    Selection selection = new RoutteleWheel(population, 0.1, true, 20);
 * </pre>
 */

public class SelectionRoutteleWheel extends SelectionBasic {

	public SelectionRoutteleWheel( double mu, int e) {
		super(mu, e);
	}

	@Override
	public void determineParent() {
		Collections.sort(currentGen);
		
		HashMap<Double[], Chromosome> partial = new HashMap<Double[], Chromosome>();
		Random ran = new Random();
		double totalFitness = 0;
		double previous = 0;
		
		
		for(int i = eNum; i < currentGen.size(); i++) {
			totalFitness += currentGen.get(i).getFitness();
		}
		
		for(int i = eNum; i < currentGen.size(); i++) {
			
			BigDecimal gapValue = new BigDecimal((currentGen.get(i).getFitness() * 100) / totalFitness);
			Double gap = gapValue.doubleValue();
			
			Double[] temp = new Double[2];
			temp[0] = previous;
			temp[1] = previous + gap;
			partial.put(temp, currentGen.get(i));
			previous += gap;
		}
		
		int count = eNum;
		while(count < currentGen.size() / 2) {
			int target = ran.nextInt(100);
			for(Double[] key: partial.keySet()) {
				if(target >= key[0] && target < key[1] && !parent.contains(partial.get(key))) {
					this.parent.add(partial.get(key));
					count++;
					break;
				}
			}
		}	
	}
}

