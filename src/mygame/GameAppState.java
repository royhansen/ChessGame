package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;

public class GameAppState extends AbstractAppState {
    private SimpleApplication app;
    private Camera cam;
    private Node rootNode;
    private Node boardNode;
    private Node pieceNode;
    private ArrayList<Piece> pieces;
    private Geometry[][] board;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        //TODO: initialize your AppState, e.g. attach spatials to rootNode
        //this is called on the OpenGL thread after the AppState has been attached
        this.app = (SimpleApplication) app;
        this.cam = this.app.getCamera();
        this.rootNode = this.app.getRootNode();
        this.boardNode = new Node("Board");
        this.pieceNode = new Node("Pieces");
        pieces = new ArrayList<Piece>();
        
        cam.setLocation(new Vector3f(3.5f, 10, 3.5f));
        cam.lookAt(new Vector3f(3.5f, 0f, 3.5f), Vector3f.UNIT_Y);
                
        System.out.println(cam.getRotation());
        
        drawBoard();
        drawPiece();

        rootNode.attachChild(boardNode);
        rootNode.attachChild(pieceNode);
    }
    
    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
        //TODO: clean up what you initialized in the initialize method,
        //e.g. remove all spatials from rootNode
        //this is called on the OpenGL thread after the AppState has been detached
    }

    private void drawBoard() {
        board = new Geometry[8][8];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                Box square = new Box(.5f, 0f, .5f);
                Geometry geom = new Geometry("Square", square);
                Material mat = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                if (row % 2 == 0){
                    if (col % 2 == 0){
                        mat.setColor("Color", ColorRGBA.White); 
                    } else {
                        mat.setColor("Color", ColorRGBA.Brown);
                    }
                } else {
                     if (col % 2 == 0){
                        mat.setColor("Color", ColorRGBA.Brown); 
                    } else {
                        mat.setColor("Color", ColorRGBA.White);
                    }   
                }
                geom.setMaterial(mat);
                geom.setLocalTranslation(col, 0, row);
                board[row][col] = geom;
                boardNode.attachChild(geom);
            }
        }
    }
    public void drawPiece(){
        Box b = new Box(.25f, .25f, .25f);
        Geometry geom = new Geometry("Box", b);
        Material mat = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        Piece piece = new Piece();
        pieces.add(piece);
        geom.setUserData("piece", piece);
        geom.addControl(new PieceControl());
        pieceNode.attachChild(geom);
    }
}
