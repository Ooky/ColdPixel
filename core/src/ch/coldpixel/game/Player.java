/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Mike
 */
public class Player {
    //Rectangle
    private Rectangle player;
    //constructor   x=Spawn X Coordinate y=Spawn Y Coordinate
    public Player(float x, float y) {
        player = new Rectangle();
        player.x = x;
        player.y = y;
        player.width = 32;
        player.height = 64;
    }
    //Getter
    public float getXPosition(){
        return player.x;
    }
    
    public float getYPosition(){
        return player.y;
    }
    //Setter
    public void setXPosition(float x){
        player.x =x;
    }
    
    public void setYPosition(float y){
         player.y = y;
    }
    
    //Movement
    public void movement(){
        if(Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)){
            this.setXPosition(this.getXPosition()-200 * Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)){
            this.setXPosition(this.getXPosition()+200 * Gdx.graphics.getDeltaTime());
        }
    }
}
