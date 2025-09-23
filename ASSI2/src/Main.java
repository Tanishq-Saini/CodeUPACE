//This code is input string and perform various operations like - append, reverse, sort, replace.
//Author - Tanishq Saini
//Date - 19/09/2025
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose a program:");
        System.out.println("1. Append String");
        System.out.println("2. Replace String");
        System.out.println("3. Sort");
        System.out.println("4. Reverse");

        int choice = userInput.nextInt();
        userInput.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter something: ");
                String s1 = userInput.nextLine();
                obj.Append(s1);
                break;

            case 2:
                System.out.print("Enter a Word: ");
                String sentence = userInput.nextLine();

                System.out.print("Enter the character to replace: ");
                char oldWord = userInput.next().charAt(0);

                System.out.print("Enter the new character: ");
                char newWord = userInput.next().charAt(0);
                System.out.println("New String is : "+ obj.Replace(sentence, oldWord, newWord));
                break;

            case 3:
                System.out.print("Enter a String : ");
                String text = userInput.nextLine();
                System.out.println("Original: " + text);
                System.out.println("Sorted: " + obj.sort(text));
                break;

            case 4:
                String name = "Java";
                String reversedText = obj.reverse(name);
                System.out.println("Original: " + name);
                System.out.println("Reversed: " + reversedText);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    void Append(String s1) {
        String name = "Python Programming";
        String newString = s1 + name;
        System.out.println("Final String: " + newString);
    }

    String Replace(String text, char oldChar, char newChar) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldChar) {
                arr[i] = newChar;
            }
        }

        return new String(arr);
    }

    String sort(String currentString) {
        if (currentString.isEmpty()) {
            System.out.println("String is empty! Nothing to sort.");
            return "No sorting is Possible";
        }
        int n = currentString.length();
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = currentString.charAt(i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + arr[i];
        }

        return result;
    }

    String reverse(String text) {
        if (text.isEmpty()) {
            System.out.println("String is empty! Nothing to reverse.");
            return text;
        }

        String result = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            result = result + text.charAt(i);
        }

        text = result;
        return result;
    }
}





