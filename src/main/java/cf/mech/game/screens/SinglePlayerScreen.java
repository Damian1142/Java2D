package cf.mech.game.screens;

import cf.mech.Tool;
import cf.mech.game.Camera;
import cf.mech.game.Game;
import cf.mech.game.Player;
import cf.mech.game.map.GameMap;

import java.awt.*;

public class SinglePlayerScreen extends AbstractScreen{

    private GameMap gameMap;
    public Player p;
    public SinglePlayerScreen(String tloPath, Game game) {
        super(Tool.getImage(tloPath), game);
        init();
    }
    public SinglePlayerScreen(Game game) {
        super(Tool.getImage("tlo/telko.png"), game);
        init();
    }

    private void init(){

        camera = new Camera(this);
        gameMap = new GameMap(60,20,4);
        p = new Player(this, gameMap);
    }

    @Override
    public void update() {
        super.update();
        camera.update();
        p.update();
        gameMap.update();
    }

    @Override
    public void paint(Graphics g) {
        if (camera.x > 0)
            g.drawImage(tlo, -camera.x,-camera.y, null);
        else
            g.drawImage(tlo,0,0,null);
        gameMap.paint(g, camera);
        p.paint(g, camera);

    }
}
