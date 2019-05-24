/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;

import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

/**
 *
 * @author MVale
 */
public class Asteroids extends StateBasedGame{
    
    public static final String name = "Assteroids";
    public static final int menu = 0;
    public static final int play = 1;
    
    public Asteroids(String name) throws SlickException{
        super(name);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
        
    }
    public static void main(String[] args){
        AppGameContainer appgc;
        
        try{
            appgc = new AppGameContainer(new Asteroids(name));
            appgc.setTargetFrameRate(60);
            appgc.setDisplayMode(1280, 960, false);
            appgc.start();
        }catch(SlickException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(menu).init(gc, this);
        this.getState(play).init(gc, this);
        this.enterState(menu);
    }
    
}
