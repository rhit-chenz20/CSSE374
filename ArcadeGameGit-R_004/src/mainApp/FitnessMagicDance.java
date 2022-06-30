package mainApp;

import java.util.ArrayList;

public class FitnessMagicDance implements FitnessFunction {
	
	private int remainDays;
	
	public FitnessMagicDance() {
		remainDays = 1000;
	}

	public void setDays(int day) {
		remainDays = 1000 - day;
	}
	
	@Override
	public int determineFitness(ArrayList<Integer> genes) {
//		if(this.fitness == -1)
//		this.fitness = 1 + (19 * remainDays) / 1000;
		return 0;
	}
}
