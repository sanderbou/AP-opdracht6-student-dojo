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
                .containsOnlyItemQualities(new Quality(19), new Quality(1), new Quality(6), new Quality(80)
                        , new Quality(21), new Quality(5))
                .containsOnlyItemSellIns(9, 1, 4, 0, 14, 2);
    }

    @Test
    public void after_one_day_with_sufuras_having_sellIn_lesser_than_zero_and_quality_greater_than_zero() {
        items = new ArrayList<Item>();
        items.add(new Item("Sulfuras, Hand of Ragnaros", -1, new Quality(1)));
        repeatUpdateQuality(1);

        ItemsAssert.assertThat(items)
                .containsOnlyItemNames("Sulfuras, Hand of Ragnaros")
                .containsOnlyItemQualities(new Quality(1))
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
                .containsOnlyItemQualities(new Quality(17), new Quality(4), new Quality(4), new Quality(80), new Quality(23), new Quality(3))
                .containsOnlyItemSellIns(7, -1, 2, 0, 12, 0);
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
                .containsOnlyItemQualities(new Quality(0), new Quality(50), new Quality(0), new Quality(80), new Quality(0), new Quality(0))
                .containsOnlyItemSellIns(-490, -498, -495, 0, -485, -497);
    }

    @Test
    public void backstage_pass_golden_copy() {
        items = aBunchOfBackstagePasses();
        repeatUpdateQuality(11);

        ItemsAssert.assertThat(items)
                .containsOnlyItemQualities(new Quality(30), new Quality(48), new Quality(45), new Quality(0)
                        , new Quality(11), new Quality(0), new Quality(0), new Quality(0), new Quality(36)
                        , new Quality(15), new Quality(33), new Quality(50), new Quality(50), new Quality(27)
                        , new Quality(0), new Quality(26), new Quality(42), new Quality(50), new Quality(0)
                        , new Quality(50), new Quality(50), new Quality(0), new Quality(29), new Quality(0)
                        , new Quality(0), new Quality(36), new Quality(50), new Quality(41), new Quality(50)
                        , new Quality(0), new Quality(49), new Quality(25), new Quality(0), new Quality(12)
                        , new Quality(0), new Quality(50), new Quality(0), new Quality(0), new Quality(0)
                        , new Quality(43), new Quality(0), new Quality(50), new Quality(23), new Quality(27)
                        , new Quality(33), new Quality(0), new Quality(0), new Quality(37), new Quality(0)
                        , new Quality(43), new Quality(0), new Quality(0), new Quality(45), new Quality(50)
                        , new Quality(22), new Quality(43), new Quality(0), new Quality(30), new Quality(14)
                        , new Quality(44), new Quality(50), new Quality(0), new Quality(17), new Quality(0)
                        , new Quality(17), new Quality(50), new Quality(16), new Quality(50), new Quality(19)
                        , new Quality(44), new Quality(0), new Quality(0), new Quality(37), new Quality(34)
                        , new Quality(0), new Quality(0), new Quality(0), new Quality(50), new Quality(0)
                        , new Quality(29), new Quality(40), new Quality(50), new Quality(50), new Quality(47)
                        , new Quality(0), new Quality(0), new Quality(47), new Quality(0), new Quality(26)
                        , new Quality(11), new Quality(26), new Quality(16), new Quality(0), new Quality(50)
                        , new Quality(0), new Quality(0), new Quality(0), new Quality(35), new Quality(0)
                        , new Quality(50))
                .containsOnlyItemSellIns(1, 18, -7, 6, 8, 16, -8, 6, 4, -9, 4, -2, -9, 8, 14, 7, 9, -9, 12, 2, -9, 12, -7, 5, -6, -1, -11, 2, -4, 9,
                        4, 15, 13, -4, -4, 12, -7, 9, -4, -7, 4, 0, 11, 6, -8, 3, 17, 12, 9, -4, 13, -5, 10, 4, 14, 6, 14, 1, -5, -3, 15, 11, -2, -6, -2, 2,
                        -11, 17, 10, 18, 2, 14, -8, -5, 1, -1, 0, 14, 7, 9, -3, 2, -9, -1, -6, 5, -5, 8, -5, 11, 3, 17, 17, 13, 5, 11, 16, -3, 6, 11);
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

    private int randomSellIn() {
        return rand.nextInt(MAX_BACKSTAGE_SELLIN);
    }

    private Quality randomQuality() {
        return new Quality(rand.nextInt(MAX_QUALITY));
    }

    private Item aRandomBackstagePass() {
        Quality quality = randomQuality();
        int sellIn = randomSellIn();
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
}
