package sample;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;

public class Controller {

    @FXML
    private Pane animalINput;
    @FXML
    private TextField timeTolive;
    @FXML
    private TextField adultAge;
    @FXML
    private TextField stripeNumber;
    @FXML
    private TextArea food;
    @FXML
    private TextField dateOfBirth;
    @FXML
    private ChoiceBox<String> comboBoxTyger;
    @FXML
    private Pane tygrInput;
    @FXML
    private Pane animalOutput;
    @FXML
    private TextField tigerName;
    //** animal output **//
    @FXML
    private ChoiceBox CHoseBoxCageNumber;
    @FXML
    private TextField textFNameOfAnimal;
    @FXML
    private String actulaAnimalType;
    @FXML
    private TextArea textAreaOutPut;
    @FXML
    private Pane tygerFuctions;
    @FXML
    private TextField TFfoodAndAmointOfIt;

    private   ZOO zoo;

    private String defaultFileName = "data.txt";
    private Animal serchedAnimal;

    public void initialize() {
        setScreenToAnimalInput(true);
        comboBoxTyger.getItems().add("Vyber zvire");
        comboBoxTyger.setValue("Vyber zvire");
        comboBoxTyger.getItems().add("Tygr");
        comboBoxTyger.getItems().addAll( "Raven", "Ant");

        zoo = new ZOO();
        loadFromFile(defaultFileName,zoo);

        for (int i = 1 ; i < 10; i++)  CHoseBoxCageNumber.getItems().add(""+ i );

        comboBoxTyger.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                selectionOfAnimalInput(comboBoxTyger.getItems().get(new_value.intValue()));
                actulaAnimalType = comboBoxTyger.getItems().get(new_value.intValue());

            }
        });
    }

    public void saveToFIle(String fileName, ZOO zoo ){
        zoo.saveToFIle(fileName,zoo);
    }

    public void loadFromFile(String fileName, ZOO zoo){
        zoo.loadFromFile(fileName,zoo);
    }

    @FXML
    private void setScreenToAnimlOutPut(){
        setScreenToAnimlOutPut(true);
    }

    private void setScreenToAnimlOutPut(boolean enabledOrDisabled){
        setScreenToAnimalInput(!enabledOrDisabled);
        System.out.println("set to output is set to: " + enabledOrDisabled);

        animalOutput.setDisable(!enabledOrDisabled);
        animalOutput.setVisible(enabledOrDisabled);
    }
    @FXML
    private void onActionAddButton(ActionEvent event){
        System.out.println("ADDanimal tlacitko click \n aktulani zvire" + actulaAnimalType);
        addAnimalReaction(actulaAnimalType);

        System.out.println("ukladani objektu");
        saveToFIle("data.txt",zoo);
        //add save load
    }

    public void addAnimalReaction(String typeOfAnimal){

        switch (typeOfAnimal){
            case "Tygr":

                ArrayList<String> foodArray = new ArrayList<String>( Arrays.asList(food.getText().split(", ")));
                zoo.createTiger(1, Integer.parseInt(dateOfBirth.getText()),Float.parseFloat(timeTolive.getText()),Float.parseFloat(adultAge.getText())
                        ,tigerName.getText(),Integer.parseInt(stripeNumber.getText()), new ArrayList<String>(foodArray) );
              //createTiger(int cage,int dateOfBirth, float timeTolive, float adultAge, String name, int stripeNumber,new food)

                break;
            case "Raven":
                System.out.println("neexistuje");
                break;


        }
    }

    public void selectionOfAnimalInput(String typeOfAnimal){
        switch (typeOfAnimal){
            case "Tygr":
                tygrInput.setVisible(true);
                tygrInput.setDisable(false);
                break;
            case "Raven":
                System.out.println("neexistuje");
                break;


        }
    }

    public void  setScreenToAnimalInput(boolean enableOrDisabled){
       System.out.println("animal input screen is set to: " + enableOrDisabled);
        animalINput.setVisible(enableOrDisabled);
        animalINput.setDisable(!enableOrDisabled);

    }

    @FXML
    private void findAnimal(){
        int cageNubmber =Integer.parseInt( CHoseBoxCageNumber.getValue().toString());
        String animal = textFNameOfAnimal.getText();
        System.out.println("hledam zvire animal " + animal + "v kleci " + cageNubmber);
        Animal animalFound = zoo.getAnimalFromCage(animal, cageNubmber);
        System.out.println(animalFound.getClass());

        serchedAnimal= animalFound;

        if ( animalFound instanceof  Tyger){
            Tyger t = (Tyger) animalFound;
            textFieldOutput(t.toStringTOTextField());
            tygetFunction(true);
        }//

        System.out.println("animal " +animalFound.toString());

    }
    private void textFieldOutput(String text){
        textAreaOutPut.setText(text);

    }

    @FXML
    private void returnToInsertion(){
        setScreenToAnimalInput(true);
        setScreenToAnimlOutPut(false);
    }
    private void tygetFunction(boolean b){
        System.out.println("tygerFunctions set to " + b);
        tygerFuctions.setVisible(b);
        tygerFuctions.setDisable(!b);
    }

    @FXML
    public void interactButtonF(){
        System.out.println("button interaction");
        String text [] = TFfoodAndAmointOfIt.getText().split(" ");
        System.out.println("jmeno " + serchedAnimal.name +" kolik " + text[0] + " jidlo " + text[1]);
        serchedAnimal.feed(Integer.parseInt(text[0]) , text[1]);
        textFieldOutput("");//serchedAnimal.toStringTOTextField()
        textFieldOutput(serchedAnimal.toStringTOTextField());

    }

}
