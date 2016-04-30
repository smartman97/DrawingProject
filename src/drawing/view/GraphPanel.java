package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private int[] graphSource = new int[10];
	private ArrayList<Rectangle> barList;
	
	public GraphPanel()
	{
		barList = new ArrayList<Rectangle>();
		
		fillArray();
		addBar();
	}
	
	public void fillArray()
	{
		for(int i = 0; i < graphSource.length; i++)
		{
			int random = (int )(Math. random() * 600);
			
			graphSource[i] = random;
		}
	}
	
	public void addBar()
	{
		int yPosition = 0;
		int xPosition = 0;
		int width = 50;
		int height = graphSource[0];
		
		for(int i = 0; i < graphSource.length; i++)
		{
			height = graphSource[i];
			barList.add(new Rectangle(xPosition, yPosition, width, height));
			xPosition += 50;
		}
	}
	
	public void clearList()
	{
		barList.clear();
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		
		for(Rectangle current : barList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			mainGraphics.fill(current);
		}
	}
}
