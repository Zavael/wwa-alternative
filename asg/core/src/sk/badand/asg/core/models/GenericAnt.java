package sk.badand.asg.core.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import sk.badand.asg.core.Utils;
import sk.badand.asg.core.extensions.RotatableSpriteBatch;

import java.awt.*;

import static sk.badand.asg.core.Utils.Textures;

public class GenericAnt extends FightingModel {

    public float textureScale = 1;
    private final int id;

    protected GenericAnt(int id, int speed, int strength, int hitpoints) {
        super(speed, strength, hitpoints);

        this.id = id;
    }

    //updates model over time
    public void update(float deltaTime) {
        reassess(deltaTime);
        move(direction.nextRandom(), deltaTime);
    }

    public void draw(RotatableSpriteBatch gameBatch, BitmapFont gameFont) {
        gameBatch.drawRotated(Utils.textureMap.get(Textures.ANT), position.x, position.y, textureScale, direction);

        gameFont.setColor(10,10,10,0.6f);
        gameFont.draw(gameBatch, "" + id, position.x+40, position.y+50);
        gameFont.draw(gameBatch, "" + hitpoints, position.x+40, position.y+30);
    }

    @Override
    public void dispose() {
    }
}
