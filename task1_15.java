import java.util.Scanner;

public class task1_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        System.out.print("p: ");
        int p = scanner.nextInt();


        int[] arr = new int[size];


        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("(Элементы массива) *p:");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]*p);
        }
        System.out.println("(Элементы массива) **p:");
        for (int i = 0; i < size; i++) {
            System.out.println(Math.pow(arr[i],p));
        }


    }
}