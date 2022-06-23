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
		itemsWithoutSulfuras.parallelStream().forEach(GildedRose::updateItemQuality);
		adjustQuality(itemsWithoutSulfuras);
	}

	private static void updateItemQuality(Item item) {
		int alterBy = 0;
		ItemAlterationInterface itemAlteration = createItemAlterationObject(item);
		alterBy += itemAlteration.getAlterationValue(item);
		item.sellIn -= 1;
		if (item.sellIn < 0) {
			alterBy = itemAlteration.getAlterationValueWhenExpired(item, alterBy);
		}
		item.quality += alterBy;
	}

	private static ItemAlterationInterface createItemAlterationObject(Item item) {
		ItemAlterationFactory itemFactory = new ItemAlterationFactory();
		return itemFactory.createItemObject(item.name);
	}

	private void adjustQuality(List<Item> itemsWithoutSulfuras) {
		itemsWithoutSulfuras.parallelStream().filter(item -> item.quality < 0).forEach(item -> item.quality = 0);
		itemsWithoutSulfuras.parallelStream().filter(item -> item.quality > 50).forEach(item -> item.quality = 50);
	}
}