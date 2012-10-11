/***************************
*AsciiImage Class          *
*Programmed by Matt Silvey *
*CS232 - Garrett           *
****************************/

public class AsciiImage {
  /***********
  *Attributes*
  ************/
  private static final char[] shades = {'#', '$', '@', 'O', 'o', '+', '-', ':', '.', '`', ' '};
  private char[][] pixel;
  private int width;
  private int height;
  
  
  /*************
  *Constructors*
  **************/
  //Default constructor. Constructs an empty array of pixels of the darkest
  //shade of the specified width and height.
  public AsciiImage(int width, int height) {
    this.pixel = new char[height][width];
    this.width = width;
    this.height = height;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
	this.pixel[i][j] = shades[0];
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
    
    //Loop activates if 'ascii' is not within acceptable maxDimension
    while (ascii.getWidth() > maxDimension || ascii.getHeight() > maxDimension) {
      //Shrink the image. The image will continue to shrink until the condition
      //is no longer true.
      ascii.shrink();
    }
    
    this.width = ascii.getWidth();
    this.height = ascii.getHeight();
    this.pixel = new char[this.height][this.width];
    
    //Determines the shade of the pixel and assigns it an appropriate ASCII
    //representation
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
	this.pixel[i][j] = shades[(int)(ascii.getPixel(i, j) / (255 / (shades.length - 1)))];
      }
    }
  }
  
  //Constructor called when only an Image is passed, with no declared
  //max dimensions. It does the same thing as the above constructor with
  //max dimensions, it just doesn't shrink it.
  public AsciiImage(Image image) {
    //Declare necessary variables
    Image ascii = new Image(image);
    this.width = ascii.getWidth();
    this.height = ascii.getHeight();
    this.pixel = new char[this.height][this.width];
    
    //Determines the shade of the pixel and assigns it an appropriate ASCII
    //representation
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
	this.pixel[i][j] = shades[(int) (ascii.getPixel(i, j) / (255 / (shades.length - 1)))];
      }
    }
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
    pixel[row][col] = value;
  }
  
  
    /****************
    *Other Functions*
    *****************/
  
  //Converts an AsciiImage type object into a Image type object. Will be
  //very lossy.
  public Image getImage() {
    Image newImage = new Image(this.width, this.height);
    
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
		int m = 0;
		for(int k = 0; k < shades.length; k++) {
	  		if (shades[k] == this.pixel[i][j]) {
	    		m = k;
	  		}
		}
		newImage.setPixel(i, j, (int)(m * 255 / (shades.length - 1 )));
      }
    }
    
    return newImage;
  }
  
  //Returns the ASCII representation as a string.
  public String toString() {
    StringBuilder asciiString = new StringBuilder(this.width * this.height + this.height);
    for (int i = 0; i < this.height; i++) {
      asciiString = asciiString.append(this.pixel[i]).append("\n");
    }
    return asciiString.toString();
  }

}