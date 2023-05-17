package cf.mech.game.screens;

import cf.mech.game.Camera;
import cf.mech.game.Game;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;

@RequiredArgsConstructor
public abstract class AbstractScreen implements Screen {

    @Getter
    protected final BufferedImage tlo;

    protected final Game game;

    public Camera camera;

    @Override
    public void paint(Graphics g) {
        g.drawImage(getTlo(),0,0,null);
    }

    @Override
    public void update() {
        game.repaint();
    }
}
