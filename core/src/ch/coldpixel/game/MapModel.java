/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import static ch.coldpixel.game.Main.WINDOW_WIDTH;
import static ch.coldpixel.game.Main.LEVEL_1_WIDTH;
import static ch.coldpixel.game.Main.LEVEL_1_HEIGTH;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ooky
 */
public class MapModel {

//==============================================================================
//Initialization
//==============================================================================
    //Array
    final int[][] arrTiles;
    private List<Rectangle> arrCollision,arrKillCollision;
    private List<String> mapArray;
    private Rectangle tmp;
    //int loop array
    int x = 0;

//==============================================================================
//Methods
//==============================================================================
    MapModel(int tileWidth, int tileHeight) {
        //Array
        arrTiles = new int[LEVEL_1_WIDTH / tileWidth][LEVEL_1_HEIGTH / tileHeight];
        arrCollision = new ArrayList<Rectangle>();
        arrKillCollision = new ArrayList<Rectangle>();
        
        //0=Background
        for (int i = 0; i < arrTiles.length; i++) {
            for (int j = 0; j < arrTiles[0].length; j++) {
                arrTiles[i][j] = 0;
            }
        }
    }

    void setMapModel(String mapString) {
        //remove linebreaks from string
        mapString = mapString.replaceAll("[\n\r]", "");
        mapArray= Arrays.asList(mapString.split(";"));
        for (int j = arrTiles[0].length - 1; j >= 0; j--) {
            for (int i = arrTiles.length - 1; i >= 0; i--) {
                if (mapArray.get(x) != " ") {
                    //Get Character from File at Position X and change type to numeric(int)
                    arrTiles[i][j] = Integer.parseInt(mapArray.get(x));
                    //18;21;21;28;26;21;20;13
                    if (mapArray.get(x).equals("2") 
                            || mapArray.get(x).equals("18")
                            || mapArray.get(x).equals("21")
                            || mapArray.get(x).equals("28")
                            || mapArray.get(x).equals("26")
                            || mapArray.get(x).equals("20")
                            || mapArray.get(x).equals("13")) {
                        tmp = new Rectangle();
                        tmp.x = i*16;
                        tmp.y = j*16;
                        tmp.width = 16;
                        tmp.height = 16;
                        arrCollision.add(tmp);
                    }
                    if (mapArray.get(x).equals("33")){
                            tmp = new Rectangle();
                            tmp.x = i*16;
                            tmp.y = j*16;
                            tmp.width = 16;
                            tmp.height = 16;
                            arrKillCollision.add(tmp);
                    }
                }
                x++;
            }
        }
    }
    List<Rectangle> getArrCollision() {
        return arrCollision;
    }
    List<Rectangle> getArrKillCollision() {
        return arrKillCollision;
    }
    int[][] getArrTiles() {
        return arrTiles;
    }

}
