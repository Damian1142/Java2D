package cf.mech.game;

import java.awt.*;
import java.io.Serializable;

public interface GameObjectInterface extends Serializable {

    void paint(Graphics g, Camera c);
    void update();
    Rectangle getRectangle();
}
