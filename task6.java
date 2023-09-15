/**
 Oleg Chaichenko
 */
import java.util.Scanner;
public class task6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Введіть перший аргумент: ");
        float arg1 = s.nextFloat();

        System.out.print("Введіть другий аргумент: ");
        float arg2 = s.nextFloat();

        System.out.print("Введіть третій аргумент: ");
        float arg3 = s.nextFloat();

        System.out.println(arg1 + arg2 + arg3);
    }
}
