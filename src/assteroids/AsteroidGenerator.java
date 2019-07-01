/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.*;

/**
 *
 * @author MVale
 */
public class AsteroidGenerator {
    
    private ArrayList<Asteroid> asteroids;
    private float counter;
    
    AsteroidGenerator(){
        
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
                        yPos = (int)(Math.random() * Asteroids.windowSizeY + 1);
                        break;
                    }
                    xPos = Asteroids.windowSizeX;
                    yPos = (int)(Math.random() * Asteroids.windowSizeY + 1);
                    break;
                case 1:
                    border = (int) Math.round(Math.random());
                    if(border == 0){
                        xPos = (int)(Math.random() * Asteroids.windowSizeX + 1);
                        yPos = 0;
                        break;
                    }
                    xPos = (int)(Math.random() * Asteroids.windowSizeX + 1);
                    yPos = Asteroids.windowSizeY;
                    break;
            }
            this.asteroids.add(new Asteroid(xPos, yPos, player));
            this.counter = 0;
        }         
    }
    
    public void spawn(Asteroid asteroid) throws SlickException{
        this.asteroids.add(new Asteroid(asteroid));
        this.asteroids.add(new Asteroid(asteroid));
    }
    
    public void moveAsteroids(){
        Iterator<Asteroid> iterAsts = this.asteroids.iterator();
        
        while(iterAsts.hasNext()){
            Asteroid ast = iterAsts.next();
            ast.move();
            ast.moldura.setCenterX((float) (ast.getX()));
            
            ast.moldura.setCenterY((float) (ast.y));
            if(ast.bound() == false){
                iterAsts.remove();         
            }
        }
    }
    
    public void behaveAsts(int delta, Ship s) throws SlickException{
        spawnAsteroids(delta, s);
        moveAsteroids();
        
        
    }
    
    public int count(){
        int x = 0;
        for(Asteroid a : this.asteroids){
            x += 1;
        }
        return x;
    }
    
    public void showAsteroids(Graphics g){
        for(Asteroid asteroid : this.asteroids){
            asteroid.drawObject(g);
        }
    }
    
    public ArrayList<Asteroid> getAsteroids(){
        return this.asteroids;
    }
    
    public void setAsteroids(ArrayList<Asteroid> asteroids){
        this.asteroids = asteroids;
    }
    
}
