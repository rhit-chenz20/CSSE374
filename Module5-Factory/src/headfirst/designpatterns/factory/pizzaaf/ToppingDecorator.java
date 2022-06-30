package headfirst.designpatterns.factory.pizzaaf;

public abstract class ToppingDecorator extends Pizza{
	public PizzaIngredientFactory ingredientFactory;
	public Pizza pizza;
	
	public ToppingDecorator(PizzaIngredientFactory ingredientFactory, Pizza temp) {
		super();
		this.ingredientFactory = ingredientFactory;
		this.pizza = temp;
	}
	
	public void subPrepare() {
		if(name != null) {
			System.out.println("Preparing " + name);
		}
		if(pizza != null) {
			pizza.prepare();
			dough = pizza.dough;
			sauce = pizza.sauce;
			cheese.addAll(pizza.cheese);
			veggies.addAll(pizza.veggies);
			pepperoni.addAll(pizza.pepperoni);
			clams.addAll(pizza.clams);
		}else {
			dough = ingredientFactory.createDough();
			sauce = ingredientFactory.createSauce();
		}
	}
}
