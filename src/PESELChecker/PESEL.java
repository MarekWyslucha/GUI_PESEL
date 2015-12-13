package PESELChecker;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Marek Wysłucha
 */
public class PESEL {
    int[] pesel = new int[11];
    
    private PESEL(int[] PESEL){
        pesel = PESEL.clone();
    }
    
    public PESEL(String PESEL){
        pesel = getPESELFromString(PESEL);
    }
    
    public static void checkPESEL(String PESEL){
        if(isLengthCorrect(PESEL) && isCorrect(getPESELFromString(PESEL))){
            printSuccessMessage();
            PESEL psl = new PESEL(getPESELFromString(PESEL));
            PESELContainer.addPESEL(psl);
        }
        else
            printFailureMessage();
    }
    
    private static boolean isLengthCorrect(String PESEL){
        return (PESEL.length()==11);
    }
    
    private static void printFailureMessage(){
        printMessage("PESEL jest niepoprawny.");
    }
    
    private static void printSuccessMessage(){
        printMessage("PESEL jest poprawny.");
    }
    
    private static void printMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    private static int[] getPESELFromString(String PESEL){
        int[] psl = new int[11];
        
        for(int i=0; i<11; i++)
            psl[i] = Integer.parseInt(PESEL.charAt(i)+"");
        
        return psl;
    }
    
    private static boolean isCorrect(int[] PESEL){
        int sum = 0;
        int[] positionWeight = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
        
        for(int i=0; i<11; i++){
            sum += positionWeight[i] * PESEL[i];
            sum %= 10;
        }
        
        return (sum == 0);
    }
    
    @Override
    public String toString(){
        String psl = "";
        for(int i=0; i<11; i++)
            psl += pesel[i] + "";
        return psl;
    }
}
