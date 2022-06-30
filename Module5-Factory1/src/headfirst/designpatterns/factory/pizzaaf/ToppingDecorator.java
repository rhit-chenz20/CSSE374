package headfirst.designpatterns.factory.pizzaaf;

public abstract class ToppingDecorator extends Pizza{
	public PizzaIngredientFactory ingredientFactory;
	public Pizza pizza;
	
	public ToppingDecorator(PizzaIngredientFactory ingredientFactory, Pizza temp) {
		super(ingredientFactory);
		this.ingredientFactory = ingredientFactory;
		this.pizza = temp;
	}
	
	public abstract void prepare();

}
