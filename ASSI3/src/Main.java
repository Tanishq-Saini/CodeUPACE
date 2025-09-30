//Java Menu-Driven Program – String & Number Operations
//Author - Tanishq Saini
//Date - 30/9/25
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    int countValid(int n) {
        if (n <= 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += countValid(i) * countValid(n - i - 1);
        }
        return res;
    }

    private void solve(String op, int open, int close, String[] ans, int[] index) {
        if (open == 0 && close == 0) {
            ans[index[0]++] = op;
            return;
        }
        if (open > 0) {
            solve(op + "(", open - 1, close, ans,index);
        }
        if (close > open) {
            solve(op + ")", open, close - 1, ans,index);
        }
    }

    String[] generateParenthesis(int n) {
        int total = countValid(n);
        String[] ans = new String[total];
        int[] index = {0};
        solve("", n, n, ans, index);
        return ans;
    }
    int SumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum += i;
            n /= 10;
        }
        return sum;
    }
    int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 1; i * i < 2 * n; i++) {
            if ((n - i * (i - 1) / 2) % i == 0) {
                count++;
            }
        }
        return count;
    }

    String caesarCipher(String text, int shift) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                // For lowercase letters
                if (Character.isLowerCase(ch)) {
                    ch = (char) ('a' + (ch - 'a' + shift) % 26);
                }
                // For uppercase letters
                else if (Character.isUpperCase(ch)) {
                    ch = (char) ('A' + (ch - 'A' + shift) % 26);
                }
            }
            result += ch;
        }
        return result;
    }

    String[] Encoded_ASCII(String[] text, int series) {
        for (int i = 0; i < text.length; i++) {
            char ch = text[i].charAt(0);
            if (Character.isLowerCase(ch)) {
                ch = (char) ('a' + (ch - 'a' + series) % 26);
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ('A' + (ch - 'A' + series) % 26);
            }
            text[i] = "" + ch;
        }
        return text;
    }
    public static void main(String[] args) {
        Main myOperationsObject = new Main();
        Scanner userInput = new Scanner(System.in);
        boolean keepGoing;
        String operationName = """
                1. Valid Parenthesis Combination
                2. Sum of Digits
                3. Consecutive Number Sum
                4. Caesar Cipher Encoding
                5. Encoded ASCII Transformation
                """;

        do {

            System.out.println("Enter the operation you want to perform:\n" + operationName);
            String operationNumber = userInput.nextLine();

            switch (operationNumber) {

                case "1" -> {
                    System.out.println("Enter the number of parenthesis: ");
                    if (userInput.hasNextInt()) {
                        int input = userInput.nextInt();
                        System.out.println(myOperationsObject.generateParenthesis(input));
                    } else {
                        System.out.println("Invalid input !!");
                    }
                }

                case "2" -> {
                    System.out.println("Enter the number whose sum of digits is to be found: ");
                    if (userInput.hasNextInt()) {
                        int input = userInput.nextInt();
                        userInput.nextLine();
                        System.out.println(myOperationsObject.SumOfDigits(input));
                    } else {
                        System.out.println("Invalid input !!");
                    }
                }

                case "3" -> {
                    System.out.println("Enter the number which is to be represented as the sum of consecutive numbers: ");
                    if (userInput.hasNextInt()) {
                        int input = userInput.nextInt();
                        System.out.println(myOperationsObject.consecutiveNumbersSum(input));
                    } else {
                        System.out.println("Invalid input !!");
                    }
                }

                case "4" -> {
                    System.out.print("Enter the String: ");
                    String stringInput = userInput.nextLine();
                    System.out.println("Shift by: ");
                    int shift = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println(myOperationsObject.caesarCipher(stringInput, shift));
                }

                case "5" -> {
                    System.out.println("Enter the size of the array");
                    int n = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println("Enter elements in array of String : ");
                    String[] text = new String[n];
                    for (int i = 0; i < n; i++) {
                        text[i] = userInput.nextLine();
                    }
                    System.out.println();
                    System.out.print("Shift by : ");
                    int series = userInput.nextInt();
                    System.out.println("Encoded String : " + Arrays.toString(myOperationsObject.Encoded_ASCII(text, series)));
                }

                default -> System.out.println("Invalid input !!");
            }
            System.out.println("Do you want to perform operations again ?? (y/n) : ");
            String userResponse = userInput.nextLine();
            keepGoing = userResponse.equalsIgnoreCase("y");

        } while (keepGoing);
    }
}
