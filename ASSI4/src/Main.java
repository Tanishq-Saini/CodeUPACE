//This files provides some of string operations like - Count Unique Palindrome, Fibonacci Numbers, SnakeCase to CamelCase, Count Consonants, Binary to Decimal
//Author - Tanishq Saini
//Date - 13/10/25
import java.util.Scanner;
public class Main {

    int countUniquePalindromes(String s){
        String[] palindrome = new String[1000];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(isPalindrome(s,i,j)){
                    int length = j - i + 1;
                    if(length > 1){
                        String temp = "";
                        for(int k = 0 ; k <= j; k++){
                            temp += s.charAt(k);
                        }
                        boolean exist = false;
                        for(int x = 0; x < count; x++){
                            if(palindrome[x].equals(temp)){
                                exist = true;
                                break;
                            }
                        }
                        if(!exist){
                            palindrome[count++] = temp;
                        }
                    }
                }
            }
        }
        return count;
    }

    boolean isPalindrome(String s, int start, int end) {
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 2. Fibonacci Sequence – Nth Number
    int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 3. Snake Case to Camel Case Conversion
    String snakeToCamel(String s) {
        String result = "";
        boolean upperNext = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '_') {
                upperNext = true;
            } else {
                if (upperNext) {
                    if (ch >= 'a' && ch <= 'z') {
                        ch = (char)(ch - 32); //differnce of A and a is 32 and it convert lowercase to uppercase
                    }
                    upperNext = false;
                }
                result += ch;
            }
        }
        return result;
    }

    // 4. Count Consonants in a String
    int countConsonants(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch + 32);//differnce of A and a is 32 and it convert uppercase to lowercase
            }
            if(ch <= 'a' && ch >= 'z'){
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    count++;
                }
            }
        }
        return count;
    }

    // 5. Binary to Decimal Conversion
    int binaryToDecimal(String binary) {
        int decimal = 0;
        int base = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            if (bit == '1') {
                decimal = decimal + base;
            }
            base = base * 2;
        }
        return decimal;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Count Unique Palindromes");
            System.out.println("2. Fibonacci Sequence – Nth Number");
            System.out.println("3. Snake Case to Camel Case Conversion");
            System.out.println("4. Count Consonants in a String");
            System.out.println("5. Binary to Decimal Conversion");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String str1 = sc.nextLine();
                    System.out.println("Unique Palindromes Count: " + obj.countUniquePalindromes(str1));
                    break;

                case 2:
                    System.out.print("Enter N: ");
                    int n = sc.nextInt();
                    System.out.println("Nth Fibonacci Number: " + obj.fibonacci(n));
                    break;

                case 3:
                    System.out.print("Enter snake_case string: ");
                    String snake = sc.nextLine();
                    System.out.println("CamelCase: " + obj.snakeToCamel(snake));
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    String str2 = sc.nextLine();
                    System.out.println("Number of Consonants: " + obj.countConsonants(str2));
                    break;

                case 5:
                    System.out.print("Enter a binary string: ");
                    String binary = sc.nextLine();
                    System.out.println("Decimal Value: " + obj.binaryToDecimal(binary));
                    break;

                case 6:
                    System.out.println("Exiting the program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
