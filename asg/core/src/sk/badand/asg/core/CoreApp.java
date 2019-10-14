package sk.badand.asg.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import sk.badand.asg.core.extensions.RotatableSpriteBatch;
import sk.badand.asg.core.screens.MenuScreen;
import sk.badand.asg.core.screens.WorldScreen;

public class CoreApp extends Game {

	public RotatableSpriteBatch gameBatch;
	public BitmapFont gameFont;
	private Screen currentScreen;

	@Override
	public void create() {
		gameBatch = new RotatableSpriteBatch();
		gameFont = new BitmapFont();
		Utils.initTextures();
		setScreen(new MenuScreen(this));

		//TODO music
//		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
//		// start the playback of the background music immediately
//		rainMusic.setLooping(true);
//		rainMusic.play();
		//TODO https://github.com/libgdx/libgdx/wiki/Logging
		//TODO managing stages https://gist.github.com/Leejjon/7fb8aa3ea2e4024a9eba31fa4f3339fb
	}

	@Override
	public void pause() {
		super.pause();
		//TODO best place to save game, called before dispose
	}

	@Override
	public void setScreen(Screen screen) {
		if (currentScreen == screen) {
			return;
		}
		super.setScreen(screen);
		if (currentScreen != null) {
			currentScreen.dispose();
		}
		currentScreen = screen;
	}

	@Override
	public void dispose() {
		System.out.println("game dispose");
		gameBatch.dispose();
		gameFont.dispose();
		if (currentScreen != null) {
			currentScreen.dispose();
		}
		Utils.dispose();
		super.dispose();
	}
}
