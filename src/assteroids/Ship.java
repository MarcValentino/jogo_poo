/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;


import java.lang.Math;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
/**
 *
 * @author MVale
 */
public class Ship extends GameObject{
    ShotArray shots;
    float shootDelay;
    float counter;
    
    Ship(int x, int y, String ref) throws SlickException{
        super(x, y, ref);
        imgscale = 0.1f;
        this.shots = new ShotArray();
        this.img.setCenterOfRotation((this.img.getWidth()/2)*this.imgscale, (this.img.getWidth()/2)*this.imgscale);
        this.velx = 0; this.vely = 0;
        this.direction = 90;
        shootDelay = 2f;
        counter = 0;
    }
    
    void accelerate(double amount){
        
        this.velx += amount * Math.cos(Math.toRadians(this.direction));
        this.vely += amount * Math.sin(Math.toRadians(this.direction));
    }
    
    void turn(float deg){
        this.direction += deg;
    }
    
    public void shoot(GameContainer gc, int d) throws SlickException{
        Input input = gc.getInput();
        if(input.isKeyDown(Keyboard.KEY_F)){
            if(counter >= shootDelay){
                shots.add(this.x, this.y, this.direction);
                counter = 0;
            }
        }
        
    }
    
    public void move(GameContainer gc, int delta) throws SlickException {
        Input input = gc.getInput();
        if(counter <= shootDelay){
            counter += delta/1000f;
        }
        //timeCounter = 0;
        
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
        
        if(input.isKeyDown(Keyboard.KEY_F)){
            shoot(gc, delta);
        }
    }
    
    
    
    @Override
    public void draw(GameObject g){
        g.img.draw(g.x, g.y, 50, 50);
    }
    
    
}
