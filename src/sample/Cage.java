package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
//trida ve ktere jsou jsou ulozeny jednotlive druhy zvirat
public class Cage {
    ArrayList<Animal> animals = new ArrayList<>();
    private int lastID = 0;

    //rozemr
    public Cage(){

    }

    public void setAnimals(ArrayList<Animal> animals){
        lastID = 0;
        for(int i =0; i < animals.size(); i++ ){
            this.lastID++;
            animals.get(i).setCageID(i);
        }

        this.animals = animals;
    }


    public void setAnimalsB (ArrayList<Animal> list){
        this.animals = list;
    }

    public Animal getAnimal(String name){
        System.out.println("getAnimal ");

        for (int i=0 ; i < this.animals.size() ; i++){
            System.out.println("cyslus getovani zvyrete " + i );
            System.out.println(animals.get(i).name.toString() );
            System.out.println("zvire " + animals.get(i).toString() + "name of animal " + animals.get(i).name.toString() );
            if (animals.get(i).getName().equals(name) ){
                System.out.println("name geted");
                return animals.get(i);
            }
        }
        return null;
    }
    public void addAnimal(Animal animal) {

        this.animals.add(animal);
        lastID++;
    }
    public void getAllAnimalsOfType(){

    }
    public ArrayList<Animal> getListOfAnimals(){
        return this.animals;
    }

    @Override
    public String toString() {
        String result ="";
        for(Animal animal :animals ){
            result += "\n " + animal.toString();
        }
        return result;
    }
}
