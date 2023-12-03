package kr11;
//Скласти програму, яка за рядком А та символом
// S будує новий ря-док,
// отриманий заміною кожного символу, слідуючого за S, заданим символом С
import java.util.Scanner;
public class task217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок A: ");
        String inputString = scanner.nextLine();

        System.out.print("Введіть символ S: ");
        char targetChar = scanner.next().charAt(0);

        System.out.print("Введіть символ C: ");
        char replacementChar = scanner.next().charAt(0);

        String result = replaceAfterChar(inputString, targetChar, replacementChar);

        System.out.println("Результат: " + result);
    }

    private static String replaceAfterChar(String input, char target, char replacement) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));

            if (input.charAt(i) == target && i + 1 < input.length()) {
                result.append(replacement);
                i++;
            }
        }

        return result.toString();
    }
}
