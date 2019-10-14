package sk.badand.asg.core.models;

import sk.badand.asg.core.Utils;

/**
 *
 */
public abstract class EatingModel extends LivingModel {
    protected EatingModel(int hitpoints) {
        super(hitpoints);
    }

    /**
     * Restore hitpoints by consuming food
     * @param mealpoints
     */
    public void eat(int mealpoints) {
        //TODO think about if 1 food unit should be equal 1 hitpoint?
        if (hitpoints < initialHitpoints) {
            hitpoints += mealpoints;
            if (hitpoints > initialHitpoints) {
                hitpoints = initialHitpoints;
            }
        }
    }

    //TODO rethink this concept
    /**
     * @return hunger rate. Ranges from 0.0 to 1.0, higher means greater hunger
     */
    public double hunger() {
        return Utils.round(1.0 - (double)hitpoints / initialHitpoints, 2) ;
    }
}
