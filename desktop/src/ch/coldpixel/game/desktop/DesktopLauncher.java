package ch.coldpixel.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ch.coldpixel.game.Main;
import com.badlogic.gdx.graphics.Color;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width = 600;
                config.height = 500;
                config.title = "Cold Pixel - Runner";
                config.resizable = false;
                
                config.addIcon("Graphics/Icon/Icon.png", Files.FileType.Internal);
                
                new LwjglApplication(new Main(), config);
	}
}
