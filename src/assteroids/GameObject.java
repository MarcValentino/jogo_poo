/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import org.newdawn.slick.*;
/**
 *
 * @author MVale
 */
public abstract class GameObject {
    public int x, y;
    Image img;
    float imgscale;
    float direction;
    public double velx, vely;
    
    GameObject(int x, int y, String ref) throws SlickException{
        this.x = x;
        this.y = y;
        this.img = new Image(ref);
    }
}
