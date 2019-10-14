package sk.badand.asg.core.models;

import com.badlogic.gdx.utils.Disposable;

public abstract class LivingModel implements Disposable {
    private static final double HEALTH_DECREASE_PER_TIME_RATIO = 0.001; //TODO move to config or attributes
    private static final double MEAL_DECREASE_PER_TIME_RATIO = 0.01;
    protected final int initialHitpoints;
    protected final int initialMealpoints;
    protected int hitpoints;
    private int mealpoints;

    protected LivingModel(int startHitpoints) {
        hitpoints = startHitpoints;
        initialHitpoints = hitpoints;
        mealpoints = initialHitpoints / 2; //TODO half of the hitpoints can serve as food?
        initialMealpoints = mealpoints;
    }

    //TODO test the formulas
    /**
     * update life properties over time
     * @param deltaTime
     */
    public void reassess(float deltaTime) {
        if (isDead()) {
            mealpoints -= deltaTime * MEAL_DECREASE_PER_TIME_RATIO * initialMealpoints;
        }

        hitpoints -= deltaTime * HEALTH_DECREASE_PER_TIME_RATIO * initialHitpoints;
        if (hitpoints < 0) {
            hitpoints = 0;
        }
    }

    /**
     * unable to do any action besides eat to restore health (if food source is near or trough Trophallaxis)
     * @return
     */
    public boolean isPowerless() {
        return hitpoints < (initialHitpoints / 5);
    }
    /**
     * RIP little one
     * @return
     */
    public boolean isDead() {
        return hitpoints <= 0;
    }
    /**
     * is dead and vanished, i.e. cannot be converted to meal
     * @return
     */
    public boolean isVanished() {
        return hitpoints <= 0 && mealpoints <= 0;
    }
    private boolean canConvertToMeal() {
        return isDead() && !isVanished();
    }

    /**
     * Transform dead body to meal
     * @return amount of food extracted from body or 0 if still living or already vanished
     */
    public int convertToMeal() {
        if (canConvertToMeal()) {
            int tempFoodAmount = mealpoints;
            mealpoints = 0;
            return tempFoodAmount;
        } else {
            return 0;
        }
    }

    @Override
    public abstract void dispose();
}
