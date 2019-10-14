package sk.badand.asg.core.models;

import com.badlogic.gdx.math.MathUtils;
import sk.badand.asg.core.GameProperties;
import sk.badand.asg.core.Utils;

import java.awt.*;

public abstract class MovingModel extends EatingModel {
    public Point position;
    private int speed;
    private int topSpeed;
    protected DIRECTION direction = DIRECTION.NORTH;
    private Point targetPosition;

    protected MovingModel(int speed, int hitpoints) {
        this(new Point(MathUtils.random(GameProperties.windowWidth), MathUtils.random(GameProperties.windowHeight)), speed, hitpoints);
    }

    protected MovingModel(Point startPosition, int topSpeed, int hitpoints) {
        super(hitpoints);
        position = startPosition;
        targetPosition = position.getLocation();
        this.topSpeed = topSpeed;
        speed = this.topSpeed;
    }

    public void move(DIRECTION moveDirection, float deltaTime) {
        if (isDead()) {
            return;
        }
        if (isPowerless()) {
            speed = topSpeed/4;
        }
        direction = moveDirection;

        switch (direction) {
            case NORTH:
                targetPosition.x = position.x;
                targetPosition.y = position.y + Math.round(speed*deltaTime);
                break;
            case NORTHEAST:
                targetPosition.x = position.x + Math.round(speed*deltaTime);
                targetPosition.y = position.y + Math.round(speed*deltaTime);
                break;
            case EAST:
                targetPosition.x = position.x + Math.round(speed*deltaTime);
                targetPosition.y = position.y;
                break;
            case SOUTHEAST:
                targetPosition.x = position.x + Math.round(speed*deltaTime);
                targetPosition.y = position.y - Math.round(speed*deltaTime);
                break;
            case SOUTH:
                targetPosition.x = position.x;
                targetPosition.y = position.y - Math.round(speed*deltaTime);
                break;
            case SOUTHWEST:
                targetPosition.x = position.x - Math.round(speed*deltaTime);
                targetPosition.y = position.y - Math.round(speed*deltaTime);
                break;
            case WEST:
                targetPosition.x = position.x - Math.round(speed*deltaTime);
                targetPosition.y = position.y;
                break;
            case NORTHWEST:
                targetPosition.x = position.x - Math.round(speed*deltaTime);
                targetPosition.y = position.y + Math.round(speed*deltaTime);
                break;
        }

//        if (targetPosition.x < 0 || position.x > 800 - texture.getWidth()) {
//            position.x = lastLocation.x;
//        }
//        if (position.y < 0 || position.y > 600 - texture.getHeight()) {
//            position.y = lastLocation.y;
//        }

        position.move(targetPosition.x, targetPosition.y);
    }
}
