package sk.badand.asg.core.models;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Disposable;
import sk.badand.asg.core.Utils;
import sk.badand.asg.core.extensions.RotatableSpriteBatch;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Colony implements Disposable {
    private List<GenericAnt> ants;

    {
        ants = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ants.add(new GenericAnt(10000+i, 200, 20, MathUtils.random((1000)+500)));
        }
    }

    public void update(float deltaTime) {
        ants.removeIf(ant -> ant.isVanished());
        ants.forEach(genericAnt -> {
            genericAnt.update(deltaTime);
        });
    }

    public void draw(RotatableSpriteBatch gameBatch, BitmapFont gameFont) {
        ants.forEach(genericAnt -> {
            genericAnt.draw(gameBatch, gameFont);
        });
    }

    @Override
    public void dispose() {
        ants.forEach(ant -> {
            ant.dispose();
        });
    }
}
