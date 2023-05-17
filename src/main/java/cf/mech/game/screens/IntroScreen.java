package cf.mech.game.screens;

import cf.mech.Tool;
import cf.mech.game.Camera;
import cf.mech.game.Game;
import cf.mech.menu.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class IntroScreen extends AbstractScreen{
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(0,0,1280,720);
    }

    public IntroScreen (Game g) {

        super(null, g);
        t = new Timer(2000, this::changeScreen);
        t.start();
    }
    private Timer t;

    private void changeScreen(ActionEvent actionEvent) {
        t.stop();
        game.loadScreen(new MainMenu(game));

    }
}
