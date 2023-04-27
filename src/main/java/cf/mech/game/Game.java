package cf.mech.game;


import cf.mech.game.map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener {

    private Timer timer;
    private ArrayList<GameObject> gameObjects;
    public static Map map;
    public Game() {
        timer = new Timer(17,this);
        timer.start();
        gameObjects = new ArrayList<>();
        map = new Map(14,9);
        gameObjects.add(map);
        gameObjects.add(new Player());

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paint(Graphics g){
        for (GameObject go : gameObjects) {
            go.paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (GameObject go : gameObjects) {
            go.update();
        }
        repaint();
    }

}
