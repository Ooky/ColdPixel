package ch.coldpixel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
    private static OrthographicCamera camera;
    //LevelSize
    public static final int LEVEL_1_WIDTH = WINDOW_WIDTH * 3;
    public static final int LEVEL_1_HEIGTH = WINDOW_HEIGTH;
    private final int TILESIZE = 32;
    //Player
    private Player player;
    //Textures
    private static Texture ground;
    SpriteBatch batch;
    //FPS
    FPSLogger fps;
    //Array
    int kachelarr[][];
    //Shaperenderer
    ShapeRenderer shape;

//==============================================================================
//Methods
//==============================================================================
    @Override
    public void create() {
        //Spritebatch
        batch = new SpriteBatch();
        //Textures
        ground = new Texture(Gdx.files.internal("ground.png"));
        //FPS
        fps = new FPSLogger();
        //Camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WINDOW_WIDTH, WINDOW_HEIGTH);
        //Array
        kachelarr = new int[WINDOW_WIDTH / TILESIZE][WINDOW_WIDTH / TILESIZE];
        //Shaperenderer
        shape = new ShapeRenderer();
        //player
        player = new Player(32, 32);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background();
        batch.begin();
        batch.draw(player.getCharacter(), player.getXPosition(), player.getYPosition());
        player.movement();
        for (int i = 0; i < 32; i++) {
            batch.draw(ground, i * TILESIZE, 0);
        }
        batch.end();
        showGrid();
        fps.log();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
        ground.dispose();
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
        shape.rect(0, 0, LEVEL_1_WIDTH, LEVEL_1_HEIGTH, Color.ORANGE, Color.ORANGE, Color.BLUE, Color.BLUE);
        shape.setColor(Color.YELLOW);
        shape.circle(100, WINDOW_HEIGTH - 100, 50, 30);
        shape.end();
    }
}
