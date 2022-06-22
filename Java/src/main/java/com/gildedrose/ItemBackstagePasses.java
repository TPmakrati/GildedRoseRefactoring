package com.gildedrose;

public class ItemBackstagePasses implements ItemAlterationInterface {

	@Override
	public int getAlterationValue(Item item) {
		int sellIn = item.sellIn;
		if(sellIn < 6)
			return 3;
		else if(sellIn < 11)
			return 2;
		else
			return 1;
	}
	
	@Override
	public int getAlterationValueWhenExpired(Item item, int alterBy) {
		return -item.quality;		
	}

}
