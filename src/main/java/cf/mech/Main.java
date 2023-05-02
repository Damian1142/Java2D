package cf.mech;

import cf.mech.game.Game;
import cf.mech.game.KeyLoger;
import lombok.SneakyThrows;

import javax.swing.*;
import java.io.File;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        JFrame jf = new JFrame("2D");
        Game game = new Game();
        init(jf,game);
    }
    private static void init(JFrame jf,Game gm){
        jf.setBounds(0,0,1280,720);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.add(gm);
        jf.addKeyListener(new KeyLoger());
    }
}