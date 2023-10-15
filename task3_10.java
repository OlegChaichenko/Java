package dr3;

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Circle {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getIntersectionType(Point p1, Point p2) {
        double m = (p2.y - p1.y) / (p2.x - p1.x);
        double b = p1.y - m * p1.x;

        double distance = Math.abs(m * center.x - center.y + b) / Math.sqrt(m * m + 1);

        if (distance < radius) {
            if (distance == radius) {
                return 1; // Випадок б) Одна точка дотику
            } else {
                return 2; // Випадок а) Дві точки перетину
            }
        } else {
            return 0; // Випадок с) Немає точок дотику
        }
    }
}

public class task3_10 {
    public static void main(String[] args) {
        Point circleCenter = new Point(0, 0);
        double circleRadius = 5;
        Circle circle = new Circle(circleCenter, circleRadius);

        Point linePoint1 = new Point(-3, 3);
        Point linePoint2 = new Point(3, 3);

        int intersects = circle.getIntersectionType(linePoint1, linePoint2);
        if (intersects == 2) {
            System.out.println("Пряма і коло перетинаються в 2");
        } else if (intersects==1) {
            System.out.println("Пряма і коло перетинаються в 1");
        } else {
            System.out.println("Пряма і коло не перетинаються.");
        }
    }
}