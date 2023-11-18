package edu.umsl;

public class Sunflower extends Plant {
    @Override
    public String toString() {
        String plant = "Sunflower";
        return "- " + plant + " " + eatFood() + " " + modeOfReproduction();
    }
}
