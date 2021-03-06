package Saver;

import pieces.Board;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Saver implements Serializable{

    public static void saveToFile(Board b,String file)
    {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(file)));
            outputStream.writeObject(b);
            outputStream.close();
        }catch (IOException e ){
            e.printStackTrace();
            System.out.println("error saving");
        }
    }

    public static Board getSaveFile(String file) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(file)));
            Board b = (Board) inputStream.readObject();
            inputStream.close();
            return b;
        } catch(Exception e) {
            System.out.println("no save file found");
            return null;
        }
    }

}
