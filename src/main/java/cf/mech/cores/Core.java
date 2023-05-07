package cf.mech.cores;

import java.awt.event.ActionEvent;
import java.io.Serializable;

public interface Core extends Serializable {

    void update(ActionEvent actionEvent);
    void paint();
    void enable();
}
