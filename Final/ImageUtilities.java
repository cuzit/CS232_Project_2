public class ImageUtilities {
    public static Image loadJPEG(String filename) throws java.io.IOException {
        java.awt.image.BufferedImage colorimg = javax.imageio.ImageIO.read(new java.io.File(filename));
        java.awt.image.BufferedImage grayimg = new java.awt.image.BufferedImage(colorimg.getWidth(), 
                                                                                colorimg.getHeight(), 
                                                                                java.awt.image.BufferedImage.TYPE_BYTE_GRAY);
        java.awt.Graphics g = grayimg.getGraphics();
        g.drawImage(colorimg, 0, 0, null);
        g.dispose();
        javax.imageio.ImageIO.write(grayimg, "jpg", new java.io.File("test.jpg"));
        java.awt.image.Raster raster = grayimg.getData();
        int w = grayimg.getWidth();
        int h = grayimg.getHeight();
        Image image = new Image(w, h);
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                image.setPixel(i, j, raster.getSample(j, i, 0));
            }
        }
        return image;
    }
    
    public static void saveJPEG(Image image, String filename) throws java.io.IOException {
        javax.imageio.ImageIO.write(createBufferedImage(image), "jpg", new java.io.File(filename));
    }
    
    public static java.awt.image.BufferedImage createBufferedImage(Image image) {
        java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage(image.getWidth(), 
                                                                                      image.getHeight(),
                                                                                      java.awt.image.BufferedImage.TYPE_BYTE_GRAY);
        java.awt.image.WritableRaster raster = bufferedImage.getRaster();
        int w = image.getWidth();
        int h = image.getHeight();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                raster.setSample(j, i, 0, image.getPixel(i, j));
            }
        }
        return bufferedImage;
    }
    
    public static javax.swing.ImageIcon createImageIcon(Image image, int zoomLevel) {
        int res = java.awt.Toolkit.getDefaultToolkit().getScreenResolution();
        int pixelsPerPoint = res / 72;
        java.awt.Image bufferedImage = createBufferedImage(image);
        int newWidth = (int)(image.getWidth() * (zoomLevel + 1) * pixelsPerPoint);
        int newHeight = (int)(image.getHeight() * (zoomLevel + 1) * pixelsPerPoint);
        int scale = Math.min(newWidth, newHeight);
        java.awt.Image scaled = bufferedImage;
        if(scale > 0) scaled = bufferedImage.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
        return new javax.swing.ImageIcon(scaled);
    }
    
    public static java.awt.Font createFontForZoomLevel(int zoomLevel) {
        java.awt.Font font = new java.awt.Font(java.awt.Font.MONOSPACED, java.awt.Font.PLAIN, zoomLevel + 1);
        switch(zoomLevel) {
            case 1: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.7, 0.5)); break;
            case 2: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.7, 0.5)); break;
            case 3: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.5, 0.7)); break;
            case 4: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.5, 0.65)); break;
            case 5: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.7, 0.65)); break;
            case 6: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.6, 0.6)); break;
            case 7: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.7, 0.65)); break;
            case 8: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.7, 0.68)); break;
            case 9: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.7, 0.7)); break;
            case 10: font = font.deriveFont(java.awt.geom.AffineTransform.getScaleInstance(1.7, 0.7)); break;
        }        
        return font;
    }
    
    public static void resize(javax.swing.JTextArea textArea, AsciiImage ascii, int zoomLevel) {
        java.awt.FontMetrics fm = textArea.getFontMetrics(textArea.getFont());
        textArea.setPreferredSize(new java.awt.Dimension(ascii.getWidth() * fm.stringWidth("M"), ascii.getHeight() * fm.getHeight()));
    }
}