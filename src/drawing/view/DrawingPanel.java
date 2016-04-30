package drawing.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import drawing.controller.DrawingController;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private JButton clearButton;
	private JButton rectangleButton;
	private JButton squareButton;
	private JButton ellipseButton;
	private JButton circleButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton graphButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		shapePanel = new ShapePanel();
		graphPanel = new GraphPanel();

		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -10, SpringLayout.EAST, this);
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
		
		graphButton = new JButton("New Heights");
		baseLayout.putConstraint(SpringLayout.NORTH, graphButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphButton, -10, SpringLayout.EAST, this);
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		graphButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				graphPanel.clearList();
				graphPanel.fillArray();
				graphPanel.addBar();
				
				repaint();
			}
		});
		
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
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		/*this.add(clearButton);
		this.add(rectangleButton);
		this.add(squareButton);
		this.add(ellipseButton);
		this.add(circleButton);
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(shapePanel);*/
		this.add(graphPanel);
		this.add(graphButton);
	}
}
