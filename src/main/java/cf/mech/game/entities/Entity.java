package cf.mech.game.entities;

import cf.mech.game.Camera;
import cf.mech.game.GameObject;
import cf.mech.game.map.GameMap;
import cf.mech.game.modules.ControlModule;
import cf.mech.game.modules.EntityModule;
import cf.mech.game.modules.Moduled;

import java.awt.*;
import java.util.ArrayList;

public class Entity extends GameObject implements Moduled {

    public GameMap gameMap;
    public int speed,hp,hpMax,wp,wpMax;
    protected ArrayList<EntityModule> modules;
    public Entity(String pathToImage, GameMap gm) {
        super(pathToImage);
        modules = new ArrayList<>();
        hp = 0;
        hpMax = 20;
        wp = 0;
        wpMax = 20;
        speed = 2;
        gameMap = gm;
    }

    @Override
    public void paint(Graphics g, Camera c) {

    }
}
