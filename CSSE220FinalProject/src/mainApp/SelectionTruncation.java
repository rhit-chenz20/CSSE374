package mainApp;

import java.util.Collections;

/**
 * Class: Truncation
 * @author R_004
 * <br>Purpose: Used to determine parents of next generation by truncation
 * <br>For example: 
 * <pre>
 *    Selection selection = new Truncation(population, 0.1, true, 20);
 * </pre>
 */

public class SelectionTruncation extends SelectionBasic {

	public SelectionTruncation(double mutateRate, int e) {
		super(mutateRate, e);
	}

	@Override
	public void determineParent() {
		Collections.sort(currentGen);
		
		if(currentGen.size() == 1) {
			parent.add(currentGen.get(0));
			return;
		}
		
		for(int i = eNum; i < currentGen.size() / 2; i++) {
			parent.add(currentGen.get(i));
		}
	}
}
