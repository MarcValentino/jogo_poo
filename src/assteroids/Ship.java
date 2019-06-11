/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;


import java.lang.Math;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
/**
 *
 * @author MVale
 */
public class Ship extends GameObject{
    ArrayList<Shot> shots;
    int bicoX, bicoY;
    
    
    Ship(int x, int y, String ref, int bX, int bY) throws SlickException{
        super(x, y, ref);
        this.bicoX = bX;
        this.bicoY = bY;
        imgscale = 0.1f;
        this.shots = new ArrayList<>();
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
        add(this.x, this.y, this.direction);
    }
    
    void add(int x, int y, float direction) throws SlickException{
        Shot newShot = new Shot(x, y, "res/shot.png", direction);
        //newShot.img.setCenterOfRotation(28, 28);
        newShot.img.setRotation(direction - 90);
        shots.add(newShot);
    }
    
    void remove(int index){
        shots.remove(index);
    }
    
    void moveShots(int delta, AsteroidGenerator ag){
        for(Shot shot : this.shots){
            shot.x += shot.velx * delta;
            shot.y += shot.vely * delta;
            shot.moldura.setCenterX(shot.x);
            shot.moldura.setCenterY(shot.y);
            
        }
    }
    
    void showShots(Graphics g){
        for(Shot shot : this.shots){
            shot.img.setCenterOfRotation(28, 28);
            shot.img.draw(shot.x, shot.y);
            g.draw(shot.moldura);
        }
    }

}
