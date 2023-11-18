package edu.umsl;

public class Rose extends Plant {
    @Override
    public String toString() {
        String plant = "Rose";
        return "- " + plant + " " + eatFood() + " " + modeOfReproduction();
    }
}
