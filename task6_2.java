package kr12;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task6_2 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            double product = calculateProductOfNonZeroModuloFromFile(inputFileName);
            writeProductToFile(outputFileName, product);
            System.out.println("Добуток модулів ненульових елементів записано у файл " + outputFileName);
        } catch (IOException e) {
            System.err.println("Помилка обробки файлів: " + e.getMessage());
        }
    }

    private static double calculateProductOfNonZeroModuloFromFile(String fileName) throws IOException {
        double product = 1.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    double number = Double.parseDouble(line);

                    if (number != 0) {
                        product *= Math.abs(number);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Помилка конвертації рядка до дійсного числа: " + e.getMessage());
                }
            }
        }

        return product;
    }

    private static void writeProductToFile(String fileName, double product) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Добуток модулів ненульових елементів: " + product);
        }
    }
}