package dr3;
import java.util.Scanner;
public class task4_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("n=");
        int n = s.nextInt();

        int count = 0;

        for (int i = 10; i <= 99; i++) {
            System.out.print(i + " ");
            count++;

            if (count == n) {
                System.out.println();
                count = 0;
            }
        }
    }
}
