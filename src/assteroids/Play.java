/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
/**
 *
 * @author MVale
 */
public class Play extends BasicGameState {

    Ship spaceShip;
    float timeCounter;
    String mouse = "No input yet";
    Asteroid ast;
    
    public Play(int state){
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        this.spaceShip = new Ship(320, 180, "res/ship.png");
        this.spaceShip.img.setCenterOfRotation(28, 28);
        this.ast = new Asteroid(500, 500, "res/ast1.png");
        this.ast.img.setCenterOfRotation(25, 25);
    }
    
    
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        int x = Mouse.getX();
        int y = Mouse.getY();
        mouse = "x :" + spaceShip.x + " y: " + spaceShip.y;
        
        Input input = gc.getInput();
        
        ast.spin(-0.24f * delta);
        ast.img.rotate(-0.24f * delta);

        if(input.isKeyDown(Keyboard.KEY_RETURN)){
            sbg.enterState(1);
        }
        
        
        spaceShip.move(gc, delta);
        
        spaceShip.shots.moveShots(delta);
        spaceShip.y += delta * spaceShip.vely;
        spaceShip.x += delta * spaceShip.velx;
           
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs){
        //grphcs.drawString("shots: " + spaceShip.shots.shots.isEmpty(), 0, 0);
        //grphcs.drawString("ASTEROIDS", 1280/2, 960/2);
        //grphcs.drawRect(50, 100, 20 , 60);
        
        grphcs.drawString(mouse, 50, 50);
        spaceShip.draw(spaceShip);
        ast.img.draw(500, 500, 100, 100);
        
        if(spaceShip.x > 1280){
            spaceShip.x = (int) -(spaceShip.img.getWidth() * spaceShip.imgscale);
            spaceShip.img.draw(spaceShip.x, spaceShip.y, 50, 50);
        }
        
        if(spaceShip.x + spaceShip.img.getWidth() * spaceShip.imgscale  < 0){
           
            spaceShip.x = 1280;
            spaceShip.img.draw(spaceShip.x, spaceShip.y, 50, 50);
        }
        
        if(spaceShip.y > 960){
            spaceShip.y = (int) -(spaceShip.img.getHeight() * spaceShip.imgscale);
            spaceShip.img.draw(spaceShip.x, spaceShip.y, 50, 50);
        }
        
        if(spaceShip.y + spaceShip.img.getHeight() * spaceShip.imgscale  < 0){
           
            spaceShip.y = 960;
            spaceShip.img.draw(spaceShip.x, spaceShip.y, 50, 50);
        }
        
        spaceShip.shots.showShots();
    }

    
    

    @Override
    public int getID() {
        return 1; //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

