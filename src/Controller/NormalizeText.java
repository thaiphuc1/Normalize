package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NormalizeText {
    
     public static String formatOneSpaceSpecial(String line, String character) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
        for (String oneWord : strings) {
            stringBuffer.append(oneWord + " " + character);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim().substring(0, stringBuffer.length() - 3);
    }

    
    public static String formatOneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, "\"");
        return line.trim();
    }

    
    public static String formatSpecialCharacters(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == ' '
                    && stringBuffer.charAt(i + 1) == '.'
                    || stringBuffer.charAt(i + 1) == ','
                    || stringBuffer.charAt(i + 1) == ':') {
                stringBuffer.deleteCharAt(i);
            }
        }
        return stringBuffer.toString().trim();
    }

    
    public static String upperAfterdot(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        int lengthLine = stringBuffer.length();
        for (int i = 0; i < lengthLine - 2; i++) {
            if (stringBuffer.charAt(i) == '.') {
                char afterDot = stringBuffer.charAt(i + 2);
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(afterDot));
            }
        }
        return stringBuffer.toString().trim();
    }

   
    static int countQuetes = 0;

    public static String noSpace(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 1
                    && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuffer.toString().trim();
    }

    
    public static String upperfirstCha(String line) {
        line = line.substring(0);
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuffer.toString().trim();
    }

    
    public static String addLastdot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

   
    public static boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    
}


