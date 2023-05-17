package cf.mech.game.map.block;

import cf.mech.game.Camera;
import cf.mech.game.Player;

import java.awt.*;

public class BDirt implements Block{

    Rectangle pos;

    public BDirt(int x, int y) {
        pos = new Rectangle(x,y,80,80);
    }
    @Override
    public void paint(Graphics g, Camera c) {
        g.setColor(new Color(0x66260d));
        if (c.x>0)
            g.fillRect(pos.x * 80 - c.x, pos.y * 80- c.y, pos.width, pos.height);
        else
            g.fillRect(pos.x * 80, pos.y * 80, pos.width, pos.height);
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
        Rectangle tempPos = new Rectangle(pos.x * 80,pos.y * 80,80,80);
        boolean cb = tempPos.intersects(c.getRectangle());
        return cb;
    }

    @Override
    public int getID() {
        return 1;
    }
}
