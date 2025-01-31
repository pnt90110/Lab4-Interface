package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable{
	
	private boolean chopState;
	
	public Lettuce(){
		super("Lettuce");
		this.setEdible(true);
		this.chopState=false;
	}

	@Override
	public void chop() {
		// TODO Auto-generated method stub
		if(!this.isChopped()) {
			this.chopState=true;
			this.setName("Chopped Lettuce");
		}
	}

	@Override
	public boolean isChopped() {
		// TODO Auto-generated method stub
		return chopState;
	}
}
