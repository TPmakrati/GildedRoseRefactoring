package com.gildedrose;

public interface ItemAlterationInterface {
	
	default int getAlterationValue(Item item) {
		return 0;
	}

	default int getAlterationValueWhenExpired(Item item, int alterBy) {
		return alterBy*2;
	}

}
