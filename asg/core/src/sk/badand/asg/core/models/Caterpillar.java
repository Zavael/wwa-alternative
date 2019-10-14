package sk.badand.asg.core.models;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import sk.badand.asg.core.Utils;
import sk.badand.asg.core.extensions.RotatableSpriteBatch;

import java.awt.*;

public class Caterpillar extends MovingModel {
    public Caterpillar(int speed, int hitpoints) {
        super(speed, hitpoints);
    }

    public Caterpillar(Point startPosition, int topSpeed, int hitpoints) {
        super(startPosition, topSpeed, hitpoints);
    }


    public void update(float deltaTime) {
        reassess(deltaTime);
        move(direction.nextRandom(), deltaTime);
    }

    public void draw(RotatableSpriteBatch gameBatch, BitmapFont gameFont) {
        gameBatch.drawRotated(Utils.textureMap.get(Utils.Textures.CATERPILLAR), position.x, position.y, 1, direction);

        gameFont.setColor(10,10,10,0.6f);
        gameFont.draw(gameBatch, "" + hitpoints, position.x+40, position.y+30);
    }

    @Override
    public void dispose() {

    }
}
