package textprocessor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ProcessorUI {
	private String text;
	private JFrame jFrame;
	private boolean strategy;
	
	private JPanel contentPane;
	private JTextArea sourceTextArea;
	private JTextArea resultTextArea;

	private JPanel buttonPanel;
	private JButton findButton;
	private JButton capitalizeButton;
	private JButton changeButton;
	private TextProcessor processor;

	public ProcessorUI(String text) {
		this.processor = new TextProcessor(text, new SubstitutionTransformer("processed", "transformed"));
		this.text = processor.getText();
		this.strategy = true;
		setupGUI();
		registerListeners();
	}
	
	private void setupGUI() {
		// Setup GUI
		jFrame = new JFrame("Text Processor");
		contentPane = (JPanel)jFrame.getContentPane();
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
		contentPane.add(buttonPanel, BorderLayout.NORTH);

		findButton = new JButton("Find");
		buttonPanel.add(findButton);
		
		capitalizeButton = new JButton("Transform");
		buttonPanel.add(capitalizeButton);
		
		changeButton = new JButton("Change Transformer");
		buttonPanel.add(changeButton);
		
		JPanel mainTextPanel = new JPanel();
		mainTextPanel.setLayout(new GridLayout(2,1));
		contentPane.add(mainTextPanel, BorderLayout.CENTER);

		sourceTextArea = new JTextArea(this.text);
		sourceTextArea.setPreferredSize(new Dimension(600, 300));
		JPanel sourcePanel = new JPanel(new BorderLayout());
		sourcePanel.setBorder(BorderFactory.createTitledBorder("Application Input"));
		mainTextPanel.add(sourcePanel);
		
		JScrollPane sourceScrollPane = new JScrollPane(sourceTextArea);
		sourcePanel.add(sourceScrollPane);
		
		JPanel resultPanel = new JPanel(new BorderLayout());
		resultPanel.setBorder(BorderFactory.createTitledBorder("Application Output"));
		mainTextPanel.add(resultPanel);
		
		resultTextArea = new JTextArea();
		resultTextArea.setPreferredSize(new Dimension(600, 300));
		JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
		resultPanel.add(resultScrollPane);
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void registerListeners() {
		// Setup button actions
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String subText = JOptionPane.showInputDialog(jFrame, 
						"Please enter the search string", 
						"Search String Input", 
						JOptionPane.QUESTION_MESSAGE);
				
				// Let the processor object know about the text to be processed
				text = sourceTextArea.getText();
				processor.setText(text);
				
				// Delegate to the processor
				int index = processor.find(subText);
				
				String message = String.format("Sorry! Cannot find the string '%s'!", subText);
				if(index > -1) 
					message = String.format("The first occurance of string was found at index: %d", index);
				resultTextArea.setText(message);
			}
		});
		
		capitalizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Let the processor object know about the text to be processed
				text = sourceTextArea.getText();
				processor.setText(text);

				// Delegates to the processor object
				String result = processor.transform();
				resultTextArea.setText(result);
			}
		});
		
		changeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(strategy) {
					processor = new TextProcessor(text, new AllCapsTransformer());
					strategy = false;
					resultTextArea.setText("");
				}else {
					processor = new TextProcessor(text, new SubstitutionTransformer("processed", "transformed"));
					strategy = true;
					resultTextArea.setText("");
				}
			}
			
		});
	}
	
	public void show() {
		// The right way to start GUI application that use Swing
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Show GUI
				jFrame.pack();
				jFrame.setVisible(true);		
			}
		});
	}
}
