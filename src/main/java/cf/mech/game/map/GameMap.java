package cf.mech.game.map;

import cf.mech.game.Camera;
import cf.mech.game.GameObject;
import cf.mech.game.GameObjectInterface;
import cf.mech.game.map.block.BAir;
import cf.mech.game.map.block.BDirt;
import cf.mech.game.map.block.Block;
import cf.mech.game.map.block.Collide;

import java.awt.*;
import java.util.Random;

public class GameMap extends GameObject implements Collide {

    Block[][] blocks;
    int w,h;

    public GameMap(int w, int h,int seed) {
        super();
        this.w = w;
        this.h = h;
        blocks = new Block[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 5 ; j++) {
                blocks[i][j] = new BAir(i,j);
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 5; j < h; j++) {
                generator(blocks,i,j);
            }
        }

        blocks[w - 2][6] = new BDirt(w -2,6);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(" " + blocks[j][i].getID() + " |");
            }
            System.out.println();
        }
        //System.exit(0);
    }


    @Override
    public void paint(Graphics g, Camera c) {
//        g.setColor(Color.BLUE);
//        g.fillRect(0,0,1280,720);
        if (blocks != null) {
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (blocks[i][j] != null)
                        blocks[i][j].paint(g, c);
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

    private void generator(Block[][] blocks,int x,int y){
        if (blocks[x][y - 1].getID() == 1){
            blocks[x][y] = new BDirt(x,y);
        } else if (new Random().nextBoolean()) {
            blocks[x][y] = new BDirt(x,y);
        } else if (x == 0 || blocks[x - 1][y - 1].getID() == 0) {
            blocks[x][y] = new BAir(x,y);
        }else{
            blocks[x][y] = new BDirt(x,y);
        }
    }
}
