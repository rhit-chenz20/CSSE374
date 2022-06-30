package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class: ChromosomeComponent
 * @author R_004
 * <br>Purpose: create the window to show one chromosome
 * <br>For example: 
 * <pre>
 *    ChromosomeComponent chromosomeComponent = new ChromosomeComponent("chromosome1.txt");
 * </pre>
 *
 */

public class ChromosomeComponent extends JComponent{
	public static final Color COLOR_FOR_1 = Color.green;
	public static final Color COLOR_FOR_0 = Color.gray;
	public static final Color COLOR_FOR_2 = Color.orange;
	
	private JFrame frame;
	private JLabel fileNameLabel;
	private JPanel topPanel;
	private JPanel bodyPanel;
	private JPanel bottomPanel;
	private double mutateRate;
	private ArrayList<JButton> buttons;
	private JButton save;
	private JButton load;
	
	public Chromosome chromosome = ChromosomeTarget.getInstance("sample.txt");
	
	public void topContent() {
		topPanel.add(fileNameLabel);
	}
	
	public void bodyContent() {
		this.bodyPanel.setLayout(new GridLayout(this.chromosome.getGenes().size() / 10, 10, 0, 0));
		this.bodyPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for(int i = 0; i < this.chromosome.getGenes().size(); i++) {
			JButton yo = new JButton("" + i);
			buttons.add(yo);
			
			yo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					chromosome.mutate(Integer.valueOf(yo.getText()), 100.0);
					colorUpdate();
//					fileNameLabel.setText(chromosome.getFileName() + " (mutated)");
				}
				
			});
			
			bodyPanel.add(yo);
		}
		colorUpdate();
	}
	
	public void bottomContent() {
		
		JButton mutateYo= new JButton("Mutate");
		mutateYo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				chromosome.mutateAll(mutateRate);
//				colorUpdate();
//				fileNameLabel.setText(chromosome.getFileName() + " (mutated)");
			}
			
		});
		bottomPanel.add(mutateYo);
		
		JLabel mLabel = new JLabel("M Rate:_/N");
		bottomPanel.add(mLabel);
		
		JTextField txtInput = new JTextField("0");
		txtInput.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
//				mutateRate = Double.valueOf(txtInput.getText()) / chromosome.getGenes().size();
			}
			
		});
		txtInput.setPreferredSize(new Dimension(50,20));
		bottomPanel.add(txtInput);
		
		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser browseChromosomeFile = new JFileChooser("C:\\Users\\chenz20\\git\\csse220-fallq-2020-21-final-project-fallq2021_r004\\chromosomes");
				int respond = browseChromosomeFile.showOpenDialog(null);
				
				if(respond == JFileChooser.APPROVE_OPTION) {
					File file = new File(browseChromosomeFile.getSelectedFile().getAbsolutePath());
//					chromosome = chromosome.loadNewChromosome(file.getName());
					frame.setVisible(false);
//					ChromosomeComponent chromosomeCom = new ChromosomeComponent(chromosome.getFileName());
//					chromosomeCom.repaint();
				}
			}
			
		});
		bottomPanel.add(load);
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				fileNameLabel.setText(chromosome.getFileName());
				JFileChooser save = new JFileChooser("C:\\Users\\chenz20\\git\\csse220-fallq-2020-21-final-project-fallq2021_r004\\chromosomes");
				int respond = save.showSaveDialog(null);
				
				if(respond == JFileChooser.APPROVE_OPTION) {
					String filename = save.getSelectedFile().getName();
//					chromosome.writeChromosomeFile(filename, chromosome.getGenes());
				}
			}
			
		});
		bottomPanel.add(save);
	}
	
	public void colorUpdate() {
		for(int i = 0;i < chromosome.getGenes().size();i++)
		{
			if(chromosome.getGenes().get(i)==0)
				buttons.get(i).setBackground(COLOR_FOR_0);
			else if(chromosome.getGenes().get(i)==1)
				buttons.get(i).setBackground(COLOR_FOR_1);
			else buttons.get(i).setBackground(COLOR_FOR_2);
		}
		repaint();
	}
	
	public void fileUpdate(String name) {
//		this.chromosome = new Chromosome(name);
		bodyContent();
		repaint();
	}
	
	public void fileUpdate(String name, ArrayList<Integer> input) {
//		chromosome.updateFile(input, name);
//		this.chromosome = new Chromosome("target.txt");
		bodyContent();
	}
	
	public void setTitle(String name) {
		this.fileNameLabel.setText(name);
	}

	public ChromosomeComponent() {
//		this.genes = genes;
		try {
            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName()
//	            UIManager.getSystemLookAndFeelClassName()
	            );
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }

		this.frame = new JFrame();
		this.frame.setTitle("Fittest Chromosome");
		
		this.topPanel = new JPanel();
		this.bodyPanel = new JPanel();
		this.bottomPanel= new JPanel();
		
		this.fileNameLabel = new JLabel("Fittest");
		this.buttons= new ArrayList<JButton>();
		this.mutateRate = 0.0;
		this.save = new JButton("Save");
		this.load = new JButton("Load");
		
		this.bottomPanel.setLayout(new GridLayout(2, 3, 0, 0));
		this.bottomPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		topContent();
		bodyContent();
		//bottomContent();
		colorUpdate();
		
		this.frame.add(bodyPanel, BorderLayout.CENTER);
		this.frame.add(topPanel,BorderLayout.NORTH);
		this.frame.add(bottomPanel,BorderLayout.SOUTH);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		this.frame.pack();
		this.frame.setVisible(true);
	}
}
