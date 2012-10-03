import junit.framework.*;
	
public class TestImage extends TestCase { 
    private Image imageA;
    private Image imageB;
    private Image imageC;
    public TestImage(String name) {
        super(name);
    }
    protected void setUp() { 
        imageA = new Image(100, 200);
        try {
            imageB = ImageUtilities.loadJPEG("test.jpg");
        }
        catch(java.io.IOException e) {
            System.out.println(e);
            imageB = imageA;
        }
        imageC = new Image(imageB);
    }
    public void testGetsSets() {
        assertEquals(100, imageA.getWidth());
        assertEquals(200, imageA.getHeight());
        assertEquals(255, imageB.getWidth());
        assertEquals(198, imageB.getHeight());
        assertEquals(imageB.getWidth(), imageC.getWidth());
        assertEquals(imageB.getHeight(), imageC.getHeight());
        for(int r = 0; r < imageA.getHeight(); r++) {
            for(int c = 0; c < imageA.getWidth(); c++) {
                assertEquals(0, imageA.getPixel(r, c));
            }
        }
        assertEquals(35, imageB.getPixel(142, 124));
        for(int r = 0; r < imageB.getHeight(); r++) {
            for(int c = 0; c < imageB.getWidth(); c++) {
                assertEquals(imageB.getPixel(r, c), imageC.getPixel(r, c));
            }
        }
        imageA.setPixel(11, 13, 128);
        assertEquals(128, imageA.getPixel(11, 13));
    }
    public void testShrink() {
        Image image = new Image(imageB);
        image.shrink();
        assertEquals(127, image.getWidth());
        assertEquals(99, image.getHeight());
        assertEquals(53, image.getPixel(50, 50));
    }
    public void testInvert() {
        imageB.invert();
        for(int r = 0; r < imageB.getHeight(); r++) {
            for(int c = 0; c < imageB.getWidth(); c++) {
                assertEquals(imageB.getPixel(r, c), 255 - imageC.getPixel(r, c));
            }
        }
    }
    public void testMirror() {
        Image image = new Image(imageC);
        image.mirror(Image.Axis.VERTICAL);
        image.mirror(Image.Axis.HORIZONTAL);
        for(int r = 0, x = image.getHeight() - 1; r < image.getHeight(); r++, x--) {
            for(int c = 0, y = image.getWidth() - 1; c < image.getWidth(); c++, y--) {
                assertEquals(image.getPixel(r, c), imageC.getPixel(x, y));
            }
        }
    }
}