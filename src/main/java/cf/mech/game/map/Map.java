package cf.mech.game.map;

import cf.mech.game.GameObject;
import cf.mech.game.Player;
import cf.mech.game.map.block.BAir;
import cf.mech.game.map.block.BDirt;
import cf.mech.game.map.block.Block;
import cf.mech.game.map.block.Collide;

import java.awt.*;

public class Map implements GameObject, Collide {

    Block[][] blocks;
    int w,h;

    public Map(int w,int h) {
        this.w = w;
        this.h = h;
        blocks = new Block[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h - 2; j++) {
                blocks[i][j] = new BAir(i,j);
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 7; j < h; j++) {
                blocks[i][j] = new BDirt(i,j);
            }
        }

        blocks[w - 2][6] = new BDirt(w -2,6);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,1280,720);
        if (blocks != null) {
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (blocks[i][j] != null)
                        blocks[i][j].paint(g);
                }
            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    @Override
    public boolean ifCollide(Collide c) {
        if (blocks != null) {
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (blocks[i][j] != null)
                        if(blocks[i][j].ifCollide(c))
                            return true;
                }
            }
        }
        return false;
    }
}
