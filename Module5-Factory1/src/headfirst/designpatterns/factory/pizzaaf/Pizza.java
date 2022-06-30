package headfirst.designpatterns.factory.pizzaaf;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	
	PizzaIngredientFactory ingredientFactory;
	Pizza temp;

	ArrayList<Dough> doughs;
	ArrayList<Sauce> sauces;
	ArrayList<Veggies[]> veggies;
	ArrayList<Cheese> cheese;
	ArrayList<Pepperoni> pepperoni;
	ArrayList<Clams> clams;
	
	public Pizza(PizzaIngredientFactory ingredientFactory, Pizza pizza) {
		this.ingredientFactory = ingredientFactory;
		temp = pizza;
		doughs = new ArrayList<Dough>();
		sauces = new ArrayList<Sauce>();
		veggies = new ArrayList<Veggies[]>();
		cheese = new ArrayList<Cheese>();
		pepperoni = new ArrayList<Pepperoni>();
		clams = new ArrayList<Clams>();
	}
	
	public void basic() {
		doughs.add(ingredientFactory.createDough());
		sauces.add(ingredientFactory.createSauce());
	}

	abstract void prepare();
	
	void getPrevious() {
		if(temp!=null) {
			doughs = temp.doughs;
			sauces = temp.sauces;
			veggies = temp.veggies;
			cheese = temp.cheese;
			pepperoni = temp.pepperoni;
			clams = temp.clams;
//			System.out.println(temp);
		}else {
			basic();
		}
	}

	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (!doughs.isEmpty()) {
			for(Dough d: doughs) {
				result.append(d);
				result.append("\n");
			}
		}
		if (!sauces.isEmpty()) {
			for(Sauce d: sauces) {
				result.append(d);
				result.append("\n");
			}
		}
		if (!cheese.isEmpty()) {
			for(Cheese d: cheese) {
				result.append(d);
				result.append("\n");
			}
		}
		if (!veggies.isEmpty()) {
			for(Veggies[] veggies: veggies) {
				for (int i = 0; i < veggies.length; i++) {
					result.append(veggies[i]);
					if (i < veggies.length-1) {
						result.append(", ");
					}
				}
				result.append("\n");
			}
			
		}
		if (clams.isEmpty()) {
			for(Clams d: clams) {
				result.append(d);
				result.append("\n");
			}
		}
		if (pepperoni.isEmpty()) {
			for(Pepperoni d: pepperoni) {
				result.append(d);
				result.append("\n");
			}
		}
		return result.toString();
	}
}
