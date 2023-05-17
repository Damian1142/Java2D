package cf.mech;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Tool {

    @SneakyThrows
    public static BufferedImage getImage(String path){
        return ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(path)));
    }
}
