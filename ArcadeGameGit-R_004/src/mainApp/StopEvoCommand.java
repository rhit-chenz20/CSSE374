package mainApp;

import javax.swing.Timer;

public class StopEvoCommand implements Command {

	private Timer timer;
	
	public StopEvoCommand(Timer timer) {
		this.timer = timer;
	}
	
	@Override
	public void execute() {
		System.out.println("Timer stopped!");
		timer.stop();
	}

}
