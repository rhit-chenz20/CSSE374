package mainApp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Class: Rank
 * @author R_004
 * <br>Purpose: Used to determine parents of next generation by rank selection
 * <br>For example: 
 * <pre>
 *    Selection selection = new Rank(population, 0.1, true, 20);
 * </pre>
 */

public class SelectionRank extends SelectionBasic {

	public SelectionRank(double mutateRate, int elitismPer) {
		super(mutateRate, elitismPer);
	}

	@Override
	public void determineParent() {
		Collections.sort(currentGen);
		
		HashMap<Integer[], Chromosome> partial = new HashMap<Integer[], Chromosome>();
		Random ran = new Random();
		int previous = 0;
		int totalNum = 0;
		
		for(int i = 0; i < currentGen.size() + 1; i++) {
			totalNum += i;
		}
		
		for(int i = eNum; i < currentGen.size() / 2; i++) {
			int gap = currentGen.size() - i;
			Integer[] temp = new Integer[2];
			temp[0] = previous;
			temp[1] = previous + gap;
			previous += gap;
			partial.put(temp, currentGen.get(i));
		}
		
		int count = eNum;
		while(count < currentGen.size() / 2) {
			int target = ran.nextInt(totalNum);
			for(Integer[] key: partial.keySet()) {
				if(target >= key[0] && target < key[1] && !parent.contains(partial.get(key))) {
					this.parent.add(partial.get(key));
					count++;
					break;
				}
			}
		}
		
	}

	
}
