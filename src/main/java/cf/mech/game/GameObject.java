package cf.mech.game;

import cf.mech.Tool;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject extends Rectangle implements GameObjectInterface{

     protected BufferedImage image;

    public GameObject(String pathToImage) {
        image = Tool.getImage(pathToImage);
    }

    public GameObject(){}

    @Override
    public void paint(Graphics g, Camera c) {
        g.drawImage(image,x,y,null);
    }

    @Override
    public void update() {

    }

    @Override
    public Rectangle getRectangle() {
        return this;
    }
}
