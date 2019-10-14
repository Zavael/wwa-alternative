package sk.badand.asg.core.models;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import sk.badand.asg.core.Utils;
import sk.badand.asg.core.extensions.RotatableSpriteBatch;

import java.awt.*;

public class Cockroach extends FightingModel {
    protected Cockroach(Point position, int speed, int strength, int hitpoints) {
        super(position, speed, strength, hitpoints);
    }

    public Cockroach(int speed, int strength, int hitpoints) {
        super(speed, strength, hitpoints);
    }


    public void update(float deltaTime) {
        reassess(deltaTime);
        move(direction.nextRandom(), deltaTime);
    }

    public void draw(RotatableSpriteBatch gameBatch, BitmapFont gameFont) {
        gameBatch.drawRotated(Utils.textureMap.get(Utils.Textures.COCKROACH), position.x, position.y, 1, direction);

        gameFont.setColor(10,10,10,0.6f);
        gameFont.draw(gameBatch, "" + hitpoints, position.x+40, position.y+30);
    }

    @Override
    public void dispose() {

    }
}
