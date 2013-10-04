package lmvz;

import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 10/2/13
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class Data {

    public static void writeData(ArrayList<Country> list){
        try{
        FileOutputStream fos = new FileOutputStream("countries.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Country> readData(){
        try{
        FileInputStream fis = new FileInputStream("countries.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Country> list = (ArrayList<Country>) ois.readObject();
        ois.close();
        return list;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

class CountryList<Country> extends ArrayList implements Serializable{}
