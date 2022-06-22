package com.gildedrose;

public class ItemConjured implements ItemAlterationInterface {

	@Override
	public int getAlterationValue(Item item) {
		return -2;
	}

}
