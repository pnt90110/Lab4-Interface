package test.grader.counter;

import entity.counter.Counter;
import logic.Player;
import entity.container.Dish; 
import entity.base.Item;

public class DishWasher extends Counter {

    public DishWasher() {
        super("Dish Washer");
    }

    @Override
    public void interact(Player p) {
        if (!this.isPlacedContentEmpty()) {
            super.interact(p);
        } else {
            Item heldItem = p.getHoldingItem();
            if (heldItem instanceof Dish) {
                Dish dish = (Dish) heldItem;
                if(dish.isDirty()) {
                	super.interact(p);
                }
            }
        }
    }
    
    public void update() {
    	if(this.getPlacedContent() instanceof Dish) {
    		Dish dish=(Dish)this.getPlacedContent();
    		dish.clean(15);
    	}
    }
}