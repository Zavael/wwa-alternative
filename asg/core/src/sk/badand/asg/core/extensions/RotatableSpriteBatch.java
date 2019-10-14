package sk.badand.asg.core.extensions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import sk.badand.asg.core.models.DIRECTION;

public class RotatableSpriteBatch extends SpriteBatch {

    public void drawRotated(Texture texture, float x, float y, float scale, DIRECTION rotation) {
        switch (rotation) {

            //draw (Texture texture, float x, float y, float originX, float originY, float width, float height, float scaleX,
            //		float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) {

            case NORTH:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 0f);
                break;
            case NORTHEAST:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 315f);
                break;
            case EAST:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 270f);
                break;
            case SOUTHEAST:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 225f);
                break;
            case SOUTH:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 180f);
                break;
            case SOUTHWEST:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 135f);
                break;
            case WEST:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 90f);
                break;
            case NORTHWEST:
                draw(new TextureRegion(texture), x, y, texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), scale, scale, 45f);
                break;
        }
    }
}
