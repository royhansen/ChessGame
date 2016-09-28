package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(25f);
        flyCam.setDragToRotate(true);
        GameAppState state = new GameAppState();
        stateManager.attach(state);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
