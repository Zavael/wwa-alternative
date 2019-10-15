package sk.badand.asg.core.screens.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import sk.badand.asg.core.CoreApp;
import sk.badand.asg.core.GameProperties;
import sk.badand.asg.core.extensions.FilledRectangle;

public class MenuStage extends Stage {
    private final Skin skin = new Skin(Gdx.files.internal("data/visui/uiskin.json"));
    private CoreApp game;

    private FilledRectangle menuBG;

    public MenuStage(CoreApp game) {
        super(new ScreenViewport());
//        this.setDebugAll(true);

        this.game = game;

        Table components = new Table();
        components.setFillParent(true);
//        components.setPosition(500, 500);
        components.top();
        components.add(new Label("Press [Esc] to end", skin.get("menuitem", Label.LabelStyle.class)));
//        components.top().add(new Button());
        addActor(components);
        menuBG = new FilledRectangle(0, GameProperties.windowHeight - 40, GameProperties.windowWidth, 40, new Color(0.3f, 0.3f, 0.3f, 0.5f));
    }

    @Override
    public void draw() {
        this.game.gameBatch.begin();
        menuBG.draw(this.game.gameBatch, 1);
        this.game.gameBatch.end();
        super.draw();
    }
}
