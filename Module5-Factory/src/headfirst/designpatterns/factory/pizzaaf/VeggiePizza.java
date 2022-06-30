package headfirst.designpatterns.factory.pizzaaf;

public class VeggiePizza extends ToppingDecorator {

	public VeggiePizza(PizzaIngredientFactory ingredientFactory, Pizza pizza) {
		super(ingredientFactory, pizza);
	}
 
	public void prepare() {
		subPrepare();
		veggies.add(ingredientFactory.createVeggies());
	}

}
