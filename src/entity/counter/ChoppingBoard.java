package entity.counter;

import entity.base.Choppable;
import entity.base.Ingredient;
import entity.base.Item;
import entity.ingredient.Lettuce;
import entity.ingredient.Meat;
import logic.Player;

public class ChoppingBoard extends Counter{
	public ChoppingBoard() {
		super("Chopping Board");
	}
	@Override
	public void interact(Player p) {
		if(!this.isPlacedContentEmpty()) {
			super.interact(p);
		} else {
            Item heldItem = p.getHoldingItem();

            if (heldItem instanceof Ingredient) {
                super.interact(p); // Call default Counter behavior to place the ingredient

                if (heldItem instanceof Choppable) {
                    Choppable choppableItem = (Choppable) heldItem;
                    choppableItem.chop();
                } 
            }
		}
	}
}
