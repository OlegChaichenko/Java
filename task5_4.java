package kr12;
//Визначити процедуру, яка переписує до текстового файла G усі рядки текстового файла F:
// а) із заміною в них символа '0' на '1', і навпаки;
// б) в інвертованому вигляді
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task5_4 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputReplaceFileName = "output_replace.txt";
        String outputInvertFileName = "output_invert.txt";
        try {
            replaceAndInvertFile(inputFileName, outputReplaceFileName, outputInvertFileName);
            System.out.println("Операції заміни та інверсії файлу завершені.");
        } catch (IOException e) {
            System.err.println("Помилка обробки файлів: " + e.getMessage());
        }
    }

    private static void replaceAndInvertFile(String inputFileName, String outputReplaceFileName, String outputInvertFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter replaceWriter = new BufferedWriter(new FileWriter(outputReplaceFileName));
             BufferedWriter invertWriter = new BufferedWriter(new FileWriter(outputInvertFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String replacedLine = replaceCharacters(line);
                replaceWriter.write(replacedLine);
                replaceWriter.newLine();

                String invertedLine = invertString(line);
                invertWriter.write(invertedLine);
                invertWriter.newLine();
            }
        }
    }

    private static String replaceCharacters(String input) {
        return input.replace('0', '1').replace('1', '0');
    }

    private static String invertString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
