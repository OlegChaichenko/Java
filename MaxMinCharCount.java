package kr11;
import java.util.HashMap;
import java.util.Map;
//Знайти символ, кількість входжень якого у рядок А а) максимальна;
//б) мінімальна.
public class MaxMinCharCount {
    public static void main(String[] args) {
        String inputString = "ВВаааашш рряяддоокк АA";

        char maxChar = findMaxOccurringChar(inputString);
        char minChar = findMinOccurringChar(inputString);

        System.out.println("Символ з максимальною кількістю входжень: " + maxChar);
        System.out.println("Символ з мінімальною кількістю входжень: " + minChar);
    }

    private static char findMaxOccurringChar(String input) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char maxChar = '\0';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        return maxChar;
    }

    private static char findMinOccurringChar(String input) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char minChar = '\0';
        int minCount = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() < minCount) {
                minCount = entry.getValue();
                minChar = entry.getKey();
            }
        }

        return minChar;
    }
}
