import java.util.Arrays;

public class Image{
	public enum Axis {HORIZONTAL, VERTICAL};
	private int[][] pixel;
	private int width;
	private int height;
	
	public Image(int width, int height){
		pixel = new int[height][width];
		for (int r = 0; r < height; r++)
		{
			for (int c = 0; c < width; c++)
				pixel[r][c] = 0; 
		}
		this.width = width;
		this.height = height;
	}
	
	public Image(Image image){
	height = image.getHeight();
	width = image.getWidth();
		pixel = new int[image.getHeight()][image.getWidth()];
		for(int r = 0; r < height; r++){
			for(int c = 0; c < width; c++){
			pixel[r][c] = image.getPixel(r,c);
			}
		}
	}
	 
	int getWidth(){
		return width;
	}
	
	int getHeight(){
		return height;
	}

	int getPixel(int row, int col){
		return pixel[row][col];
	}
	
	void setPixel(int row, int col, int value){
		pixel[row][col]= value;
	}
	
	void shrink(){
		int[][] halfPixel = new int[height/2][width/2];
		for(int row = 0; row < height/2; row++){
			for(int column = 0; column < width/2; column++){
			halfPixel[row][column]= ((pixel[2*row][2*column] + pixel[2*row+1][2*column] + pixel[2*row][2*column+1] + pixel[2*row+1][2*column+1])/4);
			}
		}
		height = height/2;
		width = width/2;
		pixel = halfPixel;
	}
	
	void invert(){
		for(int r = 0; r < height; r++){
			for(int c= 0; c < width; c++){
				pixel[r][c] = 255 - pixel[r][c];
			}
		}
		pixel = pixel;
	}

	void mirror(Axis axis){
	int[][] pixel1 = new int[height][width];
	if(axis == Axis.VERTICAL){
		for(int row = 0; row < height; row++){
			for(int column = 0; column < width; column++){
				pixel1[row][column]= pixel[row][width - 1- column];
			}
		}
	}
	else if(axis == Axis.HORIZONTAL){
		for(int column = 0; column < width; column++){
			for(int row = 0; row < height; row++){
				pixel1[row][column] = pixel[height - 1 - row][column];
			}
		}
	}
	pixel = pixel1;
	}	
	
}