package headfirst.designpatterns.factory.pizzaaf;

public class ClamPizza extends ToppingDecorator {
	
	public ClamPizza(PizzaIngredientFactory ingredientFactory, Pizza pizza) {
		super(ingredientFactory, pizza);
	}
 
	public void prepare() {
		subPrepare();
		clams.add(ingredientFactory.createClam());
	}
}
