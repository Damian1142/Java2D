package cf.mech.game;

import cf.mech.game.screens.SinglePlayerScreen;

import java.awt.*;

public class Camera extends Rectangle {

    private SinglePlayerScreen sps;

    public Camera(SinglePlayerScreen sps) {
        super(new Point(0,0));
        this.sps = sps;
    }


    public void update() {
        x = sps.p.x - 640;
    }
}
