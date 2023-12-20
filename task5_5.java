package kr12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task5_5 {
    public static void main(String[] args) {
        String filePath = "test.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String longestLine = "";
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.length() > longestLine.length()) {
                    longestLine = currentLine;
                }
            }

            System.out.println("Найдовший рядок: " + longestLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
