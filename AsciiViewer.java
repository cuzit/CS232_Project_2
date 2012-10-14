import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AsciiViewer extends JPanel
{
	private ImageUtilities imageUtil;
	private AsciiImage image;
	private JTextArea textArea;
	private int zoomLevel;
	
	public AsciiViewer(AsciiImage image)
	{
		imageUtil = new ImageUtilities();
		
		// Set the image to be the image passed to this class
		this.image = image;
		
		// Set the zoom level to have a default of 1
		this.zoomLevel = 1;
		
		// Add the Ascii Image to the the JTextArea
		textArea = new JTextArea();
		textArea.setText(this.image.toString());
		
		// Set the JTextArea so that it can't be editeded per the requirements
		textArea.setEditable(false);
		
		// Set the JTextArea to have a selection color of white
		textArea.setSelectionColor(Color.WHITE);
		
		// Adjust the JTextArea to match the current zoom level
		textArea.setFont(imageUtil.createFontForZoomLevel(zoomLevel));
		
		// Resize the image based on the zoomLevel
		imageUtil.resize(textArea, this.image, zoomLevel);		
		
		/*
			Create a JPanel and set the layout of it to be GridBagLayout
			because if you try to set the layout of JScrollPane to GridBagLayout
			then it the compiler will throw an error stating that JScrollPane has
			to have a layout of ScrollPaneLayout.
		*/
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		// Create an instance of GridBagConstraints but don't set any
		// of the contraints that way it uses the default constraints
		GridBagConstraints constraints = new GridBagConstraints();
		
		// Add the JScrollPane to the JPanel and set the panel to have the default
		// constraints from the GridBagLayout that we previously created
		panel.add(textArea, constraints);
		
		// Create a new JScrollPane and add the JPanel to it
		// Then set the view to have a size of 500 by 500 pixels
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		
		// Set the layout to BorderLayout and add the JScrollPane to the JPanel
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void setImage(AsciiImage image)
	{
		this.image = image;
		setZoomLevel(zoomLevel);
        textArea.setText(image.toString());
	}
	
	public void setZoomLevel(int zoomLevel)
	{
		if(zoomLevel >= 1 && zoomLevel <= 10)
		{
			this.zoomLevel = zoomLevel;
			textArea.setFont(imageUtil.createFontForZoomLevel(zoomLevel));
			imageUtil.resize(textArea, this.image, zoomLevel);	
        }
	}
}