/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import static ch.coldpixel.game.Main.WINDOW_WIDTH;
import static ch.coldpixel.game.Main.LEVEL_1_WIDTH;
import static ch.coldpixel.game.Main.LEVEL_1_HEIGTH;
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
    //int loop array
    int x=0;

//==============================================================================
//Methods
//==============================================================================
    MapModel(int tileWidth, int tileHeight) {
        //Array
        arrTiles = new int[LEVEL_1_WIDTH / tileWidth][LEVEL_1_HEIGTH / tileHeight];
        //0=Background
        for (int i = 0; i < arrTiles.length; i++) {
            for (int j = 0; j < arrTiles[0].length; j++) {
                arrTiles[i][j] = 0;
            }
        }
    }
    
    void setMapModel(String mapString){
        //remove linebreaks from string
        mapString = mapString.replaceAll("[\n\r]", "");
        for (int j = arrTiles[0].length-1; j >= 0; j--) {
            for (int i = arrTiles.length-1; i >= 0; i--) {
                if(mapString.charAt(x)!=' '){
                    //Get Character from File at Position X and change type to numeric(int)
                    arrTiles[i][j] = Character.getNumericValue(mapString.charAt(x));
                }
                x++;
            }
        }
    }
    
    int[][] getArrTiles(){
        return arrTiles;
    }

}
