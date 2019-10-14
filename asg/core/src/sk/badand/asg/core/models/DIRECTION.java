package sk.badand.asg.core.models;

import com.badlogic.gdx.math.MathUtils;
import sk.badand.asg.core.Utils;

public enum DIRECTION {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    NORTHEAST(NORTH, EAST),
    SOUTHEAST(EAST, SOUTH),
    SOUTHWEST(SOUTH, WEST),
    NORTHWEST(WEST, NORTH);

    DIRECTION() {
    }

    private DIRECTION(DIRECTION left, DIRECTION right) {
        this.toLeft = left;
        left.toRight = this;
        this.toRight = right;
        right.toLeft = this;
    }

    public DIRECTION toLeft;
    public DIRECTION toRight;

    public DIRECTION nextRandom() {
        int i = MathUtils.random(30);
        if (i < 5) {
            return toLeft;
        } else if (i > 25) {
            return toRight;
        }
        return this;
    }
}
