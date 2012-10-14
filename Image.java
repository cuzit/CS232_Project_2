import java.util.Arrays;

public class Image{
	public enum Axis {HORIZONTAL, VERTICAL};
	private int[][] pixel;
	private int width;
	private int height;
	
	public Image(int width, int height){
		pixel = new int[height][width];
		for (int r= 0; r < height; r++)
		{
			for (int c = 0; c < width; c++)
				pixel[r][c] = 0; 
		}
		this.width = width;
		this.height = height;
	}
	
	public Image(Image image){
		height = getHeight();
		width = getWidth();
		pixel = new int[image.height][image.width];
		for(int r =0; r<height; r++){
			for(int c=0; c<width; c++){
			pixel[r][c] = image.pixel[r][c];
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
		pixel [row][col]= value;
	}
	
	
	void shrink(){
		int row = getHeight();
		int col = getWidth();
		int pixel[][] = new int [row][col];
		int halfWidth = getWidth()/2;
		int halfHeight = getHeight()/2;
		for(int j = 0; j<halfWidth; j++){
			for(int i=0; i<halfHeight; i++){
				int averageHeight = ((pixel[2*i][0] + pixel[2*i][0] + pixel[2*i+1][0] + pixel[2*i+1][0])/4);
				int averageWidth = ((pixel[0][2*j] + pixel[0][2*j+1] + pixel[0][2*j] + pixel[0][2*j+1])/4);
				int halfPixel[][]= new int[averageHeight][averageWidth];

			}
		}
	}
	
	void invert(){
		height = getHeight();
		width = getWidth();
		for(int r=0; r<height; r++){
			for(int c= 0; c<width; c++){
				pixel[r][c] = 255 - pixel[r][c];
			}
		}
	}
	
	void mirror(Axis axis){
	height = getHeight();
	width = getWidth();
	
	if(axis == Axis.VERTICAL){
		for(int i= 0; i< height/2; i++){
			for(int k = 0; k<width/2; k++){
				pixel[i][k] = pixel[i][width - k];
			}
		}
	}
	else if(axis == Axis.HORIZONTAL){
		for(int j =0; j<width/2; j++){
			for(int l = 0; l<height/2; l++){
				pixel[l][j] = pixel[height - l][j];
				}
			}
		}
	}
}