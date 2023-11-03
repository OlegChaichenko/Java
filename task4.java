package kr7;

public class task4 {
    protected int data;
    public void setData(int value) {
        this.data = value;
    }
    public int getData() {
        return this.data;
    }
}
class Main {
    public static void main(String[] args) {
        task4 obj = new task4();
        obj.setData(42);
        System.out.println("Значення поля: " + obj.getData());
    }
}