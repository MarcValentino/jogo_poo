/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import java.util.ArrayList;
import org.newdawn.slick.*;
import java.lang.Math;
/**
 *
 * @author MVale
 */
class Shot extends GameObject{
    
    Shot(int x, int y, String ref, float direction) throws SlickException{
        super(x, y, ref);
        this.velx = -1 * Math.cos(Math.toRadians(direction));
        this.vely = -1 * Math.sin(Math.toRadians(direction));
        this.direction = direction;
    }
}

class ShotArray{
    ArrayList<Shot> shots;
    
    ShotArray(){
        this.shots = new ArrayList<>();
    }
    
    void add(int x, int y, float direction) throws SlickException{
        Shot newShot = new Shot(x + 15, y + 5, "res/shot.png", direction);
        //newShot.img.setCenterOfRotation(28, 28);
        newShot.img.setRotation(direction - 90);
        shots.add(newShot);
    }
    
    void remove(int index){
        shots.remove(index);
    }
    
    void moveShots(int delta){
        for(Shot shot : this.shots){
            shot.x += shot.velx * delta;
            shot.y += shot.vely * delta;
        }
    }
    
    void showShots(){
        for(Shot shot : this.shots){
            shot.img.setCenterOfRotation(10, 10);
            shot.img.draw(shot.x, shot.y);
        }
    }

}
