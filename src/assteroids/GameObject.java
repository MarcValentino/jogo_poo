/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;
import org.newdawn.slick.*;
/**
 *
 * @author MVale
 */
public abstract class GameObject {
    public float x, y;
    Image img;
    float imgscale;
    float direction;
    public double velx, vely;
    
    GameObject(float x, float y, String ref) throws SlickException{
        this.x = x;
        this.y = y;
        this.img = new Image(ref);
    }
    
    public float getX(){
        return this.x;
    }
    
    public float getY(){
        return this.x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void draw(GameObject g){
        
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public float getImgscale() {
        return imgscale;
    }

    public void setImgscale(float imgscale) {
        this.imgscale = imgscale;
    }

    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }

    public double getVelx() {
        return velx;
    }

    public void setVelx(double velx) {
        this.velx = velx;
    }

    public double getVely() {
        return vely;
    }

    public void setVely(double vely) {
        this.vely = vely;
    }
    
}
