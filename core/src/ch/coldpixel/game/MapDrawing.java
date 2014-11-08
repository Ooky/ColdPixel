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
import static ch.coldpixel.game.Main.TILESIZE;

/**
 *
 * @author Ooky
 */
public class MapDrawing {

//==============================================================================
//Initialization
//==============================================================================
    //Textures
    private static Texture ground,groundTop;
        //House1
        private static Texture house1Door1LeftBottom,house1Door1LeftMid,house1Door1LeftTop,
                house1Door1RightBottom,house1Door1RightMid,house1Door1RightTop,house1Left1,
                house1Left2,house1Left3,house1Left4,house1LeftTop,house1Right1,house1Right2,
                house1Right3,house1Right4,house1RightTop,house1SmokeStack,house1Top1,house1Top2,
                house1Wall1,house1Wall2,house1Wall3,house1Window2LeftBottom,house1Window2LeftTop,
                house1Window2RightBottom,house1Window2RightTop,house1WindowLeftBottom,
                house1WindowLeftTop,house1WindowRightBottom,house1WindowRightTop;
    //MapModel
    private MapModel mapmodel;
    //Array
    private int[][] arrTiles;
    ShapeRenderer shape;

//==============================================================================
//Methods
//==============================================================================
    public MapDrawing(int tileWidth, int tileHeight, MapModel mapmodel) {
        //Mapmodel
        this.mapmodel=mapmodel;
        //Textures
        ground = new Texture(Gdx.files.internal("ground.png"));
        groundTop = new Texture(Gdx.files.internal("groundTop.png"));
        //House
        house1Door1LeftBottom = new Texture(Gdx.files.internal("House1/house1Door1LeftBottom.png"));
        house1Door1LeftMid = new Texture(Gdx.files.internal("House1/house1Door1LeftMid.png"));
        house1Door1LeftTop = new Texture(Gdx.files.internal("House1/house1Door1LeftTop.png"));
        house1Door1RightBottom = new Texture(Gdx.files.internal("House1/house1Door1RightBottom.png"));
        house1Door1RightMid = new Texture(Gdx.files.internal("House1/house1Door1RightMid.png"));
        house1Door1RightTop = new Texture(Gdx.files.internal("House1/house1Door1RightTop.png"));
        house1Left1 = new Texture(Gdx.files.internal("House1/house1Left1.png"));
        house1Left2 = new Texture(Gdx.files.internal("House1/house1Left2.png"));
        house1Left3 = new Texture(Gdx.files.internal("House1/house1Left3.png"));
        house1Left4 = new Texture(Gdx.files.internal("House1/house1Left4.png"));
        house1LeftTop = new Texture(Gdx.files.internal("House1/house1LeftTop.png"));
        house1Right1 = new Texture(Gdx.files.internal("House1/house1Right1.png"));
        house1Right2 = new Texture(Gdx.files.internal("House1/house1Right2.png"));
        house1Right3 = new Texture(Gdx.files.internal("House1/house1Right3.png"));
        house1Right4 = new Texture(Gdx.files.internal("House1/house1Right4.png"));
        house1RightTop = new Texture(Gdx.files.internal("House1/house1RightTop.png"));
        house1SmokeStack = new Texture(Gdx.files.internal("House1/house1SmokeStack.png"));
        house1Top1 = new Texture(Gdx.files.internal("House1/house1Top1.png"));
        house1Top2 = new Texture(Gdx.files.internal("House1/house1Top2.png"));
        house1Wall1 = new Texture(Gdx.files.internal("House1/house1Wall1.png"));
        house1Wall2 = new Texture(Gdx.files.internal("House1/house1Wall2.png"));
        house1Wall3 = new Texture(Gdx.files.internal("House1/house1Wall3.png"));
        house1Window2LeftBottom = new Texture(Gdx.files.internal("House1/house1Window2LeftBottom.png"));
        house1Window2LeftTop = new Texture(Gdx.files.internal("House1/house1Window2LeftTop.png"));
        house1Window2RightBottom = new Texture(Gdx.files.internal("House1/house1Window2RightBottom.png"));
        house1Window2RightTop = new Texture(Gdx.files.internal("House1/house1Window2RightTop.png"));
        house1WindowLeftBottom = new Texture(Gdx.files.internal("House1/house1WindowLeftBottom.png"));
        house1WindowLeftTop = new Texture(Gdx.files.internal("House1/house1WindowLeftTop.png"));
        house1WindowRightBottom = new Texture(Gdx.files.internal("House1/house1WindowRightBottom.png"));
        house1WindowRightTop = new Texture(Gdx.files.internal("House1/house1WindowRightTop.png"));
        //ShapeRenderer
        shape = new ShapeRenderer();
    }

