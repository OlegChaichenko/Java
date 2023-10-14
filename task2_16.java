import java.util.Scanner;
public class task2_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число n: ");
        int N = scanner.nextInt();

        System.out.print("Введіть номер біта m: ");
        int M = scanner.nextInt();

        int commonBits = countCommonBits(M, N);
        System.out.println("Кількість спільних одиночок бітового представлення: " + commonBits);
    }

    public static int countCommonBits(int M, int N) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bitM = (M >> i) & 1;
            int bitN = (N >> i) & 1;
            if (bitM == 1 && bitN == 1) {
                count++;
            }
        }
        return count;
    }
}
