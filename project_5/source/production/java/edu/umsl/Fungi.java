package edu.umsl;

public class Fungi extends creature implements Reproduction {
    // Your Fungi class must override the function eatFood and return "external digestion with hyphae"
    @Override
    String eatFood() {
        return "external digestion with hyphae";
    }
    public String modeOfReproduction() {
        return "Spores";
    }
}
