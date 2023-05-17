package cf.mech.menu;

import cf.mech.Main;
import cf.mech.Tool;
import cf.mech.game.Game;
import cf.mech.game.ImageLoader;
import cf.mech.game.KeyLoger;
import cf.mech.game.Player;
import cf.mech.game.screens.AbstractScreen;
import cf.mech.game.screens.SinglePlayerScreen;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MainMenu extends AbstractScreen {
    //private JPanel panel;
    private BufferedImage image,imageArrow;
    private Game game;
    private MenuE menuE = MenuE.JO;

    @SneakyThrows
    public MainMenu(Game g) {
        super(Tool.getImage("menu/tlo/tlo.png"),g);
        game = g;
        image = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("menu/tlo/tlo.png")));
        imageArrow = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("menu/arrow.png")));
    }
    private boolean keyD = true;
    public void update() {
        if (KeyLoger.keys[KeyEvent.VK_DOWN]) {
            //System.out.println("down1");
            if (keyD) {
                switch (menuE) {
                    case JO:
                        menuE = MenuE.WO;
                        break;
                    case WO:
                        menuE = MenuE.WY;
                        break;
                    case WY:
                        break;
                }
            }
            keyD = false;
        } else if (KeyLoger.keys[KeyEvent.VK_UP]) {
            if (keyD)
                switch (menuE) {
                    case JO:
                        break;
                    case WO:
                        menuE = MenuE.JO;
                        break;
                    case WY:
                        menuE = MenuE.WO;
                        break;
                }
            keyD = false;

        } else if (KeyLoger.keys[KeyEvent.VK_ENTER]) {
            switch (menuE) {
                case JO:
                    game.loadScreen(new SinglePlayerScreen(game));
                    break;
                case WO:
                    break;
                case WY:
                    System.exit(0);
            }
            keyD = true;
        } else keyD = true;
        super.update();
    }

    public void paint(Graphics g){
        super.paint(g);
        //g.drawImage(image, 0, 0, null);
        g.drawImage(imageArrow, 1000, menuE == MenuE.JO ? 150 : menuE == MenuE.WO ? 300 : 450, null);
    }
}
