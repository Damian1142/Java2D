package cf.mech.game.map.block;

import cf.mech.game.GameObjectInterface;

public interface Block extends GameObjectInterface, Collide {

    int getID();
}
