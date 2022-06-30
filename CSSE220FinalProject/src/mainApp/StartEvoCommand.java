package mainApp;

import javax.swing.Timer;

public class StartEvoCommand implements Command {
	private Timer timer;
	private Button start;
	
	public StartEvoCommand(Timer timer, Button button) {
		this.timer = timer;
		this.start = button;
	}

	@Override
	public void execute() {
		System.out.println("Timer started!");
		start.setText("Stop");
		timer.start();
	}

}
