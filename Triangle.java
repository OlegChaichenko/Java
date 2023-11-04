package kr8;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public String getType() {
        if (a == b && b == c) {
            return "Рівносторонній";
        } else if (a == b || b == c || a == c) {
            return "Рівнобедрений";
        } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            return "Прямокутний";
        } else {
            return "Довільний";
        }
    }

    public String toString() {
        return "Трикутник (" + a + ", " + b + ", " + c + ")";
    }

    public static void main(String[] args) {
        Triangle[] triangles = {
                new Triangle(3, 4, 5),
                new Triangle(5, 5, 5),
                new Triangle(6, 8, 10),
                // Додайте інші трикутники
        };

        int рівносторонні = 0;
        int рівнобедрені = 0;
        int прямокутні = 0;
        int довільні = 0;

        Triangle максПлоща = null;
        double maxArea = Double.MIN_VALUE;
        Triangle мінПлоща = null;
        double minArea = Double.MAX_VALUE;

        Triangle максПериметр = null;
        double maxPerimeter = Double.MIN_VALUE;
        Triangle мінПериметр = null;
        double minPerimeter = Double.MAX_VALUE;

        for (Triangle triangle : triangles) {
            String тип = triangle.getType();
            if (тип.equals("Рівносторонній")) {
                рівносторонні++;
            } else if (тип.equals("Рівнобедрений")) {
                рівнобедрені++;
            } else if (тип.equals("Прямокутний")) {
                прямокутні++;
            } else {
                довільні++;
            }

            double площа = triangle.getArea();
            if (площа > maxArea) {
                maxArea = площа;
                максПлоща = triangle;
            }
            if (площа < minArea) {
                minArea = площа;
                мінПлоща = triangle;
            }

            double периметр = triangle.getPerimeter();
            if (периметр > maxPerimeter) {
                maxPerimeter = периметр;
                максПериметр = triangle;
            }
            if (периметр < minPerimeter) {
                minPerimeter = периметр;
                мінПериметр = triangle;
            }
        }

        System.out.println("Рівносторонні: " + рівносторонні);
        System.out.println("Рівнобедрені: " + рівнобедрені);
        System.out.println("Прямокутні: " + прямокутні);
        System.out.println("Довільні: " + довільні);

        System.out.println("Найбільший за площею: " + максПлоща);
        System.out.println("Найменший за площею: " + мінПлоща);

        System.out.println("Найбільший за периметром: " + максПериметр);
        System.out.println("Найменший за периметром: " + мінПериметр);
    }
}

