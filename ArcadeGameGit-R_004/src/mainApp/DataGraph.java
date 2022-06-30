package mainApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Class: DataGraph
 * @author R_004
 *<br>Purpose: Used to draw the max, min, and average fitness and diversity lines throughout the evolution
 * <br>For example: 
 * <pre>
 *    DataGraph graph = new DataGraph(10, 0.1, 100, 100, "Number Of 1s", "Truncation", "target.txt", false, 20);
 * </pre>
 */

public class DataGraph extends JPanel{
	private static final int MaxFit = 100;
	private static final int PREF_W = 1100;
	private static final int PREF_H = 450;
	private static final int BORDER_GAP = 30;
	private static final int X_ORIGIN = BORDER_GAP;
	private static final int Y_ORIGIN = PREF_H - BORDER_GAP;

	private int termination;
	
	private ArrayList<Integer> fitMax;
	private ArrayList<Integer> fitAve;
	private ArrayList<Integer> fitMin;
	private ArrayList<Integer> diversity;
	private ArrayList<Double> all1;
	private ArrayList<Double> all0;
	private ArrayList<Double> all2;

	private static final Color MAX_FITNESS_COLOR = Color.GREEN;
	private static final Color AVERAGE_FITNESS_COLOR = Color.RED;
	private static final Color MIN_FITNESS_COLOR = Color.BLUE;
	private static final Color DIVERSITY_COLOR = Color.YELLOW;
	private static final Color ALL1_COLOR = Color.BLACK;
	private static final Color ALL0_COLOR = Color.ORANGE;
	private static final Color ALL2_COLOR = Color.PINK;
	private static final int HATCH_WIDTH = 5;
	private static final int HATCH_CNT = 10;
	private static final int LABEL_X = 920;
	private static final int LABEL_Y1 = 130;
	

	public DataGraph(int termination) {
		this.termination = termination;
		this.fitMax = new ArrayList<Integer>();
		this.fitAve = new ArrayList<Integer>();
		this.fitMin = new ArrayList<Integer>();
		this.diversity = new ArrayList<Integer>();
		this.all1 = new ArrayList<Double>();
		this.all0 = new ArrayList<Double>();
		this.all2 = new ArrayList<Double>();
	}
	
	public void update(int aveF, int maxF, int minF, int div) {
		fitMax.add(maxF);
		fitAve.add(aveF);
		fitMin.add(minF);
		diversity.add(div);
		repaint();
	}
	
	public void update(int aveF, int maxF, int minF, int div, double pro0, double pro1, double pro2) {
		fitMax.add(maxF);
		fitAve.add(aveF);
		fitMin.add(minF);
		diversity.add(div);
		all0.add(pro0);
		all1.add(pro1);
		all2.add(pro2);
		repaint();
	}
	
	public void clearAll() {
		this.fitMax = new ArrayList<Integer>();
		this.fitAve = new ArrayList<Integer>();
		this.fitMin = new ArrayList<Integer>();
		this.diversity = new ArrayList<Integer>();
		this.all1 = new ArrayList<Double>();
		this.all0 = new ArrayList<Double>();
		this.all2 = new ArrayList<Double>();
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		drawAxis(g2);
		drawDataLines(g2);
		drawLabel(g2);
	}
	
	
	public void drawDataLines(Graphics2D g2d) {
		double xScale =((double) getWidth() - 2 * BORDER_GAP) / (termination - 1);
		double yScale =((double) getHeight() - 2 * BORDER_GAP) / (MaxFit - 1);
		
		g2d.setStroke(new BasicStroke(3));
		
		g2d.translate(X_ORIGIN, Y_ORIGIN);
		
		
		for(int i = 0; i < fitMax.size() - 1; i++) {
			int x1 = (int)(i * xScale);
			int x2 = (int)((i + 1) * xScale);
			int y1 = (int)(- fitMax.get(i) * yScale);
			int y2 = (int)(- fitMax.get(i + 1) * yScale);
			
			g2d.setColor(MAX_FITNESS_COLOR);
			g2d.drawLine(x1, y1, x2, y2);
			
			int y3 = (int)(- fitAve.get(i) * yScale);
			int y4 = (int)(- fitAve.get(i + 1) * yScale);
			
			g2d.setColor(AVERAGE_FITNESS_COLOR);
			g2d.drawLine(x1, y3, x2, y4);
			
			int y5 = (int)(- fitMin.get(i) * yScale);
			int y6 = (int)(- fitMin.get(i + 1) * yScale);
			
			g2d.setColor(MIN_FITNESS_COLOR);
			g2d.drawLine(x1, y5, x2, y6);
			
			int y7 = (int)(- diversity.get(i) * yScale);
			int y8 = (int)(- diversity.get(i + 1) * yScale);
			
			g2d.setColor(DIVERSITY_COLOR);
			g2d.drawLine(x1, y7, x2, y8);
			
//			int y9 = (int)(- all1.get(i) * yScale);
//			int y10 = (int)(- all1.get(i + 1) * yScale);
//			
//			g2d.setColor(ALL1_COLOR);
//			g2d.drawLine(x1, y9, x2, y10);
//			
//			int y11 = (int)(- all2.get(i) * yScale);
//			int y12 = (int)(- all2.get(i + 1) * yScale);
//			
//			g2d.setColor(ALL2_COLOR);
//			g2d.drawLine(x1, y11, x2, y12);
//			
//			int y13 = (int)(- all0.get(i) * yScale);
//			int y14 = (int)(- all0.get(i + 1) * yScale);
//			
//			g2d.setColor(ALL0_COLOR);
//			g2d.drawLine(x1, y13, x2, y14);
		}
		
		g2d.translate(-X_ORIGIN, -Y_ORIGIN);
	}
	
