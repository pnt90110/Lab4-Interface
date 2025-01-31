package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.*;

public class Egg extends Ingredient implements Cookable{

	private int cookedPercentage;
	
	public Egg() {
		super("Egg");
		this.setCookedPercentage(0);
	}
	
	@Override
	public void cook() {

		this.setCookedPercentage(getCookedPercentage()+12);
		this.setEdible(true);
		if(cookedPercentage<=50) {
			this.setName("Raw Egg");
			this.setEdible(false);
		}
		else if(cookedPercentage<=80)
			this.setName("Sunny Side Egg");
		else if(cookedPercentage<=100)
			this.setName("Fried Egg");
		else {
			this.setName("Burnt Egg");
			this.setEdible(false);
		}
		
	}

	@Override
	public boolean isBurnt() {
		if(cookedPercentage>100)
			return true;
		return false;
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(this.getName(),cookedPercentage);
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}
	

	public void setCookedPercentage(int cookedPercentage) {
		if(cookedPercentage<0)
			cookedPercentage=0;

		this.cookedPercentage = cookedPercentage;
	}

	
}
