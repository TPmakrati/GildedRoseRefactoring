package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GildedRoseCumulativeTest {
	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		testGildedRoseItems(items, app, days);
	}

	@Test
	private static void testGildedRoseItems(Item[] items, GildedRose app, int days) {
		app.updateQuality();
		System.out.println("-------- day " + 1 + " --------");
		System.out.println("name, sellIn, quality");
		for (Item item : items) {
			System.out.println(item);
		}
		System.out.println();
		assertTrue(app.items[0].name.equals("+5 Dexterity Vest") && app.items[0].sellIn == 9
				&& app.items[0].quality == 19);
		assertTrue(app.items[1].name.equals("Aged Brie") && app.items[1].sellIn == 1
				&& app.items[1].quality == 1);
		assertTrue(app.items[2].name.equals("Elixir of the Mongoose") && app.items[2].sellIn == 4
				&& app.items[2].quality == 6);
		assertTrue(app.items[3].name.equals("Sulfuras, Hand of Ragnaros") && app.items[3].sellIn == 0
				&& app.items[3].quality == 80);
		assertTrue(app.items[4].name.equals("Sulfuras, Hand of Ragnaros") && app.items[4].sellIn == -1
				&& app.items[4].quality == 80);
		assertTrue(app.items[5].name.equals("Backstage passes to a TAFKAL80ETC concert") && app.items[5].sellIn == 14
				&& app.items[5].quality == 21);
		assertTrue(app.items[6].name.equals("Backstage passes to a TAFKAL80ETC concert") && app.items[6].sellIn == 9
				&& app.items[6].quality == 50);
		assertTrue(app.items[7].name.equals("Backstage passes to a TAFKAL80ETC concert") && app.items[7].sellIn == 4
				&& app.items[7].quality == 50);
		/*assertTrue(app.items[8].name.equals("Conjured Mana Cake") && app.items[8].sellIn == 2
				&& app.items[8].quality == 4);*/
		app.updateQuality();
		System.out.println("-------- day " + 2 + " --------");
		System.out.println("name, sellIn, quality");
		for (Item item : items) {
			System.out.println(item);
		}
		System.out.println();
		assertTrue(app.items[0].name.equals("+5 Dexterity Vest") && app.items[0].sellIn == 8
				&& app.items[0].quality == 18);
		assertTrue(app.items[1].name.equals("Aged Brie") && app.items[1].sellIn == 0
				&& app.items[1].quality == 2);
		assertTrue(app.items[2].name.equals("Elixir of the Mongoose") && app.items[2].sellIn == 3
				&& app.items[2].quality == 5);
		assertTrue(app.items[3].name.equals("Sulfuras, Hand of Ragnaros") && app.items[3].sellIn == 0
				&& app.items[3].quality == 80);
		assertTrue(app.items[4].name.equals("Sulfuras, Hand of Ragnaros") && app.items[4].sellIn == -1
				&& app.items[4].quality == 80);
		assertTrue(app.items[5].name.equals("Backstage passes to a TAFKAL80ETC concert") && app.items[5].sellIn == 13
				&& app.items[5].quality == 22);
		assertTrue(app.items[6].name.equals("Backstage passes to a TAFKAL80ETC concert") && app.items[6].sellIn == 8
				&& app.items[6].quality == 50);
		assertTrue(app.items[7].name.equals("Backstage passes to a TAFKAL80ETC concert") && app.items[7].sellIn == 3
				&& app.items[7].quality == 50);
		/*assertTrue(app.items[8].name.equals("Conjured Mana Cake") && app.items[8].sellIn == 1
				&& app.items[8].quality == 2);*/
	}

}
