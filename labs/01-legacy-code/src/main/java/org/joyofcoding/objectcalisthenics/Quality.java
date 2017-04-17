package org.joyofcoding.objectcalisthenics;

public class Quality {
    private int quality;

    public Quality(int qualityConstructor){
        quality = qualityConstructor;
    }

    public void addQuality(int qualityToAdd){
        quality = quality + qualityToAdd;
    }

    public void minusQuality(int qualityToMinus){
        quality = quality - qualityToMinus;
    }

    public boolean lessThen(int lessThen){
        if(quality < lessThen){
            return true;
        }
        return false;
    }

    public boolean greaterThen(int greaterThen){
        if(quality > greaterThen){
            return true;
        }
        return false;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality){
        this.quality = quality;
    }
}