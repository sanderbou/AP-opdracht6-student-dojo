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
        firstQualityUpdate();
        secondQualityUpdate();
        thirdQualityUpdate();
    }

    private void firstQualityUpdate() {
        if (equalsItemName("Aged Brie")
                || equalsItemName("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality.lessThen(50)) {
                quality.addQuality(1);

                if (equalsItemName("Backstage passes to a TAFKAL80ETC concert")) {
                    addQualityOnSellIn();
                }
            }
        } else {
            if (!equalsItemName("Sulfuras, Hand of Ragnaros")) {
                if (quality.greaterThen(0)) {
                    quality.minusQuality(1);
                }
            }
        }
    }

    private void secondQualityUpdate() {
        if (!equalsItemName("Sulfuras, Hand of Ragnaros")) {
            sellIn.minusSellIn(1);
        }
    }

    private void thirdQualityUpdate() {
        if (sellIn.lessThen(0)) {
            if (quality.greaterThen(0)
                    && quality.lessThen(50)) {
                quality.addQuality(1);
                minusQualityOnItemName();
            }
        }
    }

    public boolean equalsItemName(String inputToCompare){
        return itemName.equals(inputToCompare);
    }

    private void addQualityOnSellIn() {
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

    private void minusQualityOnItemName() {
        if (!equalsItemName("Aged Brie")) {
            quality.minusQuality(1);

            if (!equalsItemName("Backstage passes to a TAFKAL80ETC concert")) {
                if (!equalsItemName("Sulfuras, Hand of Ragnaros")) {
                    quality.minusQuality(1);
                }
            } else {
                quality.minusQuality(
                        quality.getQuality());
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
