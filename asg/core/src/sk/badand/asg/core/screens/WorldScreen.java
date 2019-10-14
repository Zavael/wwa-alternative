package sk.badand.asg.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import sk.badand.asg.core.CoreApp;
import sk.badand.asg.core.Utils;
import sk.badand.asg.core.models.*;
import sk.badand.asg.core.screens.stages.MenuStage;

import java.util.ArrayList;
import java.util.List;

public class WorldScreen extends GameScreen {

    private Colony colony = new Colony();
    private List<GenericWasp> wasps = new ArrayList<>();
    private List<Cockroach> cockroaches = new ArrayList<>();
    private List<Caterpillar> caterpillars = new ArrayList<>();
    private Stage menuStage;

    public WorldScreen(CoreApp game) {
        super(game);
        menuStage = new MenuStage(game);
        initCreatures();

        System.out.println("started world");
    }

    private void initCreatures() {
        for (int i = 0; i < 10; i++) {
            wasps.add(new GenericWasp(300, 300, 2000));
            cockroaches.add(new Cockroach(200, 100, 500));
            caterpillars.add(new Caterpillar(60, 3000));
        }
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.gameBatch.setProjectionMatrix(camera.combined);

        colony.update(deltaTime);
        wasps.parallelStream().forEach(genericWasp -> genericWasp.update(deltaTime));
        cockroaches.parallelStream().forEach(cockroach -> cockroach.update(deltaTime));
        caterpillars.parallelStream().forEach(caterpillar -> caterpillar.update(deltaTime));

        game.gameBatch.begin();
        game.gameBatch.draw(Utils.textureMap.get(Utils.Textures.GROUND), 0, 0);
        colony.draw(game.gameBatch, game.gameFont);
        wasps.forEach(genericWasp -> genericWasp.draw(game.gameBatch, game.gameFont));
        cockroaches.forEach(cockroach -> cockroach.draw(game.gameBatch, game.gameFont));
        caterpillars.forEach(caterpillar -> caterpillar.draw(game.gameBatch, game.gameFont));

        game.gameBatch.end();

        menuStage.draw();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                break;
            case Input.Keys.RIGHT:
                break;
            case Input.Keys.UP:
                break;
            case Input.Keys.DOWN:
                break;
            case Input.Keys.ESCAPE:
                game.setScreen(new MenuScreen(game));
                break;
            default:
        }
        return false;
    }

    @Override
    public void dispose() {
        colony.dispose();
        menuStage.dispose();
        super.dispose();
    }
}
