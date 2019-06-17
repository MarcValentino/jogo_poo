/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;


import java.lang.Math;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
/**
 *
 * @author MVale
 */
public class Ship extends GameObject{
    ArrayList<Shot> shots;
    float timeCounter;
    
    
    Ship(int x, int y) throws SlickException{
        super(x, y, "res/ship.png");
        imgscale = 0.1f;
        this.shots = new ArrayList<>();
        this.img.setCenterOfRotation(moldura.getCenterX(), moldura.getCenterY());
        this.img = this.img.getScaledCopy(imgscale);
        //System.out.println((this.img.getWidth()/2)*this.imgscale);
        this.velx = 0; this.vely = 0;
        this.direction = 90;
        timeCounter = 0;

        
    }
  
    
    void accelerate(double amount){
        
        this.velx += amount * Math.cos(Math.toRadians(this.direction));
        this.vely += amount * Math.sin(Math.toRadians(this.direction));
    }
    
    void turn(float deg){
        this.direction += deg;
    }
    
    void shoot() throws SlickException{
        add((int)this.moldura.getCenterX(), (int)this.moldura.getCenterY(), this.direction);
    }
    
    public void behave(GameContainer gc, float delta) throws SlickException{
        Input input = gc.getInput();
        if(input.isKeyDown(Keyboard.KEY_W)){
            this.accelerate(-0.01);
        }
        if(input.isKeyDown(Keyboard.KEY_S)){
            this.accelerate(0.01);
        }
        
        if(input.isKeyDown(Keyboard.KEY_A)){
            this.turn(-0.24f * delta);
            this.img.rotate(-0.24f * delta);
        }
        
        if(input.isKeyDown(Keyboard.KEY_D)){
            this.turn(0.24f * delta);
            this.img.rotate(0.24f * delta);
        }
        
        this.y += delta * this.vely;
        this.x += delta * this.velx;
        
        moldura.setCenterX(this.x + this.img.getWidth()/2 * 0.1f);
        moldura.setCenterY(this.y + this.img.getHeight()/2 * 0.1f);
        
        if(input.isKeyDown(Keyboard.KEY_F) && timeCounter >= 0.3){
            timeCounter = 0;
            shoot();
        }
        
        timeCounter += delta/1000f;
        moveShots(delta);
        
    }
    
    void add(int x, int y, float direction) throws SlickException{
        Shot newShot = new Shot(x, y, direction);
        //newShot.img.setCenterOfRotation(28, 28);
        newShot.img.setRotation(direction - 90);
        shots.add(newShot);
    }
    
    void remove(int index){
        shots.remove(index);
    }
    
    void moveShots(float delta){
        Iterator<Shot> iterShots = this.shots.iterator();
        
        while(iterShots.hasNext()){
            Shot s = iterShots.next();
            s.moldura.setX((float) (s.moldura.getX() + s.velx * delta));
            s.x = (int) s.moldura.getX();
            s.moldura.setY((float) (s.moldura.getY() + s.vely * delta));
            s.y = (int) s.moldura.getY();
            if(s.bound() == false){
                iterShots.remove();
                
            }
        
        }
        
    }
    
    void showShots(Graphics g){
        for(Shot shot : this.shots){
            shot.img.drawCentered(shot.moldura.getCenterX(), shot.moldura.getCenterY());
            g.draw(shot.moldura);
        }
    }

    @Override
    public boolean bound() {
        if (this.x + this.img.getWidth()/2 < 0){
            this.x = 1280 + this.img.getWidth()/2;
        }
        
        if (this.x > 1280 + this.img.getWidth()/2){
            this.x = 0 - this.img.getWidth()/2;
            
        }
        
        if (this.y + this.img.getHeight()/2 < 0){
            this.y = 960 + this.img.getHeight()/2;
        }
        
        if (this.y > 960 + this.img.getHeight()/2){
            this.y = 0 - this.img.getHeight()/2;
            
        }
       
        return true;
    }

}
