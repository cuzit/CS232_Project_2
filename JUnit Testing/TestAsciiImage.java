import junit.framework.*;
	
public class TestAsciiImage extends TestCase { 
    private AsciiImage imageA;
    private AsciiImage imageB;
    private AsciiImage imageC;
    public TestAsciiImage(String name) {
        super(name);
    }
    protected void setUp() { 
        imageA = new AsciiImage(100, 200);
        try {
            Image img = ImageUtilities.loadJPEG("test.jpg");
            imageB = new AsciiImage(img, 100);
            imageC = new AsciiImage(img);
        }
        catch(java.io.IOException e) {
            System.out.println(e);
            imageB = imageA;
            imageC = imageA;
        }
    }
    public void testGetsSets() {
        assertEquals(100, imageA.getWidth());
        assertEquals(200, imageA.getHeight());
        assertEquals(63, imageB.getWidth());
        assertEquals(49, imageB.getHeight());
        assertEquals(255, imageC.getWidth());
        assertEquals(198, imageC.getHeight());
        for(int r = 0; r < imageA.getHeight(); r++) {
            for(int c = 0; c < imageA.getWidth(); c++) {
                assertEquals('#', imageA.getPixel(r, c));
            }
        }
        assertEquals('O', imageB.getPixel(30, 20));
        assertEquals('$', imageC.getPixel(128, 90));
        Image img = imageC.getImage();
        assertEquals(36, imageC.getPixel(128, 90));
    }
    public void testToString() {
        String s = imageB.toString();
        assertEquals('-', s.charAt(1000));
    }

}