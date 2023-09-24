import java.util.Scanner;
public class task3_23 {
    public static  void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Перша сторона=");
        int first= scan.nextInt();
        System.out.print("Друга сторона=");
        int second= scan.nextInt();
        System.out.print("Третя сторона=");
        int third= scan.nextInt();
        System.out.print("Радіус=");
        int r= scan.nextInt();
        float p=(first+second+third)/2;
        float S= p*r;
        System.out.print("Площа="+S);


    }
}