    public void MapRender(SpriteBatch batch) {
        arrTiles = mapmodel.getArrTiles();
        for (int i = 0; i < arrTiles.length; i++) {
            for (int j = 0; j < arrTiles[0].length; j++) {
                switch (arrTiles[i][j]) {
                    case 0://Nothing
                        break;
                    case 1://Ground
                        batch.draw(ground, i * TILESIZE, j * TILESIZE);
                        break;
                    case 2://GroundTop
                        batch.draw(groundTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //HOUSE1
                    //Door Left Bottom
                    case 3:
                        batch.draw(house1Door1LeftBottom, i * TILESIZE, j * TILESIZE);
                        break;
                    //Door Left Mid
                    case 4:
                        batch.draw(house1Door1LeftMid, i * TILESIZE, j * TILESIZE);
                        break;
                    //Door Left Top
                    case 5:
                        batch.draw(house1Door1LeftTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //Door Right Bottom
                    case 6:
                        batch.draw(house1Door1RightBottom, i * TILESIZE, j * TILESIZE);
                        break;
                    //Door Right Mid
                    case 7:
                        batch.draw(house1Door1RightMid, i * TILESIZE, j * TILESIZE);
                        break;
                    //Door Right Top
                    case 8:
                        batch.draw(house1Door1RightTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //LEFT 1
                    case 9:
                        batch.draw(house1Left1, i * TILESIZE, j * TILESIZE);
                        break;
                    // LEFT 2
                    case 10:
                        batch.draw(house1Left2, i * TILESIZE, j * TILESIZE);
                        break;
                    // Left 3
                    case 11:
                        batch.draw(house1Left3, i * TILESIZE, j * TILESIZE);
                        break;
                    //Left 4
                    case 12:
                        batch.draw(house1Left4, i * TILESIZE, j * TILESIZE);
                        break;
                    //LeftTop
                    case 13:
                        batch.draw(house1LeftTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //Right 1
                    case 14:
                        batch.draw(house1Right1, i * TILESIZE, j * TILESIZE);
                        break;
                    //Right 2
                    case 15:
                        batch.draw(house1Right2, i * TILESIZE, j * TILESIZE);
                        break;
                    //Right 3
                    case 16:
                        batch.draw(house1Right3, i * TILESIZE, j * TILESIZE);
                        break;
                    //Right 4
                    case 17:
                        batch.draw(house1Right4, i * TILESIZE, j * TILESIZE);
                        break;
                    //Right Top
                    case 18:
                        batch.draw(house1RightTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //Smoke Stack
                    case 19:
                        batch.draw(house1SmokeStack, i * TILESIZE, j * TILESIZE);
                        break;
                    //Top1
                    case 20:
                        batch.draw(house1Top1, i * TILESIZE, j * TILESIZE);
                        break;
                    //Top2
                    case 21:
                        batch.draw(house1Top2, i * TILESIZE, j * TILESIZE);
                        break;
                    //Wall1
                    case 22:
                        batch.draw(house1Wall1, i * TILESIZE, j * TILESIZE);
                        break;
                    //Wall2
                    case 23:
                        batch.draw(house1Wall2, i * TILESIZE, j * TILESIZE);
                        break;
                    //Wall3
                    case 24:
                        batch.draw(house1Wall3, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window2 Left Bottom
                    case 25:
                        batch.draw(house1Window2LeftBottom, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window2 Left Top
                    case 26:
                        batch.draw(house1Window2LeftTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window2 Right Bottom
                    case 27:
                        batch.draw(house1Window2RightBottom, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window2 Right Top
                    case 28:
                        batch.draw(house1Window2RightTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window1 Left Bottom
                    case 29:
                        batch.draw(house1WindowLeftBottom, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window1 Left Top
                    case 30:
                        batch.draw(house1WindowLeftTop, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window1 Right Bottom
                    case 31:
                        batch.draw(house1WindowRightBottom, i * TILESIZE, j * TILESIZE);
                        break;
                    //Window1 Right Top
                    case 32:
                        batch.draw(house1WindowRightTop, i * TILESIZE, j * TILESIZE);
                        break;
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
