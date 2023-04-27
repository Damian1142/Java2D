package cf.mech.game.map.block;

import java.awt.*;

public interface Collide {
    boolean ifCollide(Collide c);
    Rectangle getRectangle();
}
