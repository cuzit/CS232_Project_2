/***************************
*AsciiImage Class          *
*Programmed by Matt Silvey *
*CS232 - Garrett           *
****************************/
import java.io.*;


public class AsciiImage {
  /***********
  *Attributes*
  ************/
  private static final char[] shades = {'#', '$', '@', 'O', 'o', 
					'+', '-', ':', '.', '`', ' '};
  
  private char[][] pixel;
  private int width;
  private int height;
  
  
  /*************
  *Constructors*
  **************/
  //Default constructor. Constructs an empty array of pixels of the darkest
  //shade of the specified width and height.
  public AsciiImage(int width, int height) {
    this.pixel = new char[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
	this.pixel[i][j] = this.shades[0];
	/*Debugging:*/ System.out.println("pixel[" + i + "][" + j + "]: " + this.pixel[i][j]);
      }
    }
  }
  
  //Constructor that is called if an image has a max dimension it should
  //be displayed as. An image of type Image must be passed, as well as the
  //max dimensions. If the image is larger than the max dimension, it is
  //shrinked to an appropriate size. Then, it is converted into an AsciiImage
  //image.
  public AsciiImage(Image image, int maxDimension) {
    Image ascii = new Image(image);
    this.pixel = new char[ascii.getWidth()][ascii.getHeight()];
    
    //Loop activates if 'ascii' is not within acceptable maxDimension
    while (ascii.getWidth() > maxDimension || ascii.getHeight() > maxDimension) {
      //Shrink the image. The image will continue to shrink until the condition
      //is no longer true.
      ascii.shrink();
    }
    
    //Determines the shade of the pixel and assigns it an appropriate ASCII
    //representation
    for (int i = 0; i < ascii.getWidth(); i++) {
      for (int j = 0; j < ascii.getHeight(); j++) {
	this.pixel[i][j] = this.shades[ascii.getPixel(i, j) / 255 * (this.shades.length - 1)];
	/*Debugging*/ System.out.println("pixel[" + i + "][" + j + "]: " + this.pixel[i][j]);
      }
    }
    
    //Sets the width and height variables
    this.width = ascii.getWidth();
    this.height = ascii.getHeight();
    
  }
  
  //Constructor called when only an Image is passed, with no declared
  //max dimensions. It does the same thing as the above constructor with
  //max dimensions, it just doesn't shrink it.
  public AsciiImage(Image image) {
    Image ascii = new Image(image);
    this.pixel = new char[ascii.getWidth()][ascii.getHeight()];
    
    //Determines the shade of the pixel and assigns it an appropriate ASCII
    //representation
    for (int i = 0; i < ascii.getWidth(); i++) {
      for (int j = 0; j < ascii.getHeight(); j++) {
	this.pixel[i][j] = this.shades[ascii.getPixel(i, j) / 255 * (this.shades.length - 1)];
	/*Debugging*/ System.out.println("pixel[" + i + "][" + j + "]: " + this.pixel[i][j]);
      }
    }
    
    //Sets the width and height variables
    this.width = ascii.getWidth();
    this.height = ascii.getHeight();
  }
  
  
  /**********
  *Functions*
  ***********/
    /********************
    *Getters and setters*
    *********************/
  
  //Returns the width of the current AsciiImage.
  public int getWidth() {
    return this.width;
  }
  
  //Returns the height of the current AsciiImage
  public int getHeight() {
    return this.height;
  }
  
  //Returns the ascii value (see shades array) of the current AsciiImage
  public char getPixel(int row, int col) {
    return this.pixel[row][col];
  }
  
  //Changes the value of the pixel (represented by an Ascii character -
  //see shade array) to the value passed.
  public void setPixel(int row, int col, char value) {
    //Check to ensure char value is a valid value that can be used
    /*for(int i = 0; i < shades.length; i++) {
      if(value == shades[i]) {
	//Check to ensure row and col are within a valid bound
	if(row < 0 || row > this.width) {
	  return;
	}
	else if(col < 0 || row > this.height) {
	  return;
	}
	//Finally, set the pixel if nothing fails
	else {
	  this.pixel[row][col] = value;
	  return;
	}
      }
    }*/
    
    pixel[row][col] = value;
  }
  
  
    /****************
    *Other Functions*
    *****************/
  public Image getImage() {
    //Image justToGetThisToCompile = new Image(this.width, this.height);
    //return justToGetThisToCompile;
    Image newImage = new Image(this.width, this.height);
    
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
	for(int k = 0; k < this.shades.length; k++) {
	  if (shades[k] == this.getPixel(i, j)) {
	    newImage.setPixel(i, j, ((k * 255) / (this.shades.length -1 )));
	  }
	}
      }
    }
    
    return newImage;
  }
  
  public String toString() {
    String asciiString = "";
    /*Debugging:*/ //System.out.println("toString executing.");
    for (int i = 0; i < this.width; i++) {
      for(int j = 0; j < this.height; j++) {
	asciiString = asciiString + this.getPixel(i, j);
	/*Debugging:*/ //System.out.println("asciiString in for loop.");
      }
      /*Debugging:*///System.out.println("asciiString so far:\n" + asciiString);
      asciiString += "\n";
    }
    return asciiString;
  }
  
  
  
  /*********************************************************
  *Main - Used for Testing/Debugging. Should not be called.*
  **********************************************************/
  public static void main (String[] args) {
    //This is just for testing and should not be called by other processes.
    System.out.println("Debugging:");
    int height = 10;
    int width = 10;
    Image debugImage = new Image(height, width);
    AsciiImage debugtest = new AsciiImage(debugImage);
    System.out.println("toString returns: " + debugtest.toString());
    System.out.println("getPixel(5, 5) returns: " + debugtest.getPixel(5, 5));
  }

}