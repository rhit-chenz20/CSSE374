public class StarbuzzCoffee {
	
 
	public static void main(String args[]) {	
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() 
				+ " $" + String.format("%.2f", beverage.cost()));
 
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + String.format("%.2f", beverage2.cost()));
		beverage2 = removeDec(beverage2, "Whip");
		System.out.println(beverage2.getDescription() 
				+ " $" + String.format("%.2f", beverage2.cost()));
		beverage2 = removeDec(beverage2, "Mocha");
		System.out.println(beverage2.getDescription() 
				+ " $" + String.format("%.2f", beverage2.cost()));
 
		Beverage beverage3 = new HouseBlend();
		beverage3 = removeDec(beverage3, "Whip");
		beverage3.setSize(Beverage.Size.VENTI);
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() 
				+ " $" + String.format("%.2f", beverage3.cost()));
		beverage3 = removeDec(beverage3, "Whip");
		System.out.println(beverage3.getDescription() 
				+ " $" + String.format("%.2f", beverage3.cost()));
	}
	
	public static Beverage removeDec(Beverage bev, String dec) {
		Beverage ori = bev;
		
		if(bev.getClass().getName().equals(dec) && bev instanceof CondimentDecorator) {
			return ((CondimentDecorator)bev).beverage;
		}
		
		if(!(bev instanceof CondimentDecorator)) {
			return bev;
		}
		
		ori = removeDec(((CondimentDecorator)bev).beverage, dec);
		
		String name = bev.getClass().getName();
		if(name.equals("Whip")) {
			ori = new Whip(ori);
		}else if(name.equals("Milk")) {
			ori = new Milk(ori);
		}else if(name.equals("Mocha")) {
			ori = new Mocha(ori);
		}else if(name.equals("Soy")) {
			ori = new Soy(ori);
		}

		return ori;
	}
}
