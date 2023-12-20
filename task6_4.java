package kr12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task6_4 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputEvenFileName = "output_even.txt";
        String outputOddFileName = "output_odd.txt";

        try {
            splitNumbers(inputFileName, outputEvenFileName, outputOddFileName);
            System.out.println("Розділення чисел на парні та непарні завершено. Результат записано у файли "
                    + outputEvenFileName + " та " + outputOddFileName);
        } catch (IOException e) {
            System.err.println("Помилка обробки файлів: " + e.getMessage());
        }
    }

    private static void splitNumbers(String inputFileName, String outputEvenFileName, String outputOddFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writerEven = new BufferedWriter(new FileWriter(outputEvenFileName));
             BufferedWriter writerOdd = new BufferedWriter(new FileWriter(outputOddFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);

                    if (number % 2 == 0) {
                        writerEven.write(Integer.toString(number));
                        writerEven.newLine();
                    } else {
                        writerOdd.write(Integer.toString(number));
                        writerOdd.newLine();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Помилка конвертації рядка до цілого числа: " + e.getMessage());
                }
            }
        }
    }
}