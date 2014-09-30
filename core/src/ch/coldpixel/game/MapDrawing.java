/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Ooky
 */
public class MapDrawing {

//==============================================================================
//Initialization
//==============================================================================
    //MapModel
    MapModel mapmodel;
    //Textures
    private static Texture ground;

//==============================================================================
//Methods
//==============================================================================
    public MapDrawing(int tileWidth, int tileHeight) {
        //Mapmodel
        mapmodel = new MapModel(tileWidth, tileHeight);
        //Textures
        this.ground = new Texture(Gdx.files.internal("ground.png"));
    }

    public void MapRender(SpriteBatch batch) {
        for (int i = 0; i < mapmodel.arrTiles.length; i++) {
            for (int j = 0; j < mapmodel.arrTiles[0].length; j++) {
                switch (mapmodel.arrTiles[i][j]) {
                    case 0://Nothing
                        break;
                    case 1://Ground
                        batch.draw(ground, i * 32, j * 32);
                }

            }
        }
    }

}
