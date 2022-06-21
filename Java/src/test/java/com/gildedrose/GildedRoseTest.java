package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
	@Test
    void testAgedBrieIncreaseInQualityByOneWhenNotExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void testAgedBrieIncreaseInQualityByTwoWhenExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void testAgedBrieNoChangeInQualityOnceQualityReachesFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void testBackstageIncreaseInQualityByOneWhenSellInGreaterThanTen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(41, app.items[0].quality);
    }

    @Test
    void testBackstageIncreaseInQualityByTwoWhenSellInLessThanEleven() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void testBackstageIncreaseInQualityByThreeWhenSellInLessThanSix() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }
    
    @Test
    void testBackstageNoChangeInQualityOnceQualityReachesFifty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackstageQualityReducedToZeroWhenExpired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    /*@Test
    void testConjuredDecreaseInQualityByTwoWhenNotExpired() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 12, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(38, app.items[0].quality);
    }

    @Test
    void testConjuredDecreaseInQualityByFourWhenExpired() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }
    
    @Test
    void testConjuredNoChangeInQualityOnceQualityReachesZero() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }*/
    
    @Test
    void testGenericDecreaseInQualityByOneWhenNotExpired(){
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 1, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(39, app.items[0].quality);
    }

    @Test
    void testGenericDecreaseInQualityByTwoWhenExpired() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void testGenericNoChangeInQualityOnceQualityReachesZero() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void testSulfurasNoChangeInQualityAndSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 12, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
}
