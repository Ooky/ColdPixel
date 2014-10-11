/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Mike
 */
public class Player {

//==============================================================================
//Initialization
//==============================================================================
    //Rectangle
    private final Rectangle player;
    //Textures
    private final Texture character;
    //Movemenetspeed
    private final int walkSpeed = 200;
    private float jumpSpeed = 1500;
    private boolean canJump = false;
    private float velocity = 0;
    private final int runSpeed = (int) (walkSpeed * 1.5);
    private final float acceleration = 500;
//==============================================================================
//Methods
//==============================================================================
    //constructor   x=Spawn X Coordinate y=Spawn Y Coordinate

    public Player(float x, float y) {
        player = new Rectangle();
        player.x = x;
        player.y = y;
        player.width = 64;
        player.height = 64;
        character = new Texture(Gdx.files.internal("GameCharacter_idle.png"));
    }

    public void gravity() {
        //TODO GRAVITY
    }

    public void movement() {
        //DDELETE THIS
        if (r()) {
            resetPosition();
        }
        //DELETE THIS ABOVE
        if (!isFalling() && !space()) {
            velocity = 0;
            canJump = true;
        }

        if (leftOrA()) {
            if (isRunning()) {
                runLeft();
            } else {
                walkLeft();
            }
        }
        if (rightOrD()) {
            if (isRunning()) {
                runRight();
            } else {
                walkRight();
            }
        }
        //Jump
        if (space() && canJump) {
            jump();
        } else {
            //phroibit double jump
            if (jumpSpeed > 0 && jumpSpeed < 1500) {
                canJump = false;
            }
            jumpSpeed = 1500;
        }

        // Gravitation
        fall();

    }

//==============================================================================
//Keycode
//==============================================================================
    //Resets Player position, but not speed
    private boolean r() {
        return Gdx.input.isKeyPressed(Keys.R);
    }

    private void resetPosition() {
        this.setYPosition(500);
    }

    //Movement
    private boolean leftOrA() {
        return Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT);
    }

    private boolean isRunning() {
        return Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT);
    }

    private void runLeft() {
        this.setXPosition(this.getXPosition() - runSpeed * Gdx.graphics.getDeltaTime());
    }

    private void walkLeft() {
        this.setXPosition(this.getXPosition() - walkSpeed * Gdx.graphics.getDeltaTime());
    }

    private boolean rightOrD() {
        return Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT);
    }

    //Jump
    private boolean space() {
        return Gdx.input.isKeyPressed(Keys.SPACE);
    }

    private void runRight() {
        this.setXPosition(this.getXPosition() + runSpeed * Gdx.graphics.getDeltaTime());
    }

    private void walkRight() {
        this.setXPosition(this.getXPosition() + walkSpeed * Gdx.graphics.getDeltaTime());
    }

    private void jump() {
        //change 100 to a variable
        jumpSpeed = jumpSpeed - 100;
        if (jumpSpeed <= 0) {
            canJump = false;
        }
        this.setYPosition(this.getYPosition() + jumpSpeed * Gdx.graphics.getDeltaTime());
    }

    private void fall() {
        //fall is activ if isfalling returns true and (the players doens't click space or can't jump anymore
        if (isFalling() && (!space() || !canJump)) {
            velocity = velocity + acceleration * Gdx.graphics.getDeltaTime();
            this.setYPosition(this.getYPosition() - velocity * Gdx.graphics.getDeltaTime());
        }
    }

//==============================================================================
//Getter
//==============================================================================
    public float getXPosition() {
        return player.x;
    }

    public float getYPosition() {
        return player.y;
    }

    public Texture getCharacter() {
        return character;
    }

//==============================================================================
//Setter
//==============================================================================
    public void setXPosition(float x) {
        player.x = x;
    }

    public void setYPosition(float y) {
        player.y = y;
    }

//==============================================================================
//State
//==============================================================================
    public boolean isFalling() {
        return this.getYPosition() > 64;
    }
}
