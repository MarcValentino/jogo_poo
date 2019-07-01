/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;



/**
 *
 * @author MVale
 */
public class Play extends BasicGameState {

    Ship spaceShip;
    AsteroidGenerator asteroidGenerator;
    static float pont = 0;

        
    public Play(int state){
        
    }
    
    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException{
        init(container, game);
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        this.spaceShip = new Ship(Asteroids.windowSizeX/2, Asteroids.windowSizeY/2);        
        this.asteroidGenerator = new AsteroidGenerator();
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs){
        spaceShip.drawObject(grphcs);
        asteroidGenerator.showAsteroids(grphcs);
        spaceShip.showShots(grphcs);
        grphcs.drawString("Pontuação: " + pont, Asteroids.windowSizeX - 200, 20);
        
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        float dt = delta/1000f;
        pont += dt;
        this.spaceShip.behave(gc, delta); // Lógica de movimento da nave
        this.asteroidGenerator.behaveAsts(delta, this.spaceShip);
        collision(sbg);
        
    }
    
    public void collision(StateBasedGame sbg) throws SlickException{
        ArrayList<Asteroid> currentAsteroids = this.asteroidGenerator.getAsteroids();
        Iterator<Asteroid> iterAsts = currentAsteroids.iterator();
        Asteroid temp = null;
    
        
        while(iterAsts.hasNext()){
            Asteroid ast = iterAsts.next();
            if(ast.moldura.intersects(spaceShip.moldura)){
                sbg.enterState(0);
            }
            ArrayList<Shot> playerShots = spaceShip.getShots();
            Iterator<Shot> iterShots = playerShots.iterator();
            while(iterShots.hasNext()){
                Shot s = iterShots.next();
                if(s.moldura.intersects(ast.moldura)){
                    pont += 10;
                    iterShots.remove();
                    temp = ast;
                    iterAsts.remove();
                  
                    break;
                }
            }
            spaceShip.setShots(playerShots);
        }
        
        this.asteroidGenerator.setAsteroids(currentAsteroids);
        
        
        
        if(temp!=null && temp.getHp() > 1){
            
            System.out.println("entrou em temp != null");
            this.asteroidGenerator.spawn(temp);
        }
        
        
        
    }
    

    @Override
    public int getID() {
        return 1; //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

