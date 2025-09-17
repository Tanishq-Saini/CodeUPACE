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
        for (int i = 0; i < s.length(); i += 2) {
            char ch = s.charAt(i);
            int count = s.charAt(i+1) - '0'; //char int me convert
            for(int j=0; j< count; j++) {
                result = result + ch;
            }
        }
        return result;
    }
}
