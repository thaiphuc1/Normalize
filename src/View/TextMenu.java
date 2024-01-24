
package View;


import Model.Text;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Controller.NormalizeText;
import java.util.Scanner;
public class TextMenu {
   
    private Text text;
    
    
    
    public void normalize(){
        BufferedReader br = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name file want read : "); String inName = sc.next();
        System.out.println("Enter name file want wrire : "); String outName = sc.next();
        try {
            
            br = new BufferedReader(new FileReader(new File(inName)));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outName, true)));
            String line;
             while ((line = br.readLine()) != null) {
                if (NormalizeText.isLineEmpty(line)) {
                    continue;
                }
                line = NormalizeText.formatOneSpace(line);
                line = NormalizeText.formatSpecialCharacters(line);
                line = NormalizeText.upperAfterdot(line);
                line = NormalizeText.noSpace(line);
                line = NormalizeText.upperfirstCha(line);
                line = NormalizeText.addLastdot(line);
                pw.print(line);
                
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Successful.");
    }
}
