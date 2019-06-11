/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import java.util.Iterator;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;


/**
 *
 * @author MVale
 */
public class Play extends BasicGameState {

    Ship spaceShip;
    float timeCounter;
    String mouse = "No input yet";
    AsteroidGenerator asteroidGenerator;

        
    public Play(int state){
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        this.spaceShip = new Ship(320, 180, "res/ship.png", 335, 180);
        this.spaceShip.img.setCenterOfRotation(28, 28);
        
        timeCounter = 0;
        this.asteroidGenerator = new AsteroidGenerator(1280, 960);
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs){
        //grphcs.drawString("shots: " + spaceShip.shots.shots.isEmpty(), 0, 0);
        //grphcs.drawString("ASTEROIDS", 1280/2, 960/2);
        //grphcs.drawRect(50, 100, 20 , 60);
        grphcs.drawString(mouse, 50, 50);
        
        spaceShip.img.draw(spaceShip.x, spaceShip.y, 50, 50);
        grphcs.draw(spaceShip.moldura);
        
        //spaceShip.drawObject(grphcs);
        
        this.asteroidGenerator.showAsteroids(grphcs);
        spaceShip.showShots(grphcs);
        
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        int x = Mouse.getX();
        int y = Mouse.getY();
        mouse = "x :" + x + " y: " + y;
        Input input = gc.getInput();
        this.asteroidGenerator.spawnAsteroids(delta, this.spaceShip);
        
        if(input.isKeyDown(Keyboard.KEY_RETURN)){
            sbg.enterState(1);
        }
        
        if(input.isKeyDown(Keyboard.KEY_W)){
            spaceShip.accelerate(-0.01);
        }
        if(input.isKeyDown(Keyboard.KEY_S)){
            spaceShip.accelerate(0.01);
        }
        
        if(input.isKeyDown(Keyboard.KEY_A)){
            spaceShip.turn(-0.24f * delta);
            spaceShip.img.rotate(-0.24f * delta);
        }
        
        if(input.isKeyDown(Keyboard.KEY_D)){
            spaceShip.turn(0.24f * delta);
            spaceShip.img.rotate(0.24f * delta);
        }
        
        if(input.isKeyDown(Keyboard.KEY_F) && timeCounter >= 5 *delta){
            timeCounter = 0;
            spaceShip.shoot();
        }
        
        spaceShip.moldura.setCenterX(spaceShip.x);
        spaceShip.moldura.setCenterY(spaceShip.y);
        
        timeCounter += delta;
        spaceShip.moveShots(delta, asteroidGenerator);
        spaceShip.y += delta * spaceShip.vely;
        spaceShip.x += delta * spaceShip.velx;
        spaceShip.bicoX += delta * spaceShip.velx;
        spaceShip.bicoY += delta * spaceShip.vely;
        this.asteroidGenerator.moveAsteroids();
        
        Iterator<Shot> iterShots = spaceShip.shots.iterator();
        Iterator<Asteroid> iterAsts = this.asteroidGenerator.asteroids.iterator();
        
        while(iterAsts.hasNext()){
            Asteroid ast = iterAsts.next();
            if(ast.moldura.intersects(spaceShip.moldura)){
                sbg.enterState(0);
                sbg.init(gc);
            }
            while(iterShots.hasNext()){
                Shot s = iterShots.next();
                if(s.moldura.intersects(ast.moldura)){
                    iterShots.remove();
                    iterAsts.remove();
                    //this.asteroidGenerator.asteroids.remove(ast);
                }
            }
            
            
        }
        
        
        
    }

    @Override
    public int getID() {
        return 1; //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

