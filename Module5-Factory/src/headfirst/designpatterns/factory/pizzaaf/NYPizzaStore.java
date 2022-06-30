package headfirst.designpatterns.factory.pizzaaf;

public class NYPizzaStore extends PizzaStore {
 
	protected Pizza createPizza(String[] items) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = 
			new NYPizzaIngredientFactory();
		String name = "New York Style ";
		
		for(int i = 0; i < items.length; i++) {
			
			if (items[i].equals("cheese")) {

				pizza = new CheesePizza(ingredientFactory, pizza);
				name+="Cheese ";

			} else if (items[i].equals("veggie")) {

				pizza = new VeggiePizza(ingredientFactory, pizza);
				name+="Veggie ";

			} else if (items[i].equals("clam")) {

				pizza = new ClamPizza(ingredientFactory, pizza);
				name+="Clam ";

			} else if (items[i].equals("pepperoni")) {

				pizza = new PepperoniPizza(ingredientFactory, pizza);
				name+="Pepperoni ";

			}
		}
		
		pizza.setName(name + "Pizza");
		return pizza;
	}
}
