package org.joyofcoding.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    public static void main(String[] args) {
        GildedRose gildedRose = new GildedRose();
        List<Item> items = makeItems();

        for(Item item : items){
            item.updateQuality();
        }
    }

    public static List<Item> makeItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, new Quality(20)));
        items.add(new Item("Aged Brie", 2, new Quality(0)));
        items.add(new Item("Elixir of the Mongoose", 5, new Quality(7)));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, new Quality(80)));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, new Quality(20)));
        items.add(new Item("Conjured Mana Cake", 3, new Quality(6)));
        return items;
    }
}