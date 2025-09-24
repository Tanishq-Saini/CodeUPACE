import java.util.*;

public class MyPrograms {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose a program:");
        System.out.println("1. Compress String");
        System.out.println("2. Expand String");
        System.out.println("3. Integer to English");
        System.out.println("4. Longest Substring without repeating");
        System.out.println("5. Prime Check");

        int choice = userInput.nextInt();
        userInput.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter String: ");
                String s1 = userInput.nextLine();
                compressString(s1);
                break;

            case 2:
                System.out.print("Enter String (like a3b2c4): ");
                String s2 = userInput.nextLine();
                expandString(s2);
                break;

            case 3:
                System.out.print("Enter number: ");
                int num = userInput.nextInt();
                System.out.println("In English: " + integerToEnglish(num));
                break;

            case 4:
                System.out.print("Enter String: ");
                String s3 = userInput.nextLine();
                System.out.println("The length of Substring is : " + lengthOfSubstring(s3));
                break;

            case 5:
                System.out.print("Enter number: ");
                int n = userInput.nextInt();
                System.out.println(n + (isPrime(n) ? " is Prime" : " is Not Prime"));
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    static void compressString(String str) {
        int[] freq = new int[256]; // to store frequency of ASCII characters

        // count frequency
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        // print in order of first appearance
        boolean[] printed = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!printed[ch]) {
                System.out.print(ch);
                System.out.print(freq[ch]);
                printed[ch] = true;
            }
        }
    }
    static void expandString(String expandStr) {
        try {
            String result = "";
            int i = 0;

            while (i < expandStr.length()) {
                char ch = expandStr.charAt(i++);
                int count = 0;
                while (i < expandStr.length() && expandStr.charAt(i) >= '0' && expandStr.charAt(i) <= '9') {
                    count = count * 10 + (expandStr.charAt(i++) - '0');
                }
                if (count == 0) count = 1;

                int j = 0;
                while (j < count) {
                    result = result + ch;
                    j++;
                }
            }

            System.out.println("Expanded String: " + result);
        } catch (Exception e) {
            System.out.println("Error in Expand: " + e.getMessage());
        }
    }

    static String integerToEnglish(int n) {
        String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] belowTwenty = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (n == 0) {
            return "Zero";
        }
        if (n < 10) {
            return belowTen[n];
        }
        if (n < 20 && n != 10) {
            return belowTwenty[n - 10];
        }
        if (n < 100) {
            return belowHundred[n / 10] + (n % 10 != 0 ? " " + belowTen[n % 10] : "");
        }
        if (n < 1000) {
            return belowTen[n / 100] + " Hundred" + (n % 100 != 0 ? " " + integerToEnglish(n % 100) : "");
        }
        return integerToEnglish(n / 1000) + " Thousand" + (n % 1000 != 0 ? " " + integerToEnglish(n % 1000) : "");
    }

    static int lengthOfSubstring(String input) {
        boolean[] visitChar = new boolean[256];
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while (end < input.length()) {
            char currentChar = input.charAt(end);

            if (!visitChar[currentChar]) {
                visitChar[currentChar] = true;
                end++;
                maxLength = (maxLength > end - start) ? maxLength : end - start;
            } else {
                visitChar[input.charAt(start)] = false;
                start++;
            }
        }
        return maxLength;
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return c * c > n;
    }
}
