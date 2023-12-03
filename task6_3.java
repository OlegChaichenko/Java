package kr12;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task6_3{
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            long product = calculateProductOfEvenNumbersFromFile(inputFileName);
            writeProductToFile(outputFileName, product);
            System.out.println("Добуток парних елементів записано у файл " + outputFileName);
        } catch (IOException e) {
            System.err.println("Помилка обробки файлів: " + e.getMessage());
        }
    }

    private static long calculateProductOfEvenNumbersFromFile(String fileName) throws IOException {
        long product = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);

                    if (number % 2 == 0) {
                        product *= number;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Помилка конвертації рядка до цілого числа: " + e.getMessage());
                }
            }
        }

        return product;
    }

    private static void writeProductToFile(String fileName, long product) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Добуток парних елементів: " + product);
        }
    }
}