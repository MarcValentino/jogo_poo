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
    
    Ship spaceShip;
    String mouse = "n mexeu n vei";
    float timeCounter;
    public Menu(int state){
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
         this.spaceShip = new Ship(320, 180, "res/ship.png");
         timeCounter = 0;
         //this.spaceShip.img.setCenterOfRotation(this.spaceShip.x + 25, this.spaceShip.y + 25);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException{
        grphcs.drawString("shots: " + spaceShip.shots.shots.isEmpty(), 0, 0);
        //grphcs.drawRect(50, 100, 20 , 60);
        spaceShip.img.draw(spaceShip.x, spaceShip.y, 50, 50);
        spaceShip.shots.showShots();
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        //int x = Mouse.getX();
        //int y = Mouse.getY();
        //mouse = "x :" + x + " y: " + y;
        Input input = gc.getInput();
        
        if(input.isKeyDown(Keyboard.KEY_W)){
            spaceShip.accelerate(-0.01);
        }
        if(input.isKeyDown(Keyboard.KEY_S)){
            spaceShip.accelerate(0.01);
        }
        
        if(input.isKeyDown(Keyboard.KEY_A)){
            spaceShip.turn(-0.12f * delta);
            spaceShip.img.rotate(-0.12f * delta);
        }
        
        if(input.isKeyDown(Keyboard.KEY_D)){
            spaceShip.turn(0.12f * delta);
            spaceShip.img.rotate(0.12f * delta);
        }
        
        if(input.isKeyDown(Keyboard.KEY_F) && timeCounter >= 5 *delta){
            timeCounter = 0;
            spaceShip.shoot();
        }
        
        timeCounter += delta;
        spaceShip.shots.moveShots(delta);
        spaceShip.y += delta * spaceShip.vely;
        spaceShip.x += delta * spaceShip.velx;
        
        
        
    }

    @Override
    public int getID() {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
