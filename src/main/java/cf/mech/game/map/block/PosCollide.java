package cf.mech.game.map.block;

import java.awt.*;

public class PosCollide implements Collide{

    public Rectangle r;

    public PosCollide(int x, int y, int w, int h) {
        r = new Rectangle(x,y,w,h);
    }

    public PosCollide(int x, int y) {
        r = new Rectangle(x,y,55,94);
    }

    @Override
    public boolean ifCollide(Collide c) {
        return false;
    }

    @Override
    public Rectangle getRectangle() {
        return r;
    }
}
