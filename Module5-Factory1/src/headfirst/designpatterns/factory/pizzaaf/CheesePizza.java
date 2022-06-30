package headfirst.designpatterns.factory.pizzaaf;

public class CheesePizza extends Pizza {

	public CheesePizza(PizzaIngredientFactory ingredientFactory, Pizza pizza) {
		super(ingredientFactory, pizza);
		this.name = "Cheese";
	}
 
	void prepare() {

		System.out.println("Preparing " + name);

		getPrevious();
		cheese.add(ingredientFactory.createCheese()) ;
	}
}
