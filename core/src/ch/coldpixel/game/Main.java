package ch.coldpixel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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
    //Shaperenderer
    ShapeRenderer shape;
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
        //Shaperenderer
        shape = new ShapeRenderer();
        //Player
        player = new Player(500, 500);
        //MapDrawing
        mapdrawing = new MapDrawing(TILESIZE, TILESIZE);
    }

    @Override
    public void render() {
        cam.camUpdate(batch);
        Gdx.gl.glClearColor(0, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background();
        batch.begin();
        mapdrawing.MapRender(batch);
        batch.draw(player.getCharacter(), player.getXPosition(), player.getYPosition());
        batch.end();
        player.movement();
        showGrid();
        fps.log();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
        player.getCharacter().dispose();
    }

    private void showGrid() {
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

    private void background() {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect(0, 0, LEVEL_1_WIDTH, LEVEL_1_HEIGTH, Color.BLUE, Color.BLUE, Color.ORANGE, Color.ORANGE);
        shape.setColor(Color.YELLOW);
        shape.circle(100, WINDOW_HEIGTH - 100, 50, 5);
        shape.end();
    }
}
