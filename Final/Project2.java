/**************************************
*Project 2 Main                       *
*Garrett - CS232 - Image Manipulation *
*Matt, Tyler, Crystal, Aaron, Jackie  *
***************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Project2 extends JFrame
{
	/**********
	*Variables*
	***********/
	private ImageViewer imageViewer;
	private AsciiViewer asciiViewer;
	private JSlider zoomSlider;
  
	/************
	*Constructor*
	*************/
	public Project2(Image image)
	{
		imageViewer = new ImageViewer(image);
		asciiViewer = new AsciiViewer(new AsciiImage(image));
		zoomSlider = new JSlider(SwingConstants.VERTICAL, 1, 10, 1);
		
		// Set the JSlider's changeEvent listener
		zoomSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				int zoomLevel = zoomSlider.getValue();
				asciiViewer.setZoomLevel(zoomLevel);
				imageViewer.setZoomLevel(zoomLevel);
			}
		});
	
		/* 	
		*	The JSlider by default is relatively small, so
		*	add a JPanel and add both the viewers to it and
		*	then set the JPanel to CENTER using BorderLayout.
		*	Finally, set the JSlider to EAST using BorderLayout.
		*	This will enlarge the JSlider to take up the full height
		*	of the window.
		*/
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(imageViewer);
		panel.add(asciiViewer);
		
		
		// Set the default zoom of the viewers to 1
		int zoomLevel = 1;
		asciiViewer.setZoomLevel(zoomLevel);
		imageViewer.setZoomLevel(zoomLevel);
		
		/* 	
		*	Make the JSlider's ticks and labels visible then set the
		*	SnapToTicks property to true so that the slider moves
		*	to the closes tick. Finally set the MajorTickSpacing property
		*	to true. This specifies the distance between each tick.
		*/
		
		zoomSlider.setPaintTicks(true);
		zoomSlider.setPaintLabels(true);
		zoomSlider.setSnapToTicks(true);
		zoomSlider.setMajorTickSpacing(1);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		add(zoomSlider, BorderLayout.EAST);
	}
  
	/*****
	*Main*
	******/
	public static void main(String[] args)
	{
		try
		{
			Image picture = ImageUtilities.loadJPEG(args[0]);
			Project2 window = new Project2(picture);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setTitle("Project 2");
			window.pack();
			window.setVisible(true);
		}
		
		catch (IOException e)
		{
			System.out.println("You must pass a JPEG filename as a"
				+ " command-line parameter.\nUSAGE: java Project2 <filename>");
		}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("You must pass a JPEG filename as a"
				+ " command-line parameter.\nUSAGE: java Project2 <filename>");
		}
	}
}