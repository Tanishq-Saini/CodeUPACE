import java.util.Scanner;

public class ExpandString {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s = userInput.nextLine().toLowerCase();
        String result = "";
        System.out.println("The Expand String is : "+ Expand(s, result));
    }

    static String Expand(String s, String result) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                int count = Character.getNumericValue(s.charAt(i + 1));

                for (int j = 0; j < count; j++) {
                    result += ch;
                }
            }
        }

        return result;
    }
}
