/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;

import org.newdawn.slick.SlickException;
import java.lang.Math;
import java.util.Iterator;
import org.newdawn.slick.geom.Circle;

/**
 *
 * @author dlcaio
 */
public class Asteroid extends GameObject{
    
    int hp;
    String ref;
    
    public Asteroid(int x, int y, String ref, Ship player) throws SlickException {
        super(x, y, ref);
        this.ref = ref;
        this.direction = (float) Math.asin((Math.abs(player.x - this.x))/(Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2))));
        this.velx = (2*(player.x - this.x))/Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        this.vely = (2*(player.y - this.y))/Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        this.img.setRotation((float) Math.toDegrees(-this.direction));
        hp = (int) (Math.random() * 4 + 1);
        this.imgscale = hp * 0.6f;
        this.img = this.img.getScaledCopy(this.imgscale);
        this.moldura = new Circle(this.x, this.y, 13 * hp);
    }
    
    public Asteroid(Asteroid asteroid) throws SlickException {
        super(asteroid.x, asteroid.y, asteroid.ref);
        
        this.direction = (float) (Math.random() * 2 *(Math.PI)); // Math.asin((Math.abs(player.x - this.x))/(Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2))));
        this.velx = Math.sqrt(Math.pow(this.velx, 2) + Math.pow(this.vely, 2)) * Math.cos(-this.direction);
        this.vely = Math.sqrt(Math.pow(this.velx, 2) + Math.pow(this.vely, 2)) * Math.sin(-this.direction);
        this.img.setRotation((float) Math.toDegrees(-this.direction));
        hp = asteroid.hp - 1;
        this.imgscale = hp * 0.6f;
        this.img = this.img.getScaledCopy(this.imgscale);
        this.moldura = new Circle(this.x, this.y, 13 * hp);
    }
    
    public void move(){
        this.x += this.velx;
        this.y += this.vely;
        
        
    }
    
        
}

