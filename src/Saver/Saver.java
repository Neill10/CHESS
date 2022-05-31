package Saver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
    private File file;
    private FileWriter myWriter;
    private FileReader fr;

    public Saver(String fileName)
    {
        file = new File(fileName);
        try{
            file.createNewFile();
        }catch (IOException e ){
            System.out.println(fileName + " cannot be found.");
        }
    }


    public void writeToFile()
    {
        System.out.println("writeToFile ran");
        try {
            myWriter = new FileWriter(file);
            myWriter.write("piece moved\n");
            myWriter.close();
        }catch (IOException e ){
            System.out.println("error saving move");
        }
    }

    @Override
    public String toString() {
        return "Saver{" +
                "file=" + file +
                ", myWriter=" + myWriter +
                ", fr=" + fr +
                '}';
    }
}
