

public abstract class Beverage {
	public enum Size { TALL, GRANDE, VENTI };
	Size size = Size.TALL; // Default size
	String description = "Unknown Beverage";
  
	public String getDescription() { // Combines size and type of drink
		return size + " " + description;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return this.size;
	}
 
	public abstract double cost();
	
	public double sizeCost() {
		switch (this.size) {
		case TALL: return 0.0;
		case GRANDE: return 0.50;
		case VENTI: return 1.00;
		default: return 0.0;
		}
	}
}
