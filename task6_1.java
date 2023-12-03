package kr12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task6_1 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            double sum = calculateSumFromFile(inputFileName);
            writeSumToFile(outputFileName, sum);
            System.out.println("Сума дійсних значень записана у файл " + outputFileName);
        } catch (IOException e) {
            System.err.println("Помилка обробки файлів: " + e.getMessage());
        }
    }

    private static double calculateSumFromFile(String fileName) throws IOException {
        double sum = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    double number = Double.parseDouble(line);
                    sum += number;
                } catch (NumberFormatException e) {
                    System.err.println("Помилка конвертації рядка до дійсного числа: " + e.getMessage());
                }
            }
        }

        return sum;
    }

    private static void writeSumToFile(String fileName, double sum) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Сума дійсних значень: " + sum);
        }
    }
}