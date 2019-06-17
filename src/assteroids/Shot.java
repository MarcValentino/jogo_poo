/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import java.util.ArrayList;
import org.newdawn.slick.*;
import java.lang.Math;
import java.util.Iterator;
import java.util.List;
import org.newdawn.slick.geom.Circle;
/**
 *
 * @author MVale
 */
class Shot extends GameObject{
    
    Shot(int x, int y, float direction) throws SlickException{
        super(x, y, "res/shot.png");
        this.velx = -1 * Math.cos(Math.toRadians(direction));
        this.vely = -1 * Math.sin(Math.toRadians(direction));
        this.direction = direction;
        this.moldura = new Circle(this.x, this.y, 10);
        }

    @Override
    public boolean bound() {
        if (this.x + this.img.getWidth()/2 < 0){
            return false;
        }
        
        if (this.x > 1280 + this.img.getWidth()/2){
            return false;            
        }
        
        if (this.y + this.img.getHeight()/2 < 0){
            return false;
        }
        
        if (this.y > 960 + this.img.getHeight()/2){
            return false;
            
        }
        return true;
       
    }
}



