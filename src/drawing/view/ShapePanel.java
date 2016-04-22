package drawing.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	//More arraylists
	
	public ShapePanel()
	{
		rectangleList = new ArrayList<Rectangle>();
	}
	
	public void addRectangle()
	{
		//Random info here
		rectangleList.add(new Rectangle(10, 10, 10 , 10));
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		//Draw in here!
	}
}
