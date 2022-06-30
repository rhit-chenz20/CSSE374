package headfirst.designpatterns.factory.pizzaaf;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String[] items) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ChicagoPizzaIngredientFactory();
		String name = "Chicago Style ";
		
		if (items[0].equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory, null);
			name+="Cheese ";
//			pizza.setName("Chicago Style Cheese Pizza");

		} else if (items[0].equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			name+="Veggie ";
//			pizza.setName("Chicago Style Veggie Pizza");

		} else if (items[0].equals("clam")) {

			pizza = new ClamPizza(ingredientFactory, null);
			name+="Clam ";
//			pizza.setName("Chicago Style Clam Pizza");

		} else if (items[0].equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			name+="Pepperoni ";
//			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		
		for(int i = 1; i < items.length; i++) {
			pizza = new ClamPizza(ingredientFactory, pizza);
			name+="Clam ";
		}
		pizza.setName(name+"Pizza");
		
		
		return pizza;
	}
}
