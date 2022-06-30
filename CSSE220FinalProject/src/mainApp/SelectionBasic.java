package mainApp;

import java.util.ArrayList;

abstract class SelectionBasic implements Selection{
	public ArrayList<Chromosome> currentGen;
	public ArrayList<Chromosome> parent;
	public ArrayList<Chromosome> nextGen;
	public double mutationRate;
	public int eNum;
	
	public SelectionBasic(double mutationRate, int e) {
		currentGen = new ArrayList<Chromosome>();
		parent = new ArrayList<Chromosome>();
		nextGen = new ArrayList<Chromosome>();
		this.mutationRate = mutationRate;
		this.eNum = e;
	}

	@Override
	public void reproduce() {
		parent = new ArrayList<Chromosome>();
		nextGen = new ArrayList<Chromosome>();
		elitism();
		determineParent();
		duplicateParent();
		mutate();
	}

	@Override
	public void duplicateParent() {
		nextGen.addAll(parent);
		for(int i = 0; i < parent.size(); i++) {
			nextGen.add(new Chromosome(parent.get(i).getGenes(), currentGen.get(i+parent.size() - 1).getFilename()));
		}
	}

	@Override
	public void mutate() {
		for(int i = eNum; i < nextGen.size(); i++) {
			nextGen.get(i).mutateAll(this.mutationRate);
		}
	}

	@Override
	public void elitism(){
		for(int i = 0; i < eNum; i++) {
			this.parent.add(currentGen.get(i));
			this.nextGen.add(currentGen.get(i));
		}
	}

	@Override
	public ArrayList<Chromosome> getNextGen() {
		// TODO Auto-generated method stub
		return nextGen;
	}

	@Override
	public ArrayList<Chromosome> getCurGen() {
		// TODO Auto-generated method stub
		return currentGen;
	}

	@Override
	public ArrayList<Chromosome> getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
	
	@Override
	public int getE() {
		return eNum;
	}
	
	@Override
	public double getMuta() {
		return mutationRate;
	}

	@Override
	public void addCurGen(Chromosome input) {
		// TODO Auto-generated method stub
		currentGen.add(input);
	}

	@Override
	public void addParent(Chromosome input) {
		// TODO Auto-generated method stub
		parent.add(input);
	}

	@Override
	public void addNextGen(Chromosome input) {
		// TODO Auto-generated method stub
		nextGen.add(input);
	}
	
	@Override
	public void setCurGen(ArrayList<Chromosome> pop) {
		this.currentGen = pop;
	}
	
	@Override
	public void setMutationRate(double input) {
		this.mutationRate = input;
	}
	
	@Override
	public void setElitismNum(int input) {
		this.eNum = input;
	}
	
}
