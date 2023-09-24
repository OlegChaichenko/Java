import java.util.Scanner;
public class task4_1v {
    public static  void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("x=");
        double x= scan.nextDouble();
        x=x+1;
        double y=Math.pow(x,5);
        System.out.println("Res=" + y);
    }
}
