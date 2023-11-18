package edu.umsl;

public class Sloth extends Animal {
    @Override
    public String toString() {
        String animal = "Sloth";
        return "- " + animal + " " + eatFood() + " " + modeOfReproduction();
    }
}
