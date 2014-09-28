/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Mike
 */
public class Player {
    private Rectangle player;
    public Player(float x, float y) {
        player = new Rectangle();
        player.x = x;
        player.y = y;
        player.width = 32;
        player.height = 64;
    }
    
    public float getXPosition(){
        return player.x;
    }
    
    public float getyPosition(){
        return player.y;
    }
    
    public void setXPosition(float x){
        player.x =x;
    }
    
    public void setPosition(float y){
         player.y = y;
    }
    
    public void moveLeft(){
        player.x -= 200 * Gdx.graphics.getDeltaTime();
    }
    
    public void moveRight(){
        player.x += 200 * Gdx.graphics.getDeltaTime();
    }
}
