package headfirst.designpatterns.factory.pizzaaf;

public abstract class PizzaStore {
 
	protected abstract Pizza createPizza(String[] items);
 
	public Pizza orderPizza(String... args) {
		Pizza pizza = createPizza(args);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
