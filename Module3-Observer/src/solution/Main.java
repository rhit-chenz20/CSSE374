package solution;

public class Main {
	public static void main(String[] args){
		MyFrame myFrame = new MyFrame();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		
		MyOtherFrame myOtherFrame = new MyOtherFrame();
		myOtherFrame.setLocationRelativeTo(null);
		myOtherFrame.setVisible(true);
		
		SomeoneElsesFrame otherFrame = new SomeoneElsesFrame(10);
		otherFrame.setVisible(true);
		
		myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
		myOtherFrame.setDefaultCloseOperation(myOtherFrame.EXIT_ON_CLOSE);
	}
}
