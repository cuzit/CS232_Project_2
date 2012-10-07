//AsciiImage Class
import java.io.*;

public class AsciiImage {
  //Attributes
  private static final char[] shades = {'#', '$', '@', 'O', 'o', 
					'+', '-', ':', '.', '`', ' '};
  
  public char[][] pixel; //REMEMBER THAT THIS NEEDS TO BE PRIVATE
			  //I'M MAKING IT TEMPORARILY PUBLIC FOR DEBUGGING
  private int width;
  private int height;
  
  //Constructor
  public AsciiImage(int width, int height) {
    this.pixel = new char[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
	this.pixel[i][j] = this.shades[0];
	/*Debugging:*/ System.out.println("pixel[" + i + "][" + j + "]: " + this.pixel[i][j]);
      }
    }
  }
  
  
  
  
  
  
  //Test main
  public static void main (String[] args) {
    //This is just for testing and should not be called by other processes.
    System.out.println("Debugging:");
    System.out.println("Printing contents of pixel[][] array: ");
    int height = 5;
    int width = 5;
    AsciiImage debugtest = new AsciiImage(height, width);
    /*
    for (int i = 0; i <= width; i++) {
      for (int j = 0; j <= height; j++) {
	System.out.println("[" + i + "][" + j + "]: "/*Pixels should output here);
      }
    }*/
  }

}