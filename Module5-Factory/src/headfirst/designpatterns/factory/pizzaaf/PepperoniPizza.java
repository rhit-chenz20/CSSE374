package headfirst.designpatterns.factory.pizzaaf;

public class PepperoniPizza extends ToppingDecorator {

	public PepperoniPizza(PizzaIngredientFactory ingredientFactory, Pizza pizza) {
		super(ingredientFactory, pizza);
	}
 
	public void prepare() {
		subPrepare();
		pepperoni.add(ingredientFactory.createPepperoni());
	}
}
