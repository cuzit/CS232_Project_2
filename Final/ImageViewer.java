import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ImageViewer extends JPanel
{
	private Image image;
	private JLabel label;
	private JScrollPane scrollPane;
	private int zoomLevel = 1;
	private ImageUtilities iu = new ImageUtilities();
	

	
	public ImageViewer(Image inImage)
	{
		setVisible(true);
		setSize(500, 500);
		setPreferredSize(new Dimension(500,500));
		setLayout(new BorderLayout());
		
		image = inImage;
		
		ImageIcon tempImage = iu.createImageIcon(image, zoomLevel);
		label = new JLabel(tempImage);
		scrollPane = new JScrollPane(label);
		
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void setZoomLevel(int zoomLevel)
	{
		if(zoomLevel > 0 || zoomLevel < 11)
		{
			zoomLevel = zoomLevel;		
			ImageIcon tempImage = iu.createImageIcon(image, zoomLevel);
			label.setIcon(tempImage);
		}

	}
	public void setImage(Image image)
	{
		ImageIcon tempImage = iu.createImageIcon(image, zoomLevel);
		label.setIcon(tempImage);
	}

}