package org.joyofcoding.objectcalisthenics;

public class Item {
    private String itemName;
    private SellIn sellIn;
    private Quality quality;

    public Item(String itemName, SellIn sellIn, Quality quality) {
        this.itemName = itemName;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public void updateQuality() {
        if (!itemName.equals("Aged Brie")
                && !itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                if (quality.getQuality() > 0) {
                    quality.minusQuality(1);
                }
            }
        } else {
            if (quality.getQuality() < 50) {
                quality.addQuality(1);

                if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellIn.getSellIn() < 11) {
                        if (quality.getQuality() < 50) {
                            quality.addQuality(1);
                        }
                    }

                    if (sellIn.getSellIn() < 6) {
                        if (quality.getQuality() < 50) {
                            quality.addQuality(1);
                        }
                    }
                }
            }
        }

        if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn.minusSellIn(1);
        }

        if (sellIn.getSellIn() < 0) {
            if (!itemName.equals("Aged Brie")) {
                if (!itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (quality.getQuality() > 0) {
                        if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                            quality.minusQuality(1);
                        }
                    }
                } else {
                    quality.minusQuality(
                            quality.getQuality());
                }
            } else {
                if (quality.getQuality() < 50) {
                    quality.addQuality(1);
                }
            }
        }
    }

    public String getName() {
        return itemName;
    }

    public int getQuality() {
        return quality.getQuality();
    }

    public int getSellIn() {
        return sellIn.getSellIn();
    }
}
