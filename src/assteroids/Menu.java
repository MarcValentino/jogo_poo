/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

/**
 *
 * @author MVale
 */


public class Menu extends BasicGameState{
    
    Image pressStart;
    File file = new File("leaderBoard.txt");
    
    public Menu(int state){
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
         pressStart = new Image("res/press.png");
         //this.spaceShip.img.setCenterOfRotation(this.spaceShip.x + 25, this.spaceShip.y + 25);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException{
        //grphcs.drawString("shots: " + spaceShip.shots.shots.isEmpty(), 0, 0);
        if(Play.pont > 0){
            grphcs.drawString("Sua pontuação foi: " + Play.pont, 300, 20);
            try {
                PrintWriter output = new PrintWriter(file);
                output.println("Jogador 1: " + Play.pont);
                output.close();
            }
            catch (IOException ex){
                System.out.println("ERRO: " + ex);
            }

        }
        
        grphcs.drawImage(pressStart, (1280 - pressStart.getWidth())/2, 600);
        
        
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
       
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
