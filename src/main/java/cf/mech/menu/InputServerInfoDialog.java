package cf.mech.menu;

import javax.swing.*;
import java.awt.*;

public class InputServerInfoDialog extends JDialog {
    JLabel label1,label2;
    JTextField field1,field2;
    JButton button;

    public InputServerInfoDialog(Frame owner) {
        super(owner, true);
        label1 = new JLabel("Podaj IP:");
        label2 = new JLabel("Podaj Port:");
        field1 = new JTextField();
        field2 = new JTextField();
        button = new JButton("OK");
    }
}
