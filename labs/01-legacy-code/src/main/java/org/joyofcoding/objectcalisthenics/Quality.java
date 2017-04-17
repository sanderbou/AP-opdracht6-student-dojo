package org.joyofcoding.objectcalisthenics;

public class Quality {
    private int quality;

    public Quality(int qualityConstructor){
        quality = qualityConstructor;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality){
        this.quality = quality;
    }

    public void addQuality(int qualityToAdd){
        quality = quality + qualityToAdd;
    }

    public void minusQuality(int qualityToMinus){
        quality = quality - qualityToMinus;
    }
}