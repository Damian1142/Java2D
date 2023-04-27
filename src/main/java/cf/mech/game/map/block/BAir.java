package cf.mech.game.map.block;

import java.awt.*;

public class BAir implements Block{

    private Rectangle pos;

    public BAir(int x, int y) {
        pos = new Rectangle(x,y,80,80);
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void update() {

    }

    @Override
    public Rectangle getRectangle() {
        return pos;
    }

    @Override
    public boolean ifCollide(Collide c) {
        return false;
    }
}
