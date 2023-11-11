package task6_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Sweet {
    private String name;
    private double weight;
    private double sugarContent;

    public Sweet(String name, double weight, double sugarContent) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    @Override
    public String toString() {
        return name + " (Weight: " + weight + "g, Sugar Content: " + sugarContent + "%)";
    }
}


class Candy extends Sweet {
    private String flavor;

    public Candy(String flavor, double weight, double sugarContent) {
        super("Candy", weight, sugarContent);
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return flavor + " Candy";
    }
}


class Chocolate extends Sweet {
    private String type;

    public Chocolate(String type, double weight, double sugarContent) {
        super("Chocolate", weight, sugarContent);
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " Chocolate";
    }
}


class Gift {
    private List<Sweet> sweets = new ArrayList<>();

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public double calculateWeight() {
        double totalWeight = 0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.getWeight();
        }
        return totalWeight;
    }

    public void sortByParameter() {
        Collections.sort(sweets, (s1, s2) -> Double.compare(s1.getSugarContent(), s2.getSugarContent()));
    }

    public Sweet findSweetBySugarContent(double minSugar, double maxSugar) {
        for (Sweet sweet : sweets) {
            if (sweet.getSugarContent() >= minSugar && sweet.getSugarContent() <= maxSugar) {
                return sweet;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Gift: ");
        for (Sweet sweet : sweets) {
            result.append(sweet).append(", ");
        }

        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}

public class NewYearGift {
    public static void main(String[] args) {
        Candy toffee = new Candy("Toffee", 50, 15);
        Chocolate darkChocolate = new Chocolate("Dark", 100, 30);
        Candy lollipop = new Candy("Lollipop", 30, 20);

        Gift gift = new Gift();
        gift.addSweet(toffee);
        gift.addSweet(darkChocolate);
        gift.addSweet(lollipop);

        System.out.println("Gift weight: " + gift.calculateWeight() + "g");

        gift.sortByParameter();
        System.out.println("Gift after sorting by sugar content: " + gift);

        Sweet foundSweet = gift.findSweetBySugarContent(10, 25);
        if (foundSweet != null) {
            System.out.println("Sweet found by sugar content: " + foundSweet);
        } else {
            System.out.println("No sweet found in the specified sugar content range.");
        }
    }
}
