/**
 Oleg Chaichenko
 */
import java.util.Scanner;
public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перший аргумент: ");
        String arg1 = scanner.nextLine();

        System.out.print("Введіть другий аргумент: ");
        String arg2 = scanner.nextLine();

        System.out.print("Введіть третій аргумент: ");
        String arg3 = scanner.nextLine();

        System.out.println("Перший аргумент: " + arg1);
        System.out.println("Другий аргумент: " + arg2);
        System.out.println("Третій аргумент: " + arg3);

        scanner.close();


    }
}
