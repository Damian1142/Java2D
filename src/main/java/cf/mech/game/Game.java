package cf.mech.game;


import cf.mech.game.map.Map;
import cf.mech.menu.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener {

    MainMenu mMenu;
    private Timer timer;
    private ArrayList<GameObject> gameObjects;
    public static Map map;
    public Game() {
        timer = new Timer(17,this);
        //timer.start();
        gameObjects = new ArrayList<>();
        map = new Map(14,9);
        gameObjects.add(map);
        gameObjects.add(new Player());
        mMenu = new MainMenu(this, timer);
        mMenu.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paint(Graphics g){

        if (mMenu.timer.isRunning()){
            mMenu.paint(g);
        }else{
            for (GameObject go : gameObjects) {
                go.paint(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (GameObject go : gameObjects) {
            go.update();
        }
        if (KeyLoger.keys[KeyEvent.VK_ESCAPE]){
            timer.stop();
            mMenu.start();
        }

        repaint();
    }

}
