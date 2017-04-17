package org.joyofcoding.objectcalisthenics;

import java.util.List;

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
        firstQualityCheck();
        secondQualityCheck();
        thirdQualityCheck();
    }

    private void firstQualityCheck() {
        if (!equalsItemName("Aged Brie")
                && !equalsItemName("Backstage passes to a TAFKAL80ETC concert")) {
            if (!equalsItemName("Sulfuras, Hand of Ragnaros")) {
                if (quality.greaterThen(0)) {
                    quality.minusQuality(1);
                }
            }
        } else {
            if (quality.lessThen(50)) {
                quality.addQuality(1);

                if (equalsItemName("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellIn.lessThen(11)) {
                        if (quality.lessThen(50)) {
                            quality.addQuality(1);
                        }
                    }

                    if (sellIn.lessThen(6)) {
                        if (quality.lessThen(50)) {
                            quality.addQuality(1);
                        }
                    }
                }
            }
        }
    }

    private void secondQualityCheck() {
        if (!equalsItemName("Sulfuras, Hand of Ragnaros")) {
            sellIn.minusSellIn(1);
        }
    }

    private void thirdQualityCheck() {
        if (sellIn.lessThen(0)) {
            if (quality.greaterThen(0)) {
                if (!equalsItemName("Aged Brie")) {
                    if (!equalsItemName("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!equalsItemName("Sulfuras, Hand of Ragnaros")) {
                            quality.minusQuality(1);
                        }
                    } else {
                        quality.minusQuality(
                                quality.getQuality());
                    }
                } else {
                    if (quality.lessThen(50)) {
                        quality.addQuality(1);
                    }
                }
            }
        }
    }

    public boolean equalsItemName(String inputToCompare){
        return itemName.equals(inputToCompare);
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
