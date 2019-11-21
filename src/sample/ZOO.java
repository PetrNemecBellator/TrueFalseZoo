package sample;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class ZOO implements Serializable {
    private ArrayList<Cage> allCages = new ArrayList<>();

    public void addCage() {
        allCages.add(new Cage());
    }

    private void addAnimal(int cage, Animal animal) {
        System.out.println(allCages.size() == 0);
        if (allCages.size() == 0) addCage();

        allCages.get(cage - 1).addAnimal(animal);

        System.out.print("je to spojeno ???/ " + ((Tyger) animal).toString());
        System.out.print("Vklaci 0 je tigetr" + allCages.get(cage - 1).getAnimal(animal.getName()));

    }

    public void createTiger(int cage, int dateOfBirth, float timeTolive, float adultAge, String name, int stripeNumber, ArrayList<String> food) {
        addAnimal(cage, (Animal) new Tyger(dateOfBirth, timeTolive, adultAge, name, stripeNumber, food));

    }


    private Animal createAnimal(String option) {
        switch (option) {
            case "Tygr":
                ArrayList<String> food = new ArrayList<String>();
                food.add("maso");
                Tyger t = new Tyger(2000, 10, 0, "Tyger", 3, food);
                System.out.println("Tygr muze byt vytvoren " + t);
                return t;
        }

        ArrayList<String> food = new ArrayList<String>();
        food.add("maso");
        return new Tyger(2000, 10, 0, "Tyger", 3, food);

    }

    //pripraveno na ukladani dat
    public ArrayList<Animal> getListOfAnimals(int cageNumber) {
        System.out.println("getovani objektu " + allCages.get(cageNumber).getListOfAnimals().toString());
        return allCages.get(cageNumber).getListOfAnimals();
    }

    public Animal getAnimalFromCage(String name, int cageId) {
        return allCages.get(cageId - 1).getAnimal(name);
    }

    public void saveToFIle(String fileName, ZOO zoo) {
        //serialize to file
        try {
            SerializationUtil.serialize(zoo.getListOfAnimals(0), fileName);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        loadFromFile(fileName, zoo);
        //deserialize from file

    }

    public void loadFromFile(String fileName, ZOO zoo) {
        System.out.println("***********************");
        System.out.println("LOAD");

        ArrayList<Animal> savedAnimals = null;
            // ndsgkldhgkjhgkjfdhgksjlfhgkjdfhgkjfhlkfj
            try {
                savedAnimals = SerializationUtil.deserialize(fileName);
                System.out.println(savedAnimals); //jeste ok
                System.out.println(this.allCages);

              //  this.allCages.get(0).setAnimalsB(savedAnimals);  //add(new ArrayList<Animal>(savedAnimals) );

                //System.out.println(this.allCages.get(0).animals.toString());
                System.out.println(savedAnimals);

            } catch (ClassNotFoundException | IOException e) {
                System.out.println(" load Exeption handled");
                e.printStackTrace();
            }
    }
}
