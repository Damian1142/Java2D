package cf.mech.game.modules;

import cf.mech.game.Game;
import cf.mech.game.KeyLoger;
import cf.mech.game.Player;
import cf.mech.game.entities.Entity;
import cf.mech.game.map.block.PosCollide;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ControlModule implements EntityModule {

    private Entity entity;

    public ControlModule(Entity e) {
        entity = e;
    }

    @Override
    public void update() {
        if (!entity.gameMap.ifCollide(new PosCollide(entity.x, entity.y + entity.wp + 1))){
            if (entity.wp < entity.wpMax)
                entity.wp += 2;
            if (KeyLoger.keys[KeyEvent.VK_LEFT] && entity.hp > entity.hpMax * -1){
                entity.hp += entity.speed * -1 / 2;
            }else if (KeyLoger.keys[KeyEvent.VK_RIGHT] && entity.hp < entity.hpMax){
                entity.hp += entity.speed / 2;
            }else if (entity.hp > 0){
                entity.hp -= 1;
            } else if (entity.hp < 0) {
                entity.hp += 1;
            }
        }else{
            entity.wp = 0;
            if (KeyLoger.keys[KeyEvent.VK_SPACE]){
                entity.wp -= 20;
            }
            if (KeyLoger.keys[KeyEvent.VK_LEFT] && entity.hp > entity.hpMax * -1){
                entity.hp += entity.speed * -1;
            }else if (KeyLoger.keys[KeyEvent.VK_RIGHT] && entity.hp < entity.hpMax){
                entity.hp += entity.speed;
            }else if (entity.hp > 0){
                entity.hp -= 1;
            } else if (entity.hp < 0) {
                entity.hp += 1;
            }
        }
        entity.y += entity.wp;
        if (entity.gameMap.ifCollide(new PosCollide(entity.x + entity.hp, entity.y)))
            entity.hp = 0;

        entity.x += entity.hp;
    }
}
