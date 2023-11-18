package edu.umsl;

public class Plant extends creature implements Reproduction {
    // Your Plant class must override the function eat food and return "sunlight (aka photosynthesis)"
    @Override
    String eatFood() {
        return "sunlight";
    }
    public String modeOfReproduction() {
        return "Seeds";
    }
}
