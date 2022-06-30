package mainApp;

import javax.swing.JButton;

public class Button extends JButton{
	private Command command;
	
	public Button(String text) {
		super(text);
	}
	
	public void setCommand(Command com) {
		this.command = com;
	}
	
	public void pressed() {
		this.command.execute();
	}
	
}
