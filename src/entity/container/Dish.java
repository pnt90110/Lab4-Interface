package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container{

	private int dirty;
	public Dish() {
		super("Dish",4);
		this.dirty=0;
	}
	public Dish(int dirty) {
		super("Dish",4);
		this.setDirty(dirty);
	}
	
	public boolean isDirty() {
		if (this.dirty>0)
			return true;
		return false;
	}
	
	@Override
	public boolean verifyContent(Ingredient i) {
		if(!isDirty() & i.isEdible())
			return true;
		return false;
	}

	public int getDirty() {
		return dirty;
	}
	public void setDirty(int dirty) {
		if(dirty<0)dirty=0;
		
		this.dirty = dirty;
		
		if(this.dirty>0)
			this.setName("Dirty Dish");
		else
			this.setName("Dish");
	}
	public void clean(int amount) {
		dirty-=amount;
		if(dirty<0)dirty=0;
		setDirty(dirty);
	}
	public  String toString() {
		if(isDirty())
			return StringUtil.formatNamePercentage(getName(), dirty);
		else
			return super.toString();
	}
	
}
