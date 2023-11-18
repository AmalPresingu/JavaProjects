package edu.umsl;

public class Animal extends creature implements Reproduction {
    // Your Animal class must override the function eatFood and return "ingestion"
    @Override
    String eatFood() {
        return "ingestion";
    }
    public String modeOfReproduction() {
        return "Sexual Reproduction";
    }
}
