/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaip
 */
public class Text {
    private String text;

    public Text() {
        
    }
    
    public Text(String fPath){
        loadData(fPath);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public void loadData(String fName){
        text = "";
        BufferedReader sc;
        try {
            sc = new BufferedReader(new FileReader(fName));
            String s=null;
            while((s=sc.readLine())!=null){
                text+=s+"\n";
            }
            sc.close();
        } catch (Exception ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveData(String fName){
        try {
            PrintWriter pw= new PrintWriter(new FileWriter(fName));
            pw.print(text);
            pw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
