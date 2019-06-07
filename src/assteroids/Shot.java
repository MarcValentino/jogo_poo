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
    
    Shot(float x, float y, String ref, float direction) throws SlickException{
        super(x, y, ref);d
        this.velx = -1 * Math.cos(Math.toRadians(direction));
        this.vely = -1 * Math.sin(Math.toRadians(direction));
        this.direction = direction;
    }
}
