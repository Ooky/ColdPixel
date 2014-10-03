/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.coldpixel.game;

import static ch.coldpixel.game.Main.LEVEL_1_HEIGTH;
import static ch.coldpixel.game.Main.LEVEL_1_WIDTH;
import static ch.coldpixel.game.Main.TILESIZE;
import static ch.coldpixel.game.Main.WINDOW_HEIGTH;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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
    //Shaperenderer
    ShapeRenderer shape;
    //Camera
    Camera cam;

//==============================================================================
//Methods
//==============================================================================
    public MapDrawing(int tileWidth, int tileHeight) {
        //Mapmodel
        mapmodel = new MapModel(tileWidth, tileHeight);
        //Textures
        ground = new Texture(Gdx.files.internal("ground.png"));
        //ShapeRenderer
        shape = new ShapeRenderer();
        //Camera
        cam = new Camera();
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

    public void background() {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect(0, 0, LEVEL_1_WIDTH, LEVEL_1_HEIGTH, Color.BLUE, Color.BLUE, Color.ORANGE, Color.ORANGE);
        shape.setColor(Color.YELLOW);
        shape.circle(100, WINDOW_HEIGTH - 100, 50, 5);
        shape.end();
    }

    public void showGrid() {
        //Show Grid if G is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.setColor(Color.RED);
            for (int i = 0; i <= LEVEL_1_WIDTH; i += TILESIZE) {
                for (int j = 0; j <= LEVEL_1_HEIGTH; j += TILESIZE) {
                    shape.rect(0, 0, i, j);
                }
            }
        }
        shape.setColor(Color.CLEAR);
        shape.end();
    }

}
