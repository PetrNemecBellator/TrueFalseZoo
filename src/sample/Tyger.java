package sample;
import java.util.ArrayList;

public class Tyger extends Animal{

    private int stripeNumber;


    private String spicie = "predator";



    public  Tyger(int dateOfBirth, float timeTolive, float adultAge, String name, int stripeNumber,ArrayList<String> food) {
        super(dateOfBirth, timeTolive, adultAge, name, food);
        this.stripeNumber = stripeNumber;

    }

    @Override
    public String getSpicieInformation() {
        return super.getSpicieInformation() + " " + this.spicie;
    }

    public boolean isSaveToGoHere()
        //based on actual hunger in combination with some random number it tels us if its save to feed or interact with tyger
            throws Exception {
        new Exception("not impelemeted");
        return false;
        //random change to git testdasfdasfdas
    }
    @Override
    public String toString() {
        return super.toString() + " tyger " +"spicie= "+ this.spicie + " druh = " + this.getSpicieInformation()+"}";
    }
    @Override
    public String toStringTOTextField(){
       return  super.toStringTOTextField() + "\n" +getSpicieInformation()
                + "\n pocet pruhů " + this.stripeNumber;
    }
}

