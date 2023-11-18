package edu.umsl;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Taxonomy Classes");
        System.out.println("----------------");

        //placing all types into sets
        List<Animal> aList = new ArrayList<>();
        List<Plant> pList = new ArrayList<>();
        List<Fungi> fList = new ArrayList<>();

        //adding all extended classes into lists
        aList.add(new Tiger());
        aList.add(new Sloth());
        pList.add(new Rose());
        pList.add(new Sunflower());
        fList.add(new Geoglossomycete());
        fList.add(new Kickxellomycotina());

        //printing out lists
        System.out.println("Animals: \n");
        for (Animal animal : aList) {
            System.out.println(animal.toString() + "\n");
        }
        System.out.println("Plants: \n");
        for (Plant plant : pList) {
            System.out.println(plant.toString() + "\n");
        }
        System.out.println("Fungi: \n");
        for (Fungi fungi : fList) {
            System.out.println(fungi.toString() + "\n");
        }
    }
}
