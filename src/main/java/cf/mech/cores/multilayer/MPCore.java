package cf.mech.cores.multilayer;

import javax.swing.Timer;
import cf.mech.cores.Core;
import cf.mech.game.Game;
import cf.mech.game.Player;

import java.awt.event.ActionEvent;

public class MPCore implements Core {

    Timer timer;
    private String ip;
    private int port;
    private Connection c;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public MPCore(String ip, int port) {
        timer = new Timer(17,this::update);
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void update(ActionEvent actionEvent) {
        Player p = Game.getPlayer();
        c.send(new PackageS(0,p.getRectangle(),p.getImage()));
    }

    @Override
    public void paint() {

    }

    @Override
    public void enable() {
        if (!timer.isRunning()) {
            timer.start();
            c = new Connection(ip,port);
            c.init();
        }
    }
}
