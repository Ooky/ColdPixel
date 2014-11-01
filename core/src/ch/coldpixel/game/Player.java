/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import static ch.coldpixel.game.Main.LEVEL_1_HEIGTH;
import static ch.coldpixel.game.Main.LEVEL_1_WIDTH;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Intersector;
import java.util.List;

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
    private final Rectangle r2;
    final List<Rectangle> arrCollision;
    //Movemenetspeed
    private final int walkSpeed = 200;
    private float jumpSpeed = 1000;
    private boolean canJump = false;
    private float velocity = 0;
    private final int runSpeed = (int) (walkSpeed * 1.5);
    private final float acceleration = 1000;
    private final int gravity = 150;
    //Animation
    //0=standing,1=falling,2=walk-left,3=walk-right,4=run-left
    //5=run-right,6=jump,7=attack
    private int status;
    private int oldstatus;
    private static int FRAME_COLS = 3;
    private static int FRAME_ROWS = 3;
    private Animation animation;
    private Texture sheet;
    private TextureRegion[] animFrames;
    private SpriteBatch spriteBatch;
    private TextureRegion currentFrame;
    private final float animationSpeed = 0.2f;
    float stateTime;

//==============================================================================
//Methods
//==============================================================================
    public Player(float x, float y,List<Rectangle> arrCollision) {
        player = new Rectangle();
       // this.arrCollision = new Rectangle[LEVEL_1_WIDTH / 16][LEVEL_1_HEIGTH / 16];
        this.arrCollision = arrCollision;
        r2 = new Rectangle();

        r2.x = x;
        r2.y = y;
        r2.width = 64;
        r2.height = 64;
        player.x = x;
        player.y = y;
        player.width = 64;
        player.height = 64;
        status = 1;
        oldstatus = 0;
        sheet = new Texture(Gdx.files.internal("Standing.png"));
        TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / FRAME_COLS, sheet.getHeight() / FRAME_ROWS);              // #10
        animFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                animFrames[index++] = tmp[i][j];
            }
        }
        animation = new Animation(animationSpeed, animFrames);
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    public void movement() {
        statusChanged();
        status = 0;        

        if (isColliding() && !space()) {
            velocity = 0;
            canJump = true;
        }
        if (leftOrA()) {
            if (isRunning()) {
                status = 4;
                runLeft();
            } else {
                status = 2;
                walkLeft();
            }
        }
        if (rightOrD()) {
            if (isRunning()) {
                status = 5;
                runRight();
            } else {
                status = 3;
                walkRight();
            }
        }
        //Jump
        if (space() && canJump) {
            status = 6;
            jump();
        } else {
            //prevent double jump
            if (jumpSpeed > 0 && jumpSpeed < 1500) {
                canJump = false;
            }
            jumpSpeed = 1500;
        }

        // Gravitation
        fall();

    }

    //0=standing,1=falling,2=walk-left,3=walk-right,4=run-left
    //5=run-right,6=jump,7=attack
    private void statusChanged() {
        //check if status has changed
        if (oldstatus != status) {
            //Set The Png 
            switch (status) {
                //standing
                case 0:
                    FRAME_COLS = 3;
                    FRAME_ROWS = 3;
                    sheet = new Texture(Gdx.files.internal("Standing.png"));
                    break;
                //falling
                case 1:
                    break;
                //walk-left
                case 2:
                    FRAME_COLS = 2;
                    FRAME_ROWS = 2;
                    sheet = new Texture(Gdx.files.internal("WalkLeft.png"));
                    break;
                //walk-right
                case 3:
                    FRAME_COLS = 3;
                    FRAME_ROWS = 2;
                    sheet = new Texture(Gdx.files.internal("Test.png"));
                    break;
                //run-left
                case 4:
                    break;
                //run-right
                case 5:
                    break;
                //jump
                case 6:
                    break;
            }
            TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / FRAME_COLS, sheet.getHeight() / FRAME_ROWS);              // #10
            animFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
            int index = 0;
            for (int i = 0; i < FRAME_ROWS; i++) {
                for (int j = 0; j < FRAME_COLS; j++) {
                    animFrames[index++] = tmp[i][j];
                }
            }
            animation = new Animation(animationSpeed, animFrames);
            spriteBatch = new SpriteBatch();
            stateTime = 0f;
            oldstatus = status;
        }
    }

//==============================================================================
//Keycode
//==============================================================================
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
        jumpSpeed = jumpSpeed - gravity;
        if (jumpSpeed <= 0) {
            canJump = false;
        }
        jumpSpeed = jumpSpeed + acceleration * Gdx.graphics.getDeltaTime();
        this.setYPosition(this.getYPosition() + jumpSpeed * Gdx.graphics.getDeltaTime());
    }

    private void fall() {
        //fall is activ if isfalling returns true and (the players doens't click space or can't jump anymore
        if (!isColliding() && (!space() || !canJump)) {
            velocity = velocity + acceleration * Gdx.graphics.getDeltaTime();
            status = 1;
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

    public float getStateTime() {
        return stateTime;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public Animation getAnimation() {
        return animation;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public int getStatus() {
        return status;
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

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public void setCurrentFrame(TextureRegion currentFrame) {
        this.currentFrame = currentFrame;
    }
//==============================================================================
//State
//==============================================================================

    public boolean isColliding() {
        for(Rectangle rectangle: arrCollision){
                if (Intersector.overlaps(player, rectangle)) {
                    return true; 
                }
        }
        return false; 
    }
}
