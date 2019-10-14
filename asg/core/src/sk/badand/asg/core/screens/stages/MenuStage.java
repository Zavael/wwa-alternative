package sk.badand.asg.core.screens.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import sk.badand.asg.core.CoreApp;

public class MenuStage extends Stage {
    private final Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
    private CoreApp game;

    public MenuStage(CoreApp game) {
        super(new ScreenViewport());
//        this.setDebugAll(true);

        this.game = game;

        Table components = new Table();
        components.setFillParent(true);
//        components.setPosition(500, 500);
        components.top().add(new Label("this is LABEL!", skin));
//        components.top().add(new Button());
        addActor(components);
    }

}
