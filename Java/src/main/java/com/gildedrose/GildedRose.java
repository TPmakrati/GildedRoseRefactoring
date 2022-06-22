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
		for (Item item : itemsWithoutSulfuras) {
			if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
				if (item.quality > 0) {
					if (item.name.equals(CONJURED_MANA_CAKE)) {
						item.quality = item.quality - 2;
					} else {
						item.quality = item.quality - 1;
					}
				}
			} else {
				if (item.quality < 50) {
					item.quality = item.quality + 1;

					if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
						if (item.sellIn < 11) {
							if (item.quality < 50) {
								item.quality = item.quality + 1;
							}
						}

						if (item.sellIn < 6) {
							if (item.quality < 50) {
								item.quality = item.quality + 1;
							}
						}
					}
				}
			}

			item.sellIn = item.sellIn - 1;

			if (item.sellIn < 0) {
				if (!item.name.equals(AGED_BRIE)) {
					if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
						if (item.quality > 0) {
							if (item.name.equals(CONJURED_MANA_CAKE)) {
								item.quality = item.quality - 2;
							} else {
								item.quality = item.quality - 1;
							}
						}
					} else {
						item.quality = item.quality - item.quality;
					}
				} else {
					if (item.quality < 50) {
						item.quality = item.quality + 1;
					}
				}
			}
		}
	}
}