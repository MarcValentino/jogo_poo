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
    
    public ArrayList<Asteroid> asteroids;
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
            int yOrX = (int) Math.round(Math.random());
            int xPos = 0; 
            int yPos = 0;
            int border;
            switch(yOrX){
                case 0:
                    border = (int) Math.round(Math.random());
                    if(border == 0){
                        xPos = 0;
                        yPos = (int)(Math.random() * 960 + 1);
                        break;
                    }
                    xPos = 1280;
                    yPos = (int)(Math.random() * 960 + 1);
                    break;
                case 1:
                    border = (int) Math.round(Math.random());
                    if(border == 0){
                        xPos = (int)(Math.random() * 1280 + 1);
                        yPos = 0;
                        break;
                    }
                    xPos = (int)(Math.random() * 1280 + 1);
                    yPos = 960;
                    break;
            }
            this.asteroids.add(new Asteroid(xPos, yPos, "res/asteroid.png", player));
            this.counter = 0;
        }         
            
    }
    
    public void moveAsteroids(){
        for(Asteroid asteroid : this.asteroids){
            asteroid.move();
            asteroid.moldura.setCenterX(asteroid.x);
            asteroid.moldura.setCenterY(asteroid.y);
        }
    }
    
    public void showAsteroids(Graphics g){
        for(Asteroid asteroid : this.asteroids){
            asteroid.img.draw(asteroid.x, asteroid.y);
            g.draw(asteroid.moldura);
        }
    }
    
}
