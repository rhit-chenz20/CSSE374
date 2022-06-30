package mainApp;

public class MethodFactory {
	public static final ChromosomeTarget DEFAULT_TARGET = ChromosomeTarget.getInstance("sample.txt");
	
	public Selection getSelection(String sel, double mutate, int e) {
		if(sel.equals("Truncation")) {
			return new SelectionTruncation(mutate, e);
		}else if(sel.equals("Rank Selection")) {
			return new SelectionRank(mutate, e);
		}else if(sel.equals("Routtele Wheel Selection")) {
			return new SelectionRoutteleWheel(mutate,e);
		}
		return null;
	}
	
	public FitnessFunction getFit(String fit) {
		if(fit.equals("Total Number of 1s")) {
			return new FitnessTotalNumberOf1();
		}else if(fit.equals("Target Chromosome")) {
			return new FitnessTargetGenes(DEFAULT_TARGET);
		}else if(fit.equals("Consecutive 1s")) {
			return new FitnessConsecutive();
		}else if(fit.equals("Magic Dance")) {
			return new FitnessMagicDance();
		}
		return null;
	}
}
