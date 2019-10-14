package sk.badand.asg.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import sk.badand.asg.core.CoreApp;

public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Ant Simulation Game");
        config.setWindowedMode(1200, 900);
        new Lwjgl3Application(new CoreApp(), config);
    }
}
