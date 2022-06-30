package mainApp;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class: AllPopulationComponent
 * @author R_004
 * <br>Purpose: Used to handle the window with all individual's fitness
 * <br>For example: 
 * <pre>
 *    AllPopulationComponent popCom = new AllPopulationComponent(pop.getFitness);
 * </pre>
 *
 */

public class AllPopulationComponent extends JComponent{
	private JFrame frame;
	private AllPopulationGraph graph;
	private JPanel head;
	private JPanel body;
	private JLabel title;
	
	public AllPopulationComponent(AllPopulationGraph input) {
		frame = new JFrame();
		frame.setTitle("Yo");
		title = new JLabel("Fitness of All Organisms");
		graph = input;
		head = new JPanel();
		body = new JPanel();
		head.add(title);
		body.add(graph);
		frame.add(head, BorderLayout.NORTH);
		frame.add(body, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