	public void drawAxis(Graphics2D g2d) {
		//create axis
		g2d.drawString("0", X_ORIGIN / 2, Y_ORIGIN + (BORDER_GAP / 2));
		g2d.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
		g2d.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP,getHeight() - BORDER_GAP);
		int yValues = 10;
		//creating hatches for y
		for(int i = 0;i < HATCH_CNT; i++)
		{
			int x0 = BORDER_GAP;
			int x1 = HATCH_WIDTH + BORDER_GAP;
			int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / HATCH_CNT + BORDER_GAP);
			int y1 = y0;
			g2d.drawLine(x0, y0, x1, y1);
			int xString = BORDER_GAP - 20;
			int yString = y0 + 5;
			g2d.drawString("" + yValues, xString, yString);
			yValues += 10;
		}
		
		// creating hatches for x
		int xValues = termination / HATCH_CNT;
		for(int i = 0; i < HATCH_CNT;i++)
		{
			int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (HATCH_CNT) + BORDER_GAP;
			int x1 = x0;
			int y0 = getHeight() - BORDER_GAP;
			int y1 = y0 - HATCH_WIDTH;
			g2d.drawLine(x0, y0, x1, y1);
			int xString = x0 - 8;
			int yString = y0 + 20;
			g2d.drawString("" + xValues, xString, yString);
			xValues += (termination / HATCH_CNT);
		}
	}
	
	public void drawLabel(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.drawString("Maximum Fitness", LABEL_X + 20, LABEL_Y1 + 10);
		g2d.drawString("Average Fitness", LABEL_X + 20, LABEL_Y1 + 35);
		g2d.drawString("Minimum Fitness", LABEL_X + 20, LABEL_Y1 + 60);
		g2d.drawString("Diversity", LABEL_X + 20, LABEL_Y1 + 85);
		g2d.drawString("Undetermined Alleles", LABEL_X + 20, LABEL_Y1 + 110);
		g2d.drawString("Correct Alleles", LABEL_X+20, LABEL_Y1+135);
		g2d.drawString("Incorrect Alleles", LABEL_X+20, LABEL_Y1+160);
		g2d.setColor(MAX_FITNESS_COLOR);
		g2d.fillRect(LABEL_X, LABEL_Y1, 15, 15);
		g2d.setColor(AVERAGE_FITNESS_COLOR);
		g2d.fillRect(LABEL_X, LABEL_Y1 + 25, 15, 15);
		g2d.setColor(MIN_FITNESS_COLOR);
		g2d.fillRect(LABEL_X, LABEL_Y1 + 50, 15, 15);
		g2d.setColor(DIVERSITY_COLOR);
		g2d.fillRect(LABEL_X, LABEL_Y1 + 75, 15, 15);
		g2d.setColor(ALL2_COLOR);
		g2d.fillRect(LABEL_X, LABEL_Y1 + 100, 15, 15);
		g2d.setColor(ALL1_COLOR);
		g2d.fillRect(LABEL_X, LABEL_Y1 + 125, 15, 15);
		g2d.setColor(ALL0_COLOR);
		g2d.fillRect(LABEL_X, LABEL_Y1 + 150, 15, 15);
	}
	
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(PREF_W,PREF_H);
	}
}
