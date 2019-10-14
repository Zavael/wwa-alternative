package sk.badand.asg.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import sk.badand.asg.core.CoreApp;
import sk.badand.asg.core.GameProperties;

public abstract class GameScreen implements Screen, InputProcessor {

    protected CoreApp game;
    protected OrthographicCamera camera;

    public GameScreen(CoreApp coreApp) {
        game = coreApp;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameProperties.windowWidth, GameProperties.windowHeight);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose(){
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyTyped (char character) {
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved (int x, int y) {
        return false;
    }

    @Override
    public boolean scrolled (int amount) {
        return false;
    }

    @Override
    public void resize(int width, int height){
    }

    @Override
    public void show(){
    }

    @Override
    public void hide(){

    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }

}