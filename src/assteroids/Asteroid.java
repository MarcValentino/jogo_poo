/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.geom.Circle;

/**
 *
 * @author dlcaio
 */
public class Asteroid extends GameObject{
    
    private int hp;
    
    
    public Asteroid(int x, int y, Ship player) throws SlickException {
        super(x, y, "res/asteroid.png");
        
        this.direction = (float) Math.asin((Math.abs(player.x - this.x))/(Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2))));
        this.velx = (2*(player.x - this.x))/Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        this.vely = (2*(player.y - this.y))/Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        this.img.setRotation((float) Math.toDegrees(-this.direction));
        this.hp = (int) (Math.random() * 5 + 1);
        this.imgscale = hp * 0.6f;
        this.img = this.img.getScaledCopy(this.imgscale);
        this.moldura = new Circle(this.x, this.y, 13 * hp);
    }
    
    public Asteroid(Asteroid asteroid) throws SlickException {
        super(asteroid.x, asteroid.y, asteroid.ref);
        
        this.direction = (float) (Math.random() * 2 *(Math.PI)); // Math.asin((Math.abs(player.x - this.x))/(Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2))));
        this.velx = Math.sqrt(Math.pow(asteroid.velx, 2) + Math.pow(asteroid.vely, 2)) * Math.cos(-this.direction);
        this.vely = Math.sqrt(Math.pow(asteroid.velx, 2) + Math.pow(asteroid.vely, 2)) * Math.sin(-this.direction);
        this.img.setRotation((float) Math.toDegrees(-this.direction));
        this.hp = asteroid.hp - 1;
        
        this.imgscale = this.hp * 0.6f;
        this.img = this.img.getScaledCopy(this.imgscale);
        this.moldura = new Circle(this.getX(), this.y, 13 * this.hp);
    }
    
    public void move(){
        this.x += this.velx;
        this.y += this.vely;
        
        
    }

    @Override
    public boolean bound() {
        if (this.x + this.img.getWidth()/2 < 0){
            return false;
        }
        
        if (this.x > Asteroids.windowSizeX + this.img.getWidth()/2){
            return false;            
        }
        
        if (this.y + this.img.getHeight()/2 < 0){
            return false;
        }
        
        if (this.y > Asteroids.windowSizeY + this.img.getHeight()/2){
            return false;
            
        }
        return true;
       
    }
    
    public int getHp(){
        return this.hp;
    }
    
        
}

