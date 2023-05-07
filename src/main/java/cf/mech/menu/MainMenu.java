package cf.mech.menu;

import cf.mech.Main;
import cf.mech.game.KeyLoger;
import cf.mech.game.Player;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MainMenu {

    public Timer timer;
    private Timer t;
    private JPanel panel;
    private BufferedImage image,imageArrow,imageTlo1;

    private int tloNbr = 0;

    private static MenuE menuE = MenuE.JO;
    private static MenuW menuW = MenuW.UT;
    private InputServerInfoDialog serverInfo;

    @SneakyThrows
    public MainMenu(JPanel p, Timer t, JFrame jf) {
        timer = new Timer(17, this::update);
        panel = p;
        this.t = t;
        serverInfo =  new InputServerInfoDialog(jf);
        image = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("menu/tlo/tlo.png")));
        imageArrow = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("menu/arrow.png")));
        imageTlo1 = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("menu/tlo/wo1tlo.png")));
    }
    private boolean keyD = true;
    private void update(ActionEvent actionEvent) {

        if (tloNbr == 0) {
            if (KeyLoger.keys[KeyEvent.VK_DOWN]) {
                if (keyD)
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
                        stop();
                        break;
                    case WO:
                        tloNbr = 1;
                        break;
                    case WY:
                        System.exit(0);
                }
                keyD = true;
            } else keyD = true;
        } else if (tloNbr == 1) {
            /*
            Menu 2
             */
            if (KeyLoger.keys[KeyEvent.VK_DOWN]) {
                if (keyD)
                    switch (menuW) {
                        case UT: menuW = MenuW.DO; break;
                    }
                keyD = false;
            } else if (KeyLoger.keys[KeyEvent.VK_UP]) {
                if (keyD)
                    switch (menuW) {
                        case DO: menuW = MenuW.UT; break;
                    }
                keyD = false;

            } else if (KeyLoger.keys[KeyEvent.VK_ENTER]) {
                switch (menuW) {
                    case DO:
                        serverInfo.setVisible(true);
                }
                keyD = true;
            } else keyD = true;
        }
        panel.repaint();

    }

    public void paint(Graphics g){
        if (tloNbr == 0) {
            g.drawImage(image, 0, 0, null);
            g.drawImage(imageArrow, 1000, menuE == MenuE.JO ? 150 : menuE == MenuE.WO ? 300 : 450, null);
        } else if (tloNbr == 1) {
            g.drawImage(imageTlo1, 0, 0, null);
            g.drawImage(imageArrow, 750, menuE == MenuE.JO ? 150 : 200, null);
        }
    }
    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
        t.start();
    }

    public static MenuE getMenuE() {
        return menuE;
    }


}
