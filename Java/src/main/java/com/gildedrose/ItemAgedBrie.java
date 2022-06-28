package com.gildedrose;

public class ItemAgedBrie implements ItemAlterationInterface {

	@Override
	public int getAlterationValue(Item item) {
		return 1;
	}

}
