package ch.coldpixel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {

//==============================================================================
//Initialization
//==============================================================================
    //DesktopLauncher
    public static final boolean RESZIABLE = false;
    public static final boolean MAX_FPS = false;
    public static final int WINDOW_WIDTH = 1024;
    public static final int WINDOW_HEIGTH = 512 + 128;
    public static final String GAMENAME = "Cold Pixel - Runner";
    public static final String FAVICON = "Graphics/Icon/Icon.png";
    //Camera
    private Camera cam;
    //LevelSize
    public static final int LEVEL_1_WIDTH = WINDOW_WIDTH * 3;
    public static final int LEVEL_1_HEIGTH = WINDOW_HEIGTH;
    public static final int TILESIZE = 16;
    //Player
    private Player player;
    SpriteBatch batch;
    //FPS
    FPSLogger fps;
    //MapDrawing
    MapDrawing mapdrawing;

//==============================================================================
//Methods
//==============================================================================
    @Override
    public void create() {
        //Spritebatch
        batch = new SpriteBatch();
        //FPS
        fps = new FPSLogger();
        //Camera
        cam = new Camera();
        //Player
        player = new Player((WINDOW_WIDTH/2)-32, (WINDOW_HEIGTH/2)-32);
        //MapDrawing
        mapdrawing = new MapDrawing(TILESIZE, TILESIZE);
    }

    @Override
    public void render() {
        cam.camUpdate(batch);
        Gdx.gl.glClearColor(0, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapdrawing.background();
        batch.begin();
        mapdrawing.MapRender(batch);
        batch.draw(player.getCharacter(), player.getXPosition(), player.getYPosition());
        batch.end();
        player.movement();
        mapdrawing.showGrid();
        fps.log();
    }

    @Override
    public void dispose() {
        batch.dispose();
        mapdrawing.shape.dispose();
        player.getCharacter().dispose();
    }
}
