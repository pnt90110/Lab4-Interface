package entity.counter;

import entity.base.Item;
import entity.container.Pan;
import logic.Player;

public class Stove extends Counter{
	public Stove() {
		super("Stove");
	}
	public Stove(Item content) {
		super("Stove");
		this.setPlacedContent(content);
	}

	@Override
	public void interact(Player p) {
		if(this.getPlacedContent()!=null) {
			super.interact(p);
		} else {
			Item holdedItem=p.getHoldingItem();
			if(holdedItem instanceof Pan) {
				super.interact(p);
			}
		}
	}
	
	public void update() {
		Item placedItem=this.getPlacedContent();
		if(placedItem instanceof Pan) {
			Pan pan = (Pan) placedItem;
			pan.cook();
		}
	}
	
}
