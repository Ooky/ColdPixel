/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import static ch.coldpixel.game.Main.WINDOW_WIDTH;

/**
 *
 * @author Ooky
 */
public class MapModel {

//==============================================================================
//Initialization
//==============================================================================
    //Array
    int[][] arrTiles;

//==============================================================================
//Methods
//==============================================================================
    MapModel(int tileWidth, int tileHeight) {
        //Array
        arrTiles = new int[WINDOW_WIDTH / tileWidth][WINDOW_WIDTH / tileHeight];
        //0=Background
        for (int i = 0; i < arrTiles.length; i++) {
            for (int j = 0; j < arrTiles[0].length; j++) {
                arrTiles[i][j] = 0;
            }
        }
        //1=Ground
        for (int i = 0; i < arrTiles.length; i++) {
            arrTiles[i][0] = 1;
        }
    }

}
