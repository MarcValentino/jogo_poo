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
public class GameObject {
    public int x, y;
    Image img;
    String ref;
    float imgscale;
    float direction;
    public double velx, vely;
    Shape moldura;
    
    GameObject(int x, int y, String ref) throws SlickException{
        this.x = x;
        this.y = y;
        this.img = new Image(ref);
        this.moldura = new Circle(x, y, 50);
       
    }
    
    
    public void drawObject(Graphics gr){
        this.img.drawCentered(moldura.getCenterX(), moldura.getCenterY());
        gr.draw(moldura);
        
    }
    
}
