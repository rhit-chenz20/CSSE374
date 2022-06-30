package mainApp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class: AllPopulationGraph
 * @author R_004
 *<br>Purpose: Used to draw the fitness of whole population and update it
 * <br>For example: 
 * <pre>
 *    AllPopulationGraph graph = new AllPopulationGraph(pop.getFitness);
 * </pre>
 */

public class AllPopulationGraph extends JPanel {
	private ArrayList<Integer> fitness;
	
	private static final int PREF_W = 700;
	private static final int PREF_H = 400;
	private static final int BORDER_GAP = 40;
	private static final int X_ORIGIN = BORDER_GAP;
	private static final int Y_ORIGIN = PREF_H - BORDER_GAP;
	private static final int HATCH_WIDTH = 5;
	private static final int HATCH_CNT = 10;
	private static final int POINT_SIZE = 5;
	
	private double xScale;
	private double yScale;
	
	public void updatePopulation(ArrayList<Integer> input) {
		fitness = input;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		drawAxis(g2);
		drawPlots(g2);
	}
	
	public void drawPlots(Graphics2D g2d) {
		xScale =((double) getWidth() - 2 * BORDER_GAP) / (fitness.size() - 1);
		yScale =((double) getHeight() - 2 * BORDER_GAP) / (100 - 1);
		
		g2d.translate(X_ORIGIN, Y_ORIGIN);
		
		
		for(int i = 0; i < fitness.size(); i++) {
			int x = (int)(i * xScale - 2);
			int y = (int)( - fitness.get(i) * yScale);
			
			g2d.fillRect(x, y, POINT_SIZE, POINT_SIZE);
		}
		g2d.translate(-X_ORIGIN, -Y_ORIGIN);
	}
	
	public void drawAxis(Graphics2D g2d) {
		g2d.drawString("Fitness", BORDER_GAP / 2, BORDER_GAP / 2);
		g2d.drawString("Process Input", getWidth() / 2 - BORDER_GAP, getHeight() - BORDER_GAP / 4);
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
		int xValues = fitness.size() / HATCH_CNT;
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
			xValues += (fitness.size() / HATCH_CNT);
		}
	}
	
	public AllPopulationGraph(ArrayList<Integer> input) {
		this.fitness = input;
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(PREF_W,PREF_H);
	}
}
