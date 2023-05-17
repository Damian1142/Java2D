package cf.mech.game;

import cf.mech.Main;
import cf.mech.game.entities.Entity;
import cf.mech.game.map.GameMap;
import cf.mech.game.map.block.Collide;
import cf.mech.game.modules.ControlModule;
import cf.mech.game.modules.EntityModule;
import cf.mech.game.modules.Module;
import cf.mech.game.screens.SinglePlayerScreen;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Player extends Entity implements Collide {

    private SinglePlayerScreen sps;
    private ControlModule CModule;
    //public Rectangle pos;

    @SneakyThrows
    public Player(SinglePlayerScreen sps, GameMap gm) {
        super("player/player.png", gm);
        CModule = new ControlModule(this);
        modules.add(CModule);
        this.sps = sps;
    }


    @Override
    public void paint(Graphics g, Camera c) {
        if (c.x > 0)
            g.drawImage(image, x - c.x, y - c.y,55,94, null);
        else
            g.drawImage(image, x, y,55,94, null);
        g.setColor(Color.RED);
        g.setFont(Font.getFont("sans-serif"));
        g.drawString("x: " + x + ", y: " + y + ", hp: " + hp + ", wp: " + wp, 10, 20);
    }

    @Override
    public void update() {

        updateModules();

        //Reguły

        if(y > 800){
            kill();
        }
    }

    private void updateModules() {
        for (Module m : modules) {
            m.update();
        }
    }

    private void kill() {
        this.setLocation(600,100);
    }

    @Override
    public Rectangle getRectangle() {
        return this;
    }

    public BufferedImage getImage(){
        return image;
    }


    @Override
    public boolean ifCollide(Collide c) {
        return false;
    }
}
