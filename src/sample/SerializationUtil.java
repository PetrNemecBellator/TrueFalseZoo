package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class SerializationUtil {
    // serialize the given object and save it to file
    public static void serialize(ArrayList<Animal> obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Object o : obj) {
            System.out.println("saving animal " + o.toString() + " to file " + fileName);
            oos.writeObject(o);
        } ////////// etadz se atoaa serialsizujee
        fos.close();
    }

    // deserialize to Object from given file
    public static ArrayList<Animal> deserialize(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<Animal> obj = new ArrayList<Animal>(  );
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = null;

//(boolean) Objects.requireNonNull(o = ois.readObject() ) == true ){
       try {
           while(true) {
               o = ois.readObject();
               System.out.println(o.getClass().toString());
               obj.add((Animal) o);
           }
       }catch (EOFException e){
           fis.close();

       }


        return obj;
    }
}
