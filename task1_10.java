public class task1_10 {
    public static boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedStr);
    }

    public static void main(String[] args) {
        int[] numbers = {121,  123, 1331, 555};
        int palindromeCount = 0;

        System.out.println("Второй палиндром в списке:");
        for (int number : numbers) {
            if (isPalindrome(number)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    System.out.println(number); 
                    break;
                }
            }
        }
    }
}