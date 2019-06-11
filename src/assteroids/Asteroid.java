/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;

import org.newdawn.slick.SlickException;
import java.lang.Math;
import java.util.Iterator;

/**
 *
 * @author dlcaio
 */
public class Asteroid extends GameObject{
    
    
    public Asteroid(int x, int y, String ref, Ship player) throws SlickException {
        super(x, y, ref);
        
        this.direction = (float) Math.asin((Math.abs(player.x - this.x))/(Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2))));
        this.velx = (2*(player.x - this.x))/Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        this.vely = (2*(player.y - this.y))/Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        this.img.setRotation((float) Math.toDegrees(-this.direction));
    }
    
    public void move(){
        this.x += this.velx;
        this.y += this.vely;
        
        
    }
    
        
}

