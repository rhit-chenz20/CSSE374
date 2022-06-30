package mainApp;

import java.util.ArrayList;

abstract class SelectionDecorator implements Selection {

	protected Selection temp;
	
	public SelectionDecorator(Selection newSelection) {
		temp = newSelection;
	}
	
	@Override
	public void determineParent() {
		temp.determineParent();
	}

	@Override
	public void reproduce() {
		temp.reproduce();
	}

	@Override
	public void duplicateParent() {
		temp.duplicateParent();
	}

	@Override
	public void mutate() {
		temp.mutate();
		
	}

	@Override
	public void elitism() {
		temp.elitism();
	}

	@Override
	public ArrayList<Chromosome> getNextGen() {
		return temp.getNextGen();
	}

	@Override
	public ArrayList<Chromosome> getCurGen() {
		// TODO Auto-generated method stub
		return temp.getCurGen();
	}

	@Override
	public ArrayList<Chromosome> getParent() {
		// TODO Auto-generated method stub
		return temp.getParent();
	}
	
	@Override
	public int getE() {
		return temp.getE();
	}
	
	@Override
	public double getMuta() {
		return temp.getMuta();
	}

	@Override
	public void addCurGen(Chromosome input) {
		// TODO Auto-generated method stub
		temp.addCurGen(input);
	}

	@Override
	public void addParent(Chromosome input) {
		// TODO Auto-generated method stub
		temp.addParent(input);
	}

	@Override
	public void addNextGen(Chromosome input) {
		// TODO Auto-generated method stub
		temp.addNextGen(input);
	}
	
	@Override
	public void setCurGen(ArrayList<Chromosome> pop) {
		temp.setCurGen(pop);
	}
	
	@Override
	public void setMutationRate(double input) {
		temp.setMutationRate(input);
	}
	
	@Override
	public void setElitismNum(int input) {
		temp.setElitismNum(input);
	}
}
