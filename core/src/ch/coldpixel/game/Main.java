package ch.coldpixel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends ApplicationAdapter {

//==============================================================================
//Initialization
//==============================================================================
    //Config
    public static final int WINDOW_WIDTH = 1024;
    public static final int WINDOW_HEIGTH = 512 + 128;
    public static final int LEVEL_1_WIDTH = WINDOW_WIDTH*3;
    public static final int LEVEL_1_HEIGTH = WINDOW_HEIGTH;
    public static final String GAMENAME = "Cold Pixel - Runner";
    public static final String FAVICON = "Graphics/Icon/Icon.png";
    private final int TILESIZE = 32;
    //Textures
    SpriteBatch batch;
    Texture img;
    //FPS
    FPSLogger fps;
    //Array
    int kachelarr[][];
    //Shaperenderer
    ShapeRenderer grid;

//==============================================================================
//Methods
//==============================================================================
    @Override
    public void create() {
        //Spritebatch
        batch = new SpriteBatch();
        //Textures
        img = new Texture("badlogic.jpg");
        //FPS
        fps = new FPSLogger();
        //Array
        kachelarr = new int[WINDOW_WIDTH / TILESIZE][WINDOW_WIDTH / TILESIZE];
        //Shaperenderer
        grid = new ShapeRenderer();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        showGrid();
        fps.log();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        grid.dispose();
    }

    private void showGrid() {
        //Show Grid if G is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            grid.begin(ShapeRenderer.ShapeType.Line);
            grid.setColor(Color.RED);
            for (int i = 0; i <= LEVEL_1_WIDTH; i += TILESIZE) {
                for (int j = 0; j <= LEVEL_1_HEIGTH; j += TILESIZE) {
                    grid.rect(0, 0, i, j);
                }
            }
        }
        grid.setColor(Color.CLEAR);
        grid.end();
    }
}
