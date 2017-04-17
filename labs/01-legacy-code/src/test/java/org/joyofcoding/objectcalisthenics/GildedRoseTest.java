package org.joyofcoding.objectcalisthenics;

import org.joyofcoding.objectcalisthenics.assertions.ItemsAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GildedRoseTest {
    private static final int MAX_BACKSTAGE_SELLIN = 30;
    private static final int MAX_QUALITY = 50;
    private GildedRose gildedRose;
    private List<Item> items;
    private Random rand = new Random(3456789);

    @Before
    public void setup() {
        gildedRose = new GildedRose();
        items = gildedRose.makeItems();
    }

    @Test
    public void after_one_day() {
        repeatUpdateQuality(1);

        ItemsAssert.assertThat(items)
                .containsOnlyItemNames("+5 Dexterity Vest",
                        "Aged Brie",
                        "Elixir of the Mongoose",
                        "Sulfuras, Hand of Ragnaros",
                        "Backstage passes to a TAFKAL80ETC concert",
                        "Conjured Mana Cake")
                .containsOnlyItemQualities(new Quality(19).getQuality(), new Quality(1).getQuality(), new Quality(6).getQuality(), new Quality(80).getQuality()
                        , new Quality(21).getQuality(), new Quality(5).getQuality())
                .containsOnlyItemSellIns(new SellIn(9).getSellIn(), new SellIn(1).getSellIn(), new SellIn(4).getSellIn(), new SellIn(0).getSellIn(), new SellIn(14).getSellIn(), new SellIn(2).getSellIn());
    }

    @Test
    public void after_one_day_with_sufuras_having_sellIn_lesser_than_zero_and_quality_greater_than_zero() {
        items = new ArrayList<Item>();
        items.add(new Item("Sulfuras, Hand of Ragnaros", new SellIn(-1), new Quality(1)));
        repeatUpdateQuality(1);

        ItemsAssert.assertThat(items)
                .containsOnlyItemNames("Sulfuras, Hand of Ragnaros")
                .containsOnlyItemQualities(new Quality(1).getQuality())
                .containsOnlyItemSellIns(-1);
    }

    @Test
    public void after_three_days() {
        repeatUpdateQuality(3);

        ItemsAssert.assertThat(items)
                .containsOnlyItemNames("+5 Dexterity Vest",
                        "Aged Brie",
                        "Elixir of the Mongoose",
                        "Sulfuras, Hand of Ragnaros",
                        "Backstage passes to a TAFKAL80ETC concert",
                        "Conjured Mana Cake")
                .containsOnlyItemQualities(new Quality(17).getQuality(), new Quality(4).getQuality(), new Quality(4).getQuality(), new Quality(80).getQuality(), new Quality(23).getQuality(), new Quality(3).getQuality())
                .containsOnlyItemSellIns(new SellIn(7).getSellIn(), new SellIn(-1).getSellIn(), new SellIn(2).getSellIn(), new SellIn(0).getSellIn(), new SellIn(12).getSellIn(), new SellIn(0).getSellIn());
    }

    @Test
    public void after_a_shitload_of_days() {
        repeatUpdateQuality(500);

        ItemsAssert.assertThat(items)
                .containsOnlyItemNames("+5 Dexterity Vest",
                        "Aged Brie",
                        "Elixir of the Mongoose",
                        "Sulfuras, Hand of Ragnaros",
                        "Backstage passes to a TAFKAL80ETC concert",
                        "Conjured Mana Cake")
                .containsOnlyItemQualities(new Quality(0).getQuality(), new Quality(50).getQuality(), new Quality(0).getQuality(), new Quality(80).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality())
                .containsOnlyItemSellIns(new SellIn(-490).getSellIn(), new SellIn(-498).getSellIn(), new SellIn(-495).getSellIn(), new SellIn(0).getSellIn(), new SellIn(-485).getSellIn(), new SellIn(-497).getSellIn());
    }

    @Test
    public void backstage_pass_golden_copy() {
        items = aBunchOfBackstagePasses();
        repeatUpdateQuality(11);

        ItemsAssert.assertThat(items)
                .containsOnlyItemQualities(new Quality(30).getQuality(), new Quality(48).getQuality(), new Quality(45).getQuality(), new Quality(0).getQuality()
                        , new Quality(11).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(36).getQuality()
                        , new Quality(15).getQuality(), new Quality(33).getQuality(), new Quality(50).getQuality(), new Quality(50).getQuality(), new Quality(27).getQuality()
                        , new Quality(0).getQuality(), new Quality(26).getQuality(), new Quality(42).getQuality(), new Quality(50).getQuality(), new Quality(0).getQuality()
                        , new Quality(50).getQuality(), new Quality(50).getQuality(), new Quality(0).getQuality(), new Quality(29).getQuality(), new Quality(0).getQuality()
                        , new Quality(0).getQuality(), new Quality(36).getQuality(), new Quality(50).getQuality(), new Quality(41).getQuality(), new Quality(50).getQuality()
                        , new Quality(0).getQuality(), new Quality(49).getQuality(), new Quality(25).getQuality(), new Quality(0).getQuality(), new Quality(12).getQuality()
                        , new Quality(0).getQuality(), new Quality(50).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality()
                        , new Quality(43).getQuality(), new Quality(0).getQuality(), new Quality(50).getQuality(), new Quality(23).getQuality(), new Quality(27).getQuality()
                        , new Quality(33).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(37).getQuality(), new Quality(0).getQuality()
                        , new Quality(43).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(45).getQuality(), new Quality(50).getQuality()
                        , new Quality(22).getQuality(), new Quality(43).getQuality(), new Quality(0).getQuality(), new Quality(30).getQuality(), new Quality(14).getQuality()
                        , new Quality(44).getQuality(), new Quality(50).getQuality(), new Quality(0).getQuality(), new Quality(17).getQuality(), new Quality(0).getQuality()
                        , new Quality(17).getQuality(), new Quality(50).getQuality(), new Quality(16).getQuality(), new Quality(50).getQuality(), new Quality(19).getQuality()
                        , new Quality(44).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(37).getQuality(), new Quality(34).getQuality()
                        , new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(50).getQuality(), new Quality(0).getQuality()
                        , new Quality(29).getQuality(), new Quality(40).getQuality(), new Quality(50).getQuality(), new Quality(50).getQuality(), new Quality(47).getQuality()
                        , new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(47).getQuality(), new Quality(0).getQuality(), new Quality(26).getQuality()
                        , new Quality(11).getQuality(), new Quality(26).getQuality(), new Quality(16).getQuality(), new Quality(0).getQuality(), new Quality(50).getQuality()
                        , new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(0).getQuality(), new Quality(35).getQuality(), new Quality(0).getQuality()
                        , new Quality(50).getQuality())
                .containsOnlyItemSellIns(new SellIn(1).getSellIn(), new SellIn(18).getSellIn(), new SellIn(-7).getSellIn()
                        , new SellIn(6).getSellIn(), new SellIn(8).getSellIn(), new SellIn(16).getSellIn(), new SellIn(-8).getSellIn()
                        , new SellIn(6).getSellIn(), new SellIn(4).getSellIn(), new SellIn(-9).getSellIn(), new SellIn(4).getSellIn()
                        , new SellIn(-2).getSellIn(), new SellIn(-9).getSellIn(), new SellIn(8).getSellIn(), new SellIn(14).getSellIn()
                        , new SellIn(7).getSellIn(), new SellIn(9).getSellIn(), new SellIn(-9).getSellIn(), new SellIn(12).getSellIn()
                        , new SellIn(2).getSellIn(), new SellIn(-9).getSellIn(), new SellIn(12).getSellIn(), new SellIn(-7).getSellIn()
                        , new SellIn(5).getSellIn(), new SellIn(-6).getSellIn(), new SellIn(-1).getSellIn(), new SellIn(-11).getSellIn()
                        , new SellIn(2).getSellIn(), new SellIn(-4).getSellIn(), new SellIn(9).getSellIn(), new SellIn(4).getSellIn()
                        , new SellIn(15).getSellIn(), new SellIn(13).getSellIn(), new SellIn(-4).getSellIn(), new SellIn(-4).getSellIn()
                        , new SellIn(12).getSellIn(), new SellIn(-7).getSellIn(), new SellIn(9).getSellIn(), new SellIn(-4).getSellIn()
                        , new SellIn(-7).getSellIn(), new SellIn(4).getSellIn(), new SellIn(0).getSellIn(), new SellIn(11).getSellIn()
                        , new SellIn(6).getSellIn(), new SellIn(-8).getSellIn(), new SellIn(3).getSellIn(), new SellIn(17).getSellIn()
                        , new SellIn(12).getSellIn(), new SellIn(9).getSellIn(), new SellIn(-4).getSellIn(), new SellIn(13).getSellIn()
                        , new SellIn(-5).getSellIn(), new SellIn(10).getSellIn(), new SellIn(4).getSellIn(), new SellIn(14).getSellIn()
                        , new SellIn(6).getSellIn(), new SellIn(14).getSellIn(), new SellIn(1).getSellIn(), new SellIn(-5).getSellIn()
                        , new SellIn(-3).getSellIn(), new SellIn(15).getSellIn(), new SellIn(11).getSellIn(), new SellIn(-2).getSellIn()
                        , new SellIn(-6).getSellIn(), new SellIn(-2).getSellIn(), new SellIn(2).getSellIn(), new SellIn(-11).getSellIn()
                        , new SellIn(17).getSellIn(), new SellIn(10).getSellIn(), new SellIn(18).getSellIn(), new SellIn(2).getSellIn()
                        , new SellIn(14).getSellIn(), new SellIn(-8).getSellIn(), new SellIn(-5).getSellIn(), new SellIn(1).getSellIn()
                        , new SellIn(-1).getSellIn(), new SellIn(0).getSellIn(), new SellIn(14).getSellIn(), new SellIn(7).getSellIn()
                        , new SellIn(9).getSellIn(), new SellIn(-3).getSellIn(), new SellIn(2).getSellIn(), new SellIn(-9).getSellIn()
                        , new SellIn(-1).getSellIn(), new SellIn(-6).getSellIn(), new SellIn(5).getSellIn(), new SellIn(-5).getSellIn()
                        , new SellIn(8).getSellIn(), new SellIn(-5).getSellIn(), new SellIn(11).getSellIn(), new SellIn(3).getSellIn()
                        , new SellIn(17).getSellIn(), new SellIn(17).getSellIn(), new SellIn(13).getSellIn(), new SellIn(5).getSellIn()
                        , new SellIn(11).getSellIn(), new SellIn(16).getSellIn(), new SellIn(-3).getSellIn(), new SellIn(6).getSellIn()
                        , new SellIn(11).getSellIn());
    }

    private void repeatUpdateQuality(int times) {
        for (int i = 0; i < times; i++) {
            for(Item item: items){
                item.updateQuality();
            }
        }
    }

    private List<Item> aBunchOfBackstagePasses() {
        List<Item> listOfPasses = new ArrayList<Item>();
        for (int i = 0; i < 100; i++) {
            listOfPasses.add(aRandomBackstagePass());
        }
        return listOfPasses;
    }

    private SellIn randomSellIn() {
        return new SellIn(rand.nextInt(MAX_BACKSTAGE_SELLIN));
    }

    private Quality randomQuality() {
        return new Quality(rand.nextInt(MAX_QUALITY));
    }

    private Item aRandomBackstagePass() {
        Quality quality = randomQuality();
        SellIn sellIn = randomSellIn();
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
}