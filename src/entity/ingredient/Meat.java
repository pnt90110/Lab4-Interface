package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable,Cookable{

	private boolean chopState;
	private int cookedPercentage;
	
	public Meat() {
		super("Meat");
		this.chopState=false;
		this.cookedPercentage=0;
	}

	@Override
	public void chop() {
		if(this.chopState==false && this.cookedPercentage==0)
		{
			this.chopState=true;
			this.setName("Minced Meat");
		}
		
	}

	@Override
	public boolean isChopped() {
		return chopState;
	} 


	@Override
	public void cook() {
		if(this.chopState==false)
		{
			this.cookedPercentage+=10;
			
			if(this.getCookedPercentage()>0 & this.cookedPercentage<=50) {
				this.setName("Raw Meat");
				this.setEdible(false);
			}
			else if(this.getCookedPercentage()>50 & this.getCookedPercentage()<=80) {
				this.setName("Medium Rare Steak");
				this.setEdible(true);
			}
			else if(this.getCookedPercentage()>80 & this.getCookedPercentage()<=100)
			{
				this.setName("Well Done Steak");
				this.setEdible(true);
			}
			else if(this.getCookedPercentage()>100) {
				this.setName("Burnt Steak");
				this.setEdible(false);
			}
		}else {
			this.cookedPercentage+=15;
			
			if(this.getCookedPercentage()>0 & this.cookedPercentage<=80) {
				this.setName("Raw Burger");
				this.setEdible(false);
			}
			else if(this.getCookedPercentage()>80 & this.getCookedPercentage()<=100)
			{
				this.setName("Cooked Burger");
				this.setEdible(true);
			}
			else if(this.getCookedPercentage()>100) {
				this.setName("Burnt Burger");
				this.setEdible(false);
			}
			
		}
	}

	@Override
	public boolean isBurnt() {
		if (this.cookedPercentage>100)
			return true;
		return false;
	}

	public String toString() {
		return StringUtil.formatNamePercentage(this.getName(), cookedPercentage);
	}
	
	public boolean isChopState() {
		return chopState;
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
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
