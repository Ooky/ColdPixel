package ch.coldpixel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
    public static final int WINDOW_HEIGTH = 512+128;
    public static final String GAMENAME = "Cold Pixel - Runner";
    public static final String FAVICON = "Graphics/Icon/Icon.png";
    private final int TILESIZE = 16;
    //Textures
    SpriteBatch batch;
    Texture img;
    Texture test;
    //FPS
    FPSLogger fps;
    //Array
    int kachelarr[][];
    
//==============================================================================
//Methods
//==============================================================================
    @Override
    public void create() {
        //Spritebatch
        batch = new SpriteBatch();
        //Textures
        img = new Texture("badlogic.jpg");
        test = new Texture("Unbenannt.png");
        //FPS
        fps = new FPSLogger();
        //Array
        kachelarr = new int[WINDOW_WIDTH/TILESIZE][WINDOW_WIDTH/TILESIZE];
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(int i = 0; i< WINDOW_WIDTH; i+=TILESIZE) {
            for(int j = 0; j < WINDOW_HEIGTH; j+=TILESIZE) {
                batch.draw(test, i, j);
            }
        }
        batch.draw(img, 0, 0);
        batch.end();
        fps.log();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
