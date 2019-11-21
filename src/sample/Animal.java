package sample;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class Animal implements ICarable, Serializable {
    protected int dateOfBirth;
    protected float timeTolive;
    protected float adultAge;
    protected String name;

    protected ArrayList<String> food;

    protected int actualHunger;
    protected int cageID;


    private final String spicieInformation = "fauna"; //type of animal


    public Animal(int dateOfBirth, float timeTolive, float adultAge, String name, ArrayList<String> food) {

        this.dateOfBirth = dateOfBirth;
        this.timeTolive = timeTolive;
        this.adultAge = adultAge;
        this.name = name;
        this.food = new ArrayList<String>(food);//does not work
    }

    public void feed(int ammout, String foodName) {

        for ( String s: this.food    ) {
            if (s.equals(foodName)) {
                actualHunger += actualHunger+ ammout * 2;
                break;
            }

        }
        /*if (food.contains(foodName)){
            System.out.println("najedl se ");
            actualHunger *= ammout/2;
        }
        System.out.println("NENAJEDL SE");
        */
    }

    public void setCageID(int cageID) {
        this.cageID = cageID;
    }

    public int getCageID() {
        return this.cageID;
    }


    public boolean isAlive(int actualDate) {
        return (this.calculateAge(actualDate) <= this.timeTolive) && (this.actualHunger > 0);
    }


    public boolean isAdult(float age) {
        return this.dateOfBirth >= this.adultAge;
    }

    public int calculateAge(int actualDate) {
        return actualDate - this.dateOfBirth;
    }

    public String getSpicieInformation() {
        return spicieInformation;
    }


    @Override
    public String toString() {
        return "AnimalAbs{" +
                "dateOfBirth=" + dateOfBirth +
                ", timeTolive=" + timeTolive +
                ", adultAge=" + adultAge +
                ", name='" + name +

                ", food=" + food +
                ", actualHunger=" + actualHunger +
                ", cageID='" + cageID +

                ", spicieInformation='" + spicieInformation + '\'';
    }
    public  String toStringTOTextField() {
        return
                "jméno: " + name + "\n" +
                "datum narozeni: " + dateOfBirth +"\n" +
                "čas do smrti: "   + timeTolive +"\n" +
                "dospělý věk: " + adultAge +"\n" +

                "dieta:" + food +"\n" +
                "nasycenost:" + actualHunger +"\n" +
                "číslo klece: " + (cageID +1) +"\n" +
                        "rod a druh: "  + spicieInformation + '\'';
    }

    public String getName() {
        return this.name;
    }


}