package cf.mech.game;

import java.awt.*;
import java.io.Serializable;

public interface GameObject extends Serializable {

    void paint(Graphics g);
    void update();
    Rectangle getRectangle();
}
