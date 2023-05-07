package cf.mech.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLoger implements KeyListener {

    public static boolean[] keys = new boolean[255];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Click");
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
