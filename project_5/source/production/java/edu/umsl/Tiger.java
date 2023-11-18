package edu.umsl;

public class Tiger extends Animal {
    @Override
    public String toString() {
         String animal = "Tiger";
         return "- " + animal + " " + eatFood() + " " + modeOfReproduction();
    }
}
