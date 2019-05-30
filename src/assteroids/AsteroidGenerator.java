/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import java.util.ArrayList;
import org.newdawn.slick.*;

/**
 *
 * @author MVale
 */
public class AsteroidGenerator {
    
    private ArrayList<Asteroid> asteroids;
    private int limitX, limitY;
    private float counter;
    
    AsteroidGenerator(int xBound, int yBound){
        this.limitX = xBound;
        this.limitY = yBound;
        this.asteroids = new ArrayList();
        this.counter = 0;
    }
    
    public void spawnAsteroids(int delta, Ship player) throws SlickException{
        this.counter += delta;
        if(this.counter >= 100*delta){
            this.asteroids.add(new Asteroid(640, 0, "res/asteroid.png", player));
            this.counter = 0;
        }         
            
    }
    
    public void moveAsteroids(){
        for(Asteroid asteroid : this.asteroids){
            asteroid.move();
        }
    }
    
    public void showAsteroids(){
        for(Asteroid asteroid : this.asteroids){
            asteroid.img.draw(asteroid.x, asteroid.y);
        }
    }
    
}
