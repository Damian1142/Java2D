package cf.mech.game;


import cf.mech.cores.Core;
import cf.mech.cores.multilayer.MPCore;
import cf.mech.game.map.Map;
import cf.mech.menu.MainMenu;
import cf.mech.menu.MenuE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener {

    MainMenu mMenu;
    private Timer timer;
    private static ArrayList<GameObject> gameObjects;
    private ArrayList<Core> cores;

    private static boolean mp;
    public static Map map;
    public Game(JFrame jf) {
        timer = new Timer(17,this);
        //timer.start();
        gameObjects = new ArrayList<>();
        cores = new ArrayList<>();
        cores.add(new MPCore("",0));
        map = new Map(14,9);
        gameObjects.add(map);
        gameObjects.add(new Player());
        mMenu = new MainMenu(this, timer,jf);
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
            for (Core c : cores) {
                c.paint();
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
        mp = MainMenu.getMenuE() == MenuE.WO;
        if(mp)
            cores.get(0).enable();
        repaint();
    }
    public static Player getPlayer(){
        return (Player) gameObjects.get(1);
    }
    public static boolean isMultiPlayer(){
        return mp;
    }
}
