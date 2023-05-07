package cf.mech.cores.multilayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PackageS implements Serializable {
    private int levelID;
    private Rectangle pos;
    private BufferedImage texture;


}
