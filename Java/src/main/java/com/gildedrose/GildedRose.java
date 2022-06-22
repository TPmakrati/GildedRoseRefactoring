package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose extends GildedRoseImpl{

	public GildedRose(Item[] items) {
		super(items);
	}

	@Override
	public void updateQuality() {
		List<Item> itemsWithoutSulfuras = Arrays.asList(items).parallelStream()
				.filter(item -> (!item.name.equals(ItemNames.SULFURAS_HAND_OF_RAGNAROS))).collect(Collectors.toList());
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
		if (!item.name.equals(ItemNames.AGED_BRIE) && !item.name.equals(ItemNames.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
			if (item.name.equals(ItemNames.CONJURED_MANA_CAKE)) {
				alterBy -= 2;
			} else {
				alterBy -= 1;
			}
		} else {
			alterBy += 1;
			if (item.name.equals(ItemNames.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
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
		if (!item.name.equals(ItemNames.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
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