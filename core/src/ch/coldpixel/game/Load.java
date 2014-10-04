/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 *
 * @author Mike
 */
public class Load {
    boolean isLocAvailable = Gdx.files.isLocalStorageAvailable();
    FileHandle file;
    String text;

    
    public String getLevel(int level){
        switch(level){
            case 1:
                file = Gdx.files.internal("level/level1.txt"); 
                text = file.readString();
                return text;
            default:
                return "false";
        }
    }
}
