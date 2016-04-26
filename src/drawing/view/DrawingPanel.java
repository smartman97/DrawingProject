package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import drawing.controller.DrawingController;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private ShapePanel shapePanel;
	private JButton rectangleButton;
	private JButton squareButton;
	private JButton ellipseButton;
	private JButton circleButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;

	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		rectangleButton = new JButton("Draw Rectangle");
		rectangleList = new ArrayList<>();
		

		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		
		for(Rectangle current : rectangleList)
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
	
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 158, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -10, SpringLayout.SOUTH, this);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rectangleButton);
	}
}
