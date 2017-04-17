package org.joyofcoding.objectcalisthenics;

/**
 * Created by Sander on 17-4-2017.
 */
public class SellIn {
    private int sellIn;

    public SellIn(int sellInConstructor){
        sellIn = sellInConstructor;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void minusSellIn(int sellInToMinus){
        sellIn = sellIn - sellInToMinus;
    }

}
