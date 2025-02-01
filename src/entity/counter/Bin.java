package entity.counter;

import java.awt.Container;

import entity.base.Ingredient;
import entity.base.Item;
import entity.container.*;
import logic.Player;

public class Bin extends Counter {
	public Bin() {
		super("Bin");
	}
	
	public void interact(Player p) {
		if(!p.isHandEmpty()) {
			Item item = p.getHoldingItem();
			if (item instanceof Ingredient) {
	            p.setHoldingItem(null);
	        } else if (item instanceof Dish) {
	        	Dish dish = (Dish)item;
	        	dish.clearContent();
	        } else if (item instanceof Pan) {
	        	Pan pan = (Pan)item;
	        	pan.clearContent();
	        }
		}
	}
}
