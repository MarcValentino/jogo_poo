/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;

import org.newdawn.slick.SlickException;

/**
 *
 * @author dlcaio
 */
public class Asteroid extends GameObject{
    
    public Asteroid(int x, int y, String ref) throws SlickException {
        super(x, y, ref);
        
        imgscale = 0.1f;
        
        this.img.setCenterOfRotation((this.img.getWidth()/2)*this.imgscale, (this.img.getWidth()/2)*this.imgscale);
        this.velx = 0; this.vely = 0;
        this.direction = 90;
    }
    
    public void spin(float deg) {
        this.direction += deg;
    }
    
}
