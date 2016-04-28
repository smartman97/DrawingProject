package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
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
	private JButton clearButton;
	private JButton rectangleButton;
	private JButton squareButton;
	private JButton ellipseButton;
	private JButton circleButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;

	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		shapePanel = new ShapePanel();

		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		
		clearButton = new JButton("Clear");
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 10, SpringLayout.NORTH, this);
		
		rectangleButton = new JButton("Draw a  rectangle");
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -10, SpringLayout.SOUTH, this);
		
		squareButton = new JButton("Draw a square");
		baseLayout.putConstraint(SpringLayout.SOUTH, squareButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, squareButton, 200, SpringLayout.EAST, rectangleButton);
		
		ellipseButton = new JButton("Draw an ellipse");
		baseLayout.putConstraint(SpringLayout.SOUTH, ellipseButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, ellipseButton, 400, SpringLayout.EAST, rectangleButton);
		
		circleButton = new JButton("Draw a circle");
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, circleButton, -30, SpringLayout.SOUTH, rectangleButton);
		
		triangleButton = new JButton("Draw a triangle");
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 220, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, triangleButton, -30, SpringLayout.SOUTH, rectangleButton);
		
		polygonButton = new JButton("Draw a polygon");
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 412, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, polygonButton, -30, SpringLayout.SOUTH, rectangleButton);
		
		
		
		rectangleList = new ArrayList<>();
		squareList = new ArrayList<>();
		ellipseList = new ArrayList<>();
		circleList = new ArrayList<>();
		triangleList = new ArrayList<>();
		polygonList = new ArrayList<>();
		

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
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clearLists();
				
				repaint();
			}
		});
		
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		squareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			}
		});
		
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});
		
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});
		
		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(clearButton);
		this.add(rectangleButton);
		this.add(squareButton);
		this.add(ellipseButton);
		this.add(circleButton);
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(shapePanel);
	}
}
