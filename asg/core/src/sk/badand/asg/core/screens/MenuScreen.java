package sk.badand.asg.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import sk.badand.asg.core.CoreApp;

public class MenuScreen extends GameScreen {

    private VerticalGroup rootLayout = new VerticalGroup();
    private VerticalGroup menuGroup = new VerticalGroup();
    private Skin skin = new Skin(Gdx.files.internal("data/visui/uiskin.json"));
    private int selectedButton = -1;

    public MenuScreen(CoreApp game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        rootLayout.setFillParent(true);
        rootLayout.columnLeft();
        rootLayout.space(20);
        rootLayout.setPosition(200, 400);

        menuGroup.space(5);
        menuGroup.columnLeft();
//        menuGroup.setOrigin(200,400);
//        menuGroup.setFillParent(true);

        Button button = new TextButton("Start", skin);
        button.setName("start");
        button.setStyle(skin.get("blue", TextButton.TextButtonStyle.class));
        menuGroup.addActorAt(0, button);
        selectedButton = 0;

        button = new TextButton("About", skin);
        button.setName("about");
        menuGroup.addActorAt(1, button);

        button = new TextButton("End", skin);
        button.setName("end");
        menuGroup.addActorAt(2, button);

        Label help = new Label("Use: [UP] [DOWN] [ENTER]", skin);
        help.setPosition(menuGroup.getX(), menuGroup.getY());
        help.setStyle(skin.get("help", Label.LabelStyle.class));

        rootLayout.addActor(menuGroup);
        rootLayout.addActor(help);
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        rootLayout.act(deltaTime);
        game.gameBatch.setProjectionMatrix(camera.combined);

        game.gameBatch.begin();
        rootLayout.draw(game.gameBatch, 1f);
        game.gameBatch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        int newIndex = 0;
        switch (keycode) {
            case Input.Keys.LEFT:
                break;
            case Input.Keys.RIGHT:
                break;
            case Input.Keys.UP:
                if (selectedButton == 0) {
                    newIndex = menuGroup.getChildren().size - 1;
                } else {
                    newIndex = selectedButton - 1;
                }
                setSelectedButton(newIndex);
                break;
            case Input.Keys.DOWN:
                if (selectedButton == menuGroup.getChildren().size - 1) {
                    newIndex = 0;
                } else {
                    newIndex = selectedButton + 1;
                }
                setSelectedButton(newIndex);
                break;
            case Input.Keys.ENTER:

                Button button = (Button) menuGroup.getChild(selectedButton);
                if (button.getName().equalsIgnoreCase("start")) {
                    game.setScreen(new WorldScreen(game));
                } else if (button.getName().equalsIgnoreCase("end")) {
                    Gdx.app.exit();
                }
                break;
            default:
        }
        return false;
    }

    private void setSelectedButton(int newButtonIndex) {
        setButtonStyle("default", (Button) menuGroup.getChild(selectedButton));

        selectedButton = newButtonIndex;
        setButtonStyle("blue", (Button) menuGroup.getChild(selectedButton));
    }

    private void setButtonStyle(String styleName, Button button) {
        button.setStyle(skin.get(styleName, TextButton.TextButtonStyle.class));
    }
}
