
package mygame;

import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.Savable;
import java.io.IOException;


public class Piece implements Savable {
    private int value;
    private String type;
    private int player;
    private int location;
    
    public Piece(){
        this.value = 1;
        this.type = "pawn";
        this.player = 1;
        this.location = 12;
    }
    
    public String getPieceType(){
        return this.type;
    }
    
    public int getPieceValue(){
        return this.value;
    }
    
    public int getPlayer(){
        return this.player;
    }
    
    public int getLocation(){
        return this.location;
    }

    public void write(JmeExporter ex) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void read(JmeImporter im) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
