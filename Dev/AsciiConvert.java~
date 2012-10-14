/**************************************
*Project 2 Main                       *
*Garrett - CS232 - Image Manipulation *
*Matt, Tyler, Crystal, Aaron, Jackie  *
***************************************/
import java.awt.*;
import javax.swing.*;

public class AsciiConvert extends JFrame {
  /**********
  *Variables*
  ***********/
  ImageViewer image;
  AsciiViewer ascii;
  
  
  /************
  *Constructor*
  *************/
  public AsciiConvert() {
    Image pic = loadJPEG("test.jpg");
    image = new ImageViewer(pic);
    ascii = new AsciiViewer(pic);
    
    setLayout(new FlowLayout());
    add(image);
    add(ascii);
  }
  
  
  /*****
  *Main*
  ******/
  public static void main(String[] args) {
    AsciiConvert window = new AsciiConvert();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.pack();
    window.setVisible(true);  
  }
  
  
}