/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public void enter(GameContainer container, StateBasedGame game) throws SlickException{
        init(container, game);
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        this.spaceShip = new Ship(320, 180, "res/ship.png", 335, 180);
        //this.spaceShip.img.setCenterOfRotation(28, 28);
        
        timeCounter = 0;
        this.asteroidGenerator = new AsteroidGenerator(1280, 960);
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs){
        spaceShip.drawObject(grphcs);
        asteroidGenerator.showAsteroids(grphcs);
        spaceShip.showShots(grphcs);
        
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        float dt = delta/1000f;
        Input input = gc.getInput();
        if(input.isKeyDown(Keyboard.KEY_RETURN)){
            sbg.enterState(1);
        }
        
        this.asteroidGenerator.spawnAsteroids(delta, this.spaceShip);
        spaceShip.behave(gc, delta); // Lógica de movimento da nave
        this.asteroidGenerator.moveAsteroids();
        collision(sbg);
    }
    
    public void collision(StateBasedGame sbg) throws SlickException{
    Iterator<Asteroid> iterAsts = this.asteroidGenerator.asteroids.iterator();
    Asteroid temp = null;
    
        
        while(iterAsts.hasNext()){
            Asteroid ast = iterAsts.next();
            if(ast.moldura.intersects(spaceShip.moldura)){
                sbg.enterState(0);
            }
            Iterator<Shot> iterShots = spaceShip.shots.iterator();
            while(iterShots.hasNext()){
                Shot s = iterShots.next();
                if(s.moldura.intersects(ast.moldura)){
                    iterShots.remove();
                    System.out.println("temp antes de ter ast atribuido a si " + temp);
                    temp = ast;
                    System.out.println("temp depois de ter ast atribuido a si " + temp);
                    iterAsts.remove();
                  
                    break;
                }
            }            
        }
        
        if(temp!=null && temp.hp > 1){
            
            System.out.println("entrou em temp != null");
            this.asteroidGenerator.spawn(temp);
        }
        
    }
    

    @Override
    public int getID() {
        return 1; //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

