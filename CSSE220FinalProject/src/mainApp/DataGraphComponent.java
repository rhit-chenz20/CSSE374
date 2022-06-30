package mainApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class: DataGraphComponent
 * @author R_004
 * <br>Purpose: Used to handle the window with user interface and graph drawing
 * <br>For example: 
 * <pre>
 *    DataGraphComponent dataCom = new DataGraphComponent();
 * </pre>
 *
 */

public class DataGraphComponent extends JComponent{
	public static final Dimension PREF_TEXT_SIZE = new Dimension(40, 20);
	
	private JFrame frame;
	private Timer timer;

	private JLabel title;
	
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	
	private JLabel mLabel;
	private JTextField mInput;
	
	private JLabel fLabel;
	private JComboBox fitness;
	
	private JLabel sLabel;
	private JComboBox selection;
	
	private JLabel pLabel;
	private JTextField popInput;
	
	private JLabel gLabel;
	private JTextField genInput;
	
	private JLabel genoLabel;
	private JTextField genoInput;
	
	private JLabel cross;
	private JCheckBox crossInput;
	
	private JLabel elitism;
	private JTextField elitismInput;
	
	private JButton chooseTarget;
	
	private Button start;
	
	private ChromosomeComponent bestChro;
	
	private DataGraph data;
	private Population pop;
	private MethodFactory factory;
	private int termi;
	

	public void topContent() {
		topPanel.add(title);
	}
	
	public void centerContent() {
		centerPanel.add(data);
	}
	
	public void bottomContent() {
		
		mInput.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
			}
			
		});
		mInput.setPreferredSize(PREF_TEXT_SIZE);
		
		selection.addItem("Truncation");
		selection.addItem("Rank Selection");
		selection.addItem("Routtele Wheel Selection");
		
		selection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
				Selection sel = factory.getSelection((String)selection.getSelectedItem(),
						Double.valueOf(mInput.getText()), Integer.valueOf(elitismInput.getText()));
				FitnessFunction fit = factory.getFit((String)fitness.getSelectedItem());
				pop = new Population(data, 
//						bestChro,  
						Integer.valueOf(popInput.getText()), Integer.valueOf(genoInput.getText()),
						fit, sel);

			}
			
		});
		
		fitness.addItem("Total Number of 1s");
		fitness.addItem("Target Chromosome");
		fitness.addItem("Consecutive 1s");
		fitness.addItem("Magic Dance");
		
		fitness.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
				Selection sel = factory.getSelection((String)selection.getSelectedItem(),
						Double.valueOf(mInput.getText()), Integer.valueOf(elitismInput.getText()));
				FitnessFunction fit = factory.getFit((String)fitness.getSelectedItem());
				pop = new Population(data, 
//						bestChro,  
						Integer.valueOf(popInput.getText()), Integer.valueOf(genoInput.getText()),
						fit, sel);
			}
			
		});
		
		popInput.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
			}
			
		});
		popInput.setPreferredSize(PREF_TEXT_SIZE);
		
		genInput.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
			}
			
		});
		genInput.setPreferredSize(PREF_TEXT_SIZE);
		
		genoInput.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
			}
			
		});
		genoInput.setPreferredSize(PREF_TEXT_SIZE);

		crossInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
			}
			
		});
	
		elitismInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
			}
			
		}); 
		
		chooseTarget.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser browseChromosomeFile = new JFileChooser("C:\\Users\\chenz20\\git\\csse220-fallq-2020-21-final-project-fallq2021_r004\\chromosomes");
				int respond = browseChromosomeFile.showOpenDialog(null);
				
				if(respond == JFileChooser.APPROVE_OPTION) {
					File file = new File(browseChromosomeFile.getSelectedFile().getAbsolutePath());
//					Chromosome temp = new Chromosome(file.getName());
//					targetCom.fileUpdate("target.txt", temp.getGenes());
//					data.setTarget(file.getName());
				}
//				data.updateRepaint();
			}
			
		});
		
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!timer.isRunning()) {
					StartEvoCommand startCommand = new StartEvoCommand(timer, start);
					start.setCommand(startCommand);
			    }else {
			    	StopEvoCommand stopCommand = new StopEvoCommand(timer);
			    	start.setCommand(stopCommand);		
			    	start.setText("Continue");
			    }
				start.pressed();
			}
		});
	}
	
	public void restart() {
		Selection curSel = factory.getSelection((String)selection.getSelectedItem(),Double.valueOf(mInput.getText()), Integer.valueOf(elitismInput.getText()));
		FitnessFunction curFit = factory.getFit((String)fitness.getSelectedItem());
		pop = new Population(data, 
//				bestChro, 
				Integer.valueOf(popInput.getText()), Integer.valueOf(genoInput.getText()), curFit, curSel);
		timer.stop();
		start.setText("Start Evolution");
	}
	
	public void initialzeUI() {
		frame = new JFrame("Yo");
		
		topPanel = new JPanel();
		centerPanel = new JPanel();
		bottomPanel = new JPanel();
		
		title = new JLabel("Fitness over Generations");
		
		mLabel = new JLabel("Mutate Rate:_/N");
		mInput = new JTextField("1");
		sLabel = new JLabel("Selection");
		selection = new JComboBox();
		fLabel = new JLabel("Fitness");
		fitness = new JComboBox();
		pLabel = new JLabel("Population Size");
		popInput = new JTextField("100");
		gLabel = new JLabel("Generations");
		genInput = new JTextField("500");
		genoLabel = new JLabel("Genome Length");
		genoInput = new JTextField("100");
		cross = new JLabel("Crossover");
		crossInput = new JCheckBox();
		elitism = new JLabel("Elitism(number of organism)");
		elitismInput = new JTextField("0");
		chooseTarget = new JButton("Choose target");
		chooseTarget.setEnabled(false);
		start = new Button("Start Evolution");
		
		bottomPanel.setLayout(new GridLayout(3, 6));
		
		bottomPanel.add(mLabel);
		bottomPanel.add(mInput);
		bottomPanel.add(sLabel);
		bottomPanel.add(selection);
		bottomPanel.add(fLabel);
		bottomPanel.add(fitness);
		bottomPanel.add(pLabel);
		bottomPanel.add(popInput);
		bottomPanel.add(gLabel);
		bottomPanel.add(genInput);
		bottomPanel.add(genoLabel);
		bottomPanel.add(genInput);
		bottomPanel.add(genoLabel);
		bottomPanel.add(genoInput);
		bottomPanel.add(cross);
		bottomPanel.add(crossInput);
		bottomPanel.add(elitism);
		bottomPanel.add(elitismInput);
		bottomPanel.add(chooseTarget);
		bottomPanel.add(start);
	}
	

	public DataGraphComponent() {
		initialzeUI();
		termi = Integer.valueOf(genInput.getText());
		
		
		ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {

				if(pop.getGeneration() < termi) {
					 pop.step();
				}else {
					timer.stop();
					start.setText("Start Evolution");
				}
		    	 
		      }
		}; 
		timer = new Timer(0, taskPerformer);
		
		
		factory = new MethodFactory();
		data = new DataGraph(termi);
		pop = new Population(data, Integer.valueOf(popInput.getText()), 
				Integer.valueOf(genoInput.getText()), new FitnessTotalNumberOf1(), 
				new SelectionTruncation(Double.valueOf(mInput.getText()), Integer.valueOf(elitismInput.getText())));

		topContent();
		centerContent();
		bottomContent();
		
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}