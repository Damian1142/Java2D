package cf.mech.menu;

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
    private BufferedImage image;
    private BufferedImage imageArrow;

    private enum MenuE{
        JO,WO,WY
    }

    MenuE menuE = MenuE.JO;

    @SneakyThrows
    public MainMenu(JPanel p, Timer t) {
        timer = new Timer(17, this::update);
        panel = p;
        this.t = t;
        image = ImageIO.read(Objects.requireNonNull(Player.class.getResource("/menu/tlo/tlo.png")));
        imageArrow = ImageIO.read(Objects.requireNonNull(Player.class.getResource("/menu/arrow.png")));
    }
    private boolean keyD = true;
    private void update(ActionEvent actionEvent) {

        if (KeyLoger.keys[KeyEvent.VK_DOWN]){
            if (keyD)
                switch (menuE){
                    case JO: menuE = MenuE.WO; break;
                    case WO: menuE = MenuE.WY; break;
                    case WY: break;
                }
            keyD = false;
        } else if (KeyLoger.keys[KeyEvent.VK_UP]) {
            if(keyD)
                switch (menuE){
                    case JO: break;
                    case WO: menuE = MenuE.JO; break;
                    case WY: menuE = MenuE.WO; break;
                }
            keyD = false;

        } else if (KeyLoger.keys[KeyEvent.VK_ENTER]) {
            switch (menuE){
                case JO: stop(); break;
                case WO: break;
                case WY: System.exit(0);
            }
            keyD = true;
        }else keyD = true;
        panel.repaint();
    }

    public void paint(Graphics g){
        g.drawImage(image,0,0,null);
        g.drawImage(imageArrow,1000, menuE == MenuE.JO ? 150 : menuE == MenuE.WO ? 300 : 450,null);
    }
    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
        t.start();
    }
}
