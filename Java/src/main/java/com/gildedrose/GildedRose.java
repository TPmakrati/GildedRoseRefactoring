package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
	private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		List<Item> itemsWithoutSulfuras = Arrays.asList(items).parallelStream()
				.filter(item -> (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS))).collect(Collectors.toList());
		itemsWithoutSulfuras.parallelStream().forEach(item -> updateItemQuality(item));
		adjustQuality(itemsWithoutSulfuras);
	}

	private void updateItemQuality(Item item) {
		int alterBy = 0;
		alterBy = updateAlterBy(item, alterBy);
		item.sellIn -= 1;
		if (item.sellIn < 0) {
			alterBy = updateAlterByWhenItemExpired(item, alterBy);
		}
		alterByValue(item, alterBy);
	}

	private int updateAlterBy(Item item, int alterBy) {
		if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
			if (item.name.equals(CONJURED_MANA_CAKE)) {
				alterBy -= 2;
			} else {
				alterBy -= 1;
			}
		} else {
			alterBy += 1;
			if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
				if (item.sellIn < 11) {
					alterBy += 1;
				}

				if (item.sellIn < 6) {
					alterBy += 1;
				}
			}
		}		
		return alterBy;
	}

	private int updateAlterByWhenItemExpired(Item item, int alterBy) {
		if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
			alterBy *= 2;
		} else{
			alterBy = - item.quality;
		}
		return alterBy;
	}
	
	private void alterByValue(Item item, int alterBy) {
		item.quality += alterBy;
	}

	private void adjustQuality(List<Item> itemsWithoutSulfuras) {
		itemsWithoutSulfuras.parallelStream().filter(item -> item.quality < 0).forEach(item -> item.quality = 0);
		itemsWithoutSulfuras.parallelStream().filter(item -> item.quality > 50).forEach(item -> item.quality = 50);
	}
}