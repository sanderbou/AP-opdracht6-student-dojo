package org.joyofcoding.objectcalisthenics;

public class Item {
    private String name;
    private int sellIn;
    private Quality quality;

    public Item(String name, int sellIn, Quality quality) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public void updateQuality() {
        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality.getQuality() > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    quality.addQuality(1);
                }
            }
        } else {
            if (quality.getQuality() < 50) {
                quality.addQuality(1);

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellIn < 11) {
                        if (quality.getQuality() < 50) {
                            quality.addQuality(1);
                        }
                    }

                    if (sellIn < 6) {
                        if (quality.getQuality() < 50) {
                            quality.addQuality(1);
                        }
                    }
                }
            }
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (quality.getQuality() > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
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
        return name;
    }

    public Quality getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }
}
