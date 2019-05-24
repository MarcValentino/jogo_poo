/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;


import java.lang.Math;
import org.newdawn.slick.*;
/**
 *
 * @author MVale
 */
public class Ship extends GameObject{
    ShotArray shots;
    int bicoX, bicoY;
    
    Ship(int x, int y, String ref, int bX, int bY) throws SlickException{
        super(x, y, ref);
        this.bicoX = bX;
        this.bicoY = bY;
        imgscale = 0.1f;
        this.shots = new ShotArray();
        this.img.setCenterOfRotation((this.img.getWidth()/2)*this.imgscale, (this.img.getWidth()/2)*this.imgscale);
        this.velx = 0; this.vely = 0;
        this.direction = 90;
    }
    
    void accelerate(double amount){
        
        this.velx += amount * Math.cos(Math.toRadians(this.direction));
        this.vely += amount * Math.sin(Math.toRadians(this.direction));
    }
    
    void turn(float deg){
        this.direction += deg;
    }
    
    void shoot() throws SlickException{
        shots.add(this.x, this.y, this.direction);
    }
}
