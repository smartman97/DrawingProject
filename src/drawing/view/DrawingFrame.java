package drawing.view;

import javax.swing.JFrame;

import drawing.controller.DrawingController;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingPanel basePanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel); 
		this.setSize(400, 400);			
		this.setTitle("Drawing GUI");
		this.setResizable(true);		
		this.setVisible(true);	
	}
}
