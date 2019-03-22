import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class BufferedImgLoader {
    private BufferedImage image;

    BufferedImage loadMap(String path){
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
