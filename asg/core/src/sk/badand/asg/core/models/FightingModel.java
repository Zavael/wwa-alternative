package sk.badand.asg.core.models;

import java.awt.*;

/**
 * Abstract class providing basic fighting abilities.
 * @strength - int value, higher means stronger, prototype system: 1 strentgh unit takes 1 hitpoint on attack
 */
public abstract class FightingModel extends MovingModel {
    public int strength;

    protected FightingModel(Point position, int speed, int strength, int hitpoints) {
        super(position, speed, hitpoints);
        strength = strength;
    }

    protected FightingModel(int speed, int strength, int hitpoints) {
        super(speed, hitpoints);
        strength = strength;
    }

    public void attack(FightingModel target) {
        if (!isPowerless()) {
            target.hitpoints -= strength;
        }
        if (!target.isDead() || !target.isPowerless()) {
            //at the attack the target deals minor damage as a response to the hit
            hitpoints -= target.strength / 4;
        }
    }
}
