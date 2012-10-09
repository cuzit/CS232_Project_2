import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AsciiViewer extends JPanel
{
	private AsciiImage image;
	private JTextArea textArea;
	private int zoomLevel;
	
	public AsciiViewer(AsciiImage image)
	{
		// Set the image to be the image passed to this class
		this.image = image;
		
		// Add the Ascii Image to the the JTextArea
		textArea = new JTextArea(image.toString());
		
		// Set the JTextArea so that it can't be editeded per the requirements
		textArea.setEditable(false);
		
		// Set the JTextArea to have a selection color of white
		textArea.setSelectionColor(Color.WHITE);
		
		// Set the zoom level to have a default of 1
		this.zoomLevel = 1;
		
		// Adjust the JTextArea to match the current zoom level
		textArea.setFont(ImageUtilties.createFontForZoomLevel(zoomLevel);
		
		// Resize the image based on the zoomLevel
		ImageUtilties.resize(textArea, this.image, zoomLevel);
		
		// Set the view to have a size of 500 by 500 pixels
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setPreferredSize(new Dimension(500, 500));
		
		// Set the layout of the JScrollPane to be GridBagLayout
		scrollPanel.setLayout(new GridBagLayout(new GridBagConstraints());
		
		// Add the JTextArea to the JScrollPane
		scrollPanel.add(textArea);
		
		// Reset the layout back to FlowLayout and add the JScrollPane to the JPanel
		add(scrollPanel, FlowLayout.CENTER);
		
	}
	
	public void setImage(Image image)
	{
	
	}
	
	public void setZoomLevel(int zoomLevel)
	{
	
	}
}