package PESELChecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Marek Wysłucha
 */
public class PESELContainer {
    private static ArrayList<PESEL> peselContainer = new ArrayList<>();
    
    public static void addPESEL(PESEL pesel){
        peselContainer.clear();
        readFromFile();
        peselContainer.add(pesel);
        writeToFile();
    }
    
    private static void readFromFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\PESEL.txt"));
            String pesel;

            while ((pesel = br.readLine()) != null) {
                peselContainer.add(new PESEL(pesel));
            }
            br.close();
        } catch (IOException ex) {
        }
    }
    
    private static void writeToFile(){
        try{
            FileWriter fileWriter = new FileWriter(new File(System.getProperty("user.dir") + "\\PESEL.txt"));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String lineSeparator = System.getProperty("line.separator");
            
            for(PESEL pesel:peselContainer)
                printWriter.write(pesel.toString() + lineSeparator);
            
            printWriter.close();
        }
        catch(IOException e){
        }
    }
}
