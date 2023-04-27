package cf.mech.game.modules;

import cf.mech.game.Game;
import cf.mech.game.KeyLoger;
import cf.mech.game.map.block.PosCollide;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ControlModule implements EntityModule {

    public int speed,hp,hpMax,wp,wpMax;

    public Rectangle pos;

    public ControlModule(Rectangle pos) {
        this.pos = pos;
        hp = 0;
        hpMax = 20;
        wp = 0;
        wpMax = 20;
        speed = 2;
    }

    @Override
    public void update() {
        if (!Game.map.ifCollide(new PosCollide(pos.x, pos.y + wp + 1))){
            if (wp < wpMax)
                wp+= 2;
            if (KeyLoger.keys[KeyEvent.VK_LEFT] && hp > hpMax * -1){
                hp += speed * -1 / 2;
            }else if (KeyLoger.keys[KeyEvent.VK_RIGHT] && hp < hpMax){
                hp += speed / 2;
            }else if (hp > 0){
                hp -= 1;
            } else if (hp < 0) {
                hp += 1;
            }
        }else{
            wp = 0;
            if (KeyLoger.keys[KeyEvent.VK_SPACE]){
                wp -= 20;
            }
            if (KeyLoger.keys[KeyEvent.VK_LEFT] && hp > hpMax * -1){
                hp += speed * -1;
            }else if (KeyLoger.keys[KeyEvent.VK_RIGHT] && hp < hpMax){
                hp += speed;
            }else if (hp > 0){
                hp -= 1;
            } else if (hp < 0) {
                hp += 1;
            }
        }
        pos.setLocation(pos.x,pos.y + wp);
        if (Game.map.ifCollide(new PosCollide(pos.x + hp, pos.y)))
            hp = 0;

        pos.setLocation(pos.x + hp,pos.y);
    }
}
