package cf.mech.game;

import cf.mech.Main;
import cf.mech.game.map.block.Collide;
import cf.mech.game.modules.ControlModule;
import cf.mech.game.modules.EntityModule;
import cf.mech.game.modules.Module;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Player implements GameObject, Collide {

    ArrayList<EntityModule> modules;
    ControlModule CModule;
    //public Rectangle pos;
    private final BufferedImage image;

    @SneakyThrows
    public Player() {
        image = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("player/player.png")));
        modules = new ArrayList<>();
        CModule = new ControlModule(new Rectangle(600,100,80,80));
        modules.add(CModule);
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.drawImage(image,CModule.pos.x, CModule.pos.y,55,94, null);
        g.setColor(Color.RED);
        g.setFont(Font.getFont("sans-serif"));
        g.drawString("x: " + CModule.pos.x + ", y: " + CModule.pos.y + ", hp: " + CModule.hp + ", wp: " + CModule.wp, 10, 20);
    }

    @Override
    public void update() {

        updateModules();

        //Reguły

        if(CModule.pos.y > 800){
            kill();
        }
    }

    private void updateModules() {
        for (Module m : modules) {
            m.update();
        }
    }

    private void kill() {
        CModule.pos.setLocation(600,100);
    }

    @Override
    public Rectangle getRectangle() {
        return CModule.pos;
    }


    @Override
    public boolean ifCollide(Collide c) {
        return false;
    }
}
