/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

/**
 *
 * @author Ooky
 */
public class FPSLogger {
    
//==============================================================================
//Initialization
//==============================================================================
    long startTime;
    long test = System.nanoTime();
    
//==============================================================================
//Methods
//==============================================================================
    public FPSLogger() {
        startTime = TimeUtils.nanoTime();
    }
    /**
     * Logs the current frames per second to the console.
     */
    public void log() {
        if (TimeUtils.nanoTime() - startTime > 1000000000) /* 1,000,000,000ns == one second */ {
            Gdx.app.log("FPSLogger", "fps: " + Gdx.graphics.getFramesPerSecond());
            startTime = TimeUtils.nanoTime();
        }
    }
}
