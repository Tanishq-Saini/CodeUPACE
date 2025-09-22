//This code is input string and perform various operations like - append, reverse, sort, replace.
//Author - Tanishq Saini
//Date - 19/09/2025
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
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
                Append(s1);
                break;

            case 2:
                System.out.print("Enter a sentence: ");
                String sentence = userInput.nextLine();

                System.out.print("Enter the word to replace: ");
                String oldWord = userInput.nextLine();

                System.out.print("Enter the new word: ");
                String newWord = userInput.nextLine();
                Replace(sentence, oldWord, newWord);
                break;

            case 3:
                System.out.print("Enter a String : ");
                String text = userInput.nextLine();
                System.out.println("Original: " + text);
                System.out.println("Sorted: " + sort(text));
                break;

            case 4:
                String name = "Java";
                String reversedText = reverse(name);
                System.out.println("Original: " + name);
                System.out.println("Reversed: " + reversedText);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    static void Append(String s1) {
        String name = "Python Programming";
        String newString = s1 + name;
        System.out.println("Final String: " + newString);
    }

    static void Replace(String sentence, String oldWord, String newWord) {
        String result = sentence.replace(oldWord, newWord);
        System.out.println("Modified sentence: " + result);
    }

    static String sort(String text) {
        char[] chars = text.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }

    static String reverse(String text) {
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
