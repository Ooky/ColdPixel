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
    private MapDrawing mapdrawing;
    //Load Level
    Load mapString;
    private MapModel mapmodel;

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
        player = new Player(0,320);
        //Load Level
        mapString = new Load();
        //Mapmodel
        mapmodel = new MapModel(TILESIZE, TILESIZE);
        mapmodel.setMapModel(mapString.getLevel(1));
        //MapDrawing
        mapdrawing = new MapDrawing(TILESIZE, TILESIZE,mapmodel);
    }

    @Override
    public void render() {
        cam.camUpdate(batch);
        Gdx.gl.glClearColor(0, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapdrawing.background();
        batch.begin();
        mapdrawing.MapRender(batch);
        //Animation
        player.setStateTime(player.getStateTime() + Gdx.graphics.getDeltaTime());
        player.setCurrentFrame(player.getAnimation().getKeyFrame(player.getStateTime(), true));
        player.getSpriteBatch().begin();
        player.getSpriteBatch().draw(player.getCurrentFrame(),  player.getXPosition(), player.getYPosition());
        player.getSpriteBatch().end();
        batch.end();
        
        player.movement(mapmodel.getArrCollision());
        
        
        mapdrawing.showGrid();
        fps.log();
    }

    @Override
    public void dispose() {
        batch.dispose();
        mapdrawing.shape.dispose();
      //  player.getCharacter().dispose();
    }
}
