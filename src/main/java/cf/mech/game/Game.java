package cf.mech.game;

import cf.mech.game.screens.IntroScreen;
import cf.mech.game.screens.Screen;
import cf.mech.game.screens.ScreenLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Game extends JPanel implements ScreenLoader {

    private Timer timer;

    private Screen actualScreen;

    public Game() {
        actualScreen = new IntroScreen(this);
        timer = new Timer(6, this::update);
        timer.start();
    }

    private void update(ActionEvent actionEvent) {
        actualScreen.update();
    }

    @Override
    public void paint(Graphics g) {
        actualScreen.paint(g);
    }

    @Override
    public void loadScreen(Screen s) {
        actualScreen = s;
    }
}
