package sk.badand.asg.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import sk.badand.asg.core.CoreApp;

public class MenuScreen extends GameScreen {

    private VerticalGroup menuGroup = new VerticalGroup();
    private Skin skin = new Skin(Gdx.files.internal("data/visui/uiskin.json"));
    private int selectedButton = -1;

    public MenuScreen(CoreApp game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        menuGroup.space(5);
        menuGroup.setPosition(200,400);
        menuGroup.setFillParent(true);

        Button button = new Button(skin);
        button.setName("start");
        button.setStyle(skin.get("blue", Button.ButtonStyle.class));
        button.addActor(new Label("Start", skin));
        menuGroup.addActorAt(0, button);
        selectedButton = 0;

        button = new Button(skin);
        button.setName("end");
        button.addActor(new Label("End", skin));
        menuGroup.addActorAt(1, button);
        menuGroup.validate();
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        menuGroup.act(deltaTime);
        game.gameBatch.setProjectionMatrix(camera.combined);

        game.gameBatch.begin();
        menuGroup.draw(game.gameBatch, 1f);
        game.gameBatch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        Button button = null;
        switch (keycode) {
            case Input.Keys.LEFT:
                break;
            case Input.Keys.RIGHT:
                break;
            case Input.Keys.UP:
                button = (Button) menuGroup.getChild(selectedButton);
                button.setStyle(skin.get("default", Button.ButtonStyle.class));
                if (selectedButton == 0) {
                    selectedButton = menuGroup.getChildren().size - 1;
                } else {
                    selectedButton--;
                }
                button = (Button) menuGroup.getChild(selectedButton);
                button.setStyle(skin.get("blue", Button.ButtonStyle.class));
                break;
            case Input.Keys.DOWN:
                button = (Button) menuGroup.getChild(selectedButton);
                button.setStyle(skin.get("default", Button.ButtonStyle.class));
                if (selectedButton == menuGroup.getChildren().size - 1) {
                    selectedButton = 0;
                } else {
                    selectedButton++;
                }
                button = (Button) menuGroup.getChild(selectedButton);
                button.setStyle(skin.get("blue", Button.ButtonStyle.class));
                break;
            case Input.Keys.ENTER:

                button = (Button) menuGroup.getChild(selectedButton);
                if (button.getName().equalsIgnoreCase("start")) {
                    game.setScreen(new WorldScreen(game));
                } else {
                    Gdx.app.exit();
                }
                break;
            default:
        }
        return false;
    }
}
