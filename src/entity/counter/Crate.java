package entity.counter;

import logic.InvalidIngredientException;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter{
	private String myIngredient;
	public Crate(String s) {
		super(s+" Crate");
		setMyIngredient(s);		
	}
	
	public void interact(Player p) {
		if(!p.isHandEmpty()) {
			super.interact(p);
		}else {
			try {
				p.setHoldingItem(LogicUtil.createIngredientFromName(myIngredient));
			} catch (InvalidIngredientException e) {
				p.setHoldingItem(null);
			}
		}
	}
	
	public String getMyIngredient() {
		return myIngredient;
	}
	public void setMyIngredient(String myIngredient) {
		this.myIngredient = myIngredient;
	}
}
