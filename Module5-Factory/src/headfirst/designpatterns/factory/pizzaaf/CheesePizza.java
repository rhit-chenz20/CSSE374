package headfirst.designpatterns.factory.pizzaaf;

public class CheesePizza extends ToppingDecorator {
 
	public CheesePizza(PizzaIngredientFactory ingredientFactory, Pizza pizza) {
		super(ingredientFactory, pizza);
	}
 
	public void prepare() {
		subPrepare();
		cheese.add(ingredientFactory.createCheese());
	}
}
