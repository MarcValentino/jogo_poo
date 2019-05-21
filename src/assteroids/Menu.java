/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;


import org.lwjgl.input.Keyboard;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

/**
 *
 * @author MVale
 */


public class Menu extends BasicGameState{
    
    Image pressStart, fAsteroid;
    String mouse = "n mexeu n vei";
    float timeCounter;
    public Menu(int state){
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
         pressStart = new Image("res/press.png");
         fAsteroid = new Image("res/asteroid.png");
         //this.spaceShip.img.setCenterOfRotation(this.spaceShip.x + 25, this.spaceShip.y + 25);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException{
        //grphcs.drawString("shots: " + spaceShip.shots.shots.isEmpty(), 0, 0);
        grphcs.drawImage(pressStart, (1280 - pressStart.getWidth())/2, 600);
        grphcs.drawImage(fAsteroid, (1280 - fAsteroid.getWidth())/2, 300);
        
        //grphcs.drawRect(50, 100, 20 , 60);
        
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        //int x = Mouse.getX();
        //int y = Mouse.getY();
        //mouse = "x :" + x + " y: " + y;
        Input input = gc.getInput();
        
        if(input.isKeyDown(Keyboard.KEY_RETURN)){
            sbg.enterState(1);
        }
    }

    @Override
    public int getID() {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
