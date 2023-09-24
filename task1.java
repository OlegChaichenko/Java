import java.util.Scanner;
public class task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введіть прізвище: ");
        String surname = scan.nextLine();

        System.out.println("Привіт, " + surname);
    }
}
