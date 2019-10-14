package sk.badand.asg.core.models;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import sk.badand.asg.core.Utils;
import sk.badand.asg.core.extensions.RotatableSpriteBatch;

import java.awt.*;

public class GenericWasp extends FightingModel {
    protected GenericWasp(Point position, int speed, int strength, int hitpoints) {
        super(position, speed, strength, hitpoints);
    }

    public GenericWasp(int speed, int strength, int hitpoints) {
        super(speed, strength, hitpoints);
    }

    @Override
    public void dispose() {

    }

    public void update(float deltaTime) {
        reassess(deltaTime);
        move(direction.nextRandom(), deltaTime);
    }

    public void draw(RotatableSpriteBatch gameBatch, BitmapFont gameFont) {
        gameBatch.drawRotated(Utils.textureMap.get(Utils.Textures.WASP), position.x, position.y, 1, direction);

        gameFont.setColor(10,10,10,0.6f);
        gameFont.draw(gameBatch, "" + hitpoints, position.x+40, position.y+30);
    }
}
