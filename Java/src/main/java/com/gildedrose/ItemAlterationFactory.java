package com.gildedrose;

public class ItemAlterationFactory {

	public ItemAlterationInterface createItemObject(String itemName) {
		if (itemName == null || itemName.isEmpty())
			 return null;
		switch (itemName) {
			case ItemNames.AGED_BRIE:
				return new ItemAgedBrie();
		    case ItemNames.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT:
		    	return new ItemBackstagePasses();
		    case ItemNames.CONJURED_MANA_CAKE:
		    	return new ItemConjured();
		    default:
		    	return new ItemGeneric();
		}
	}

}
