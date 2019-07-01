/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
/**
 *
 * @author MVale
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    Image img;
    String ref;
    protected float imgscale;
    protected float direction;
    protected double velx, vely;
    protected Shape moldura;
    
    GameObject(int x, int y, String ref) throws SlickException{
        this.x = x;
        this.y = y;
        this.ref = ref;
        this.img = new Image(this.ref);
        this.moldura = new Circle(x, y, 40);
       
    }
    
    
    public void drawObject(Graphics gr){
        this.img.drawCentered(moldura.getCenterX(), moldura.getCenterY());
        
    }
    
    public abstract boolean bound();

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    
}
