import java.util.*;
public class CompressString {
    public static void CompressedString(String str) {
        int count = 1;
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                System.out.print(str.charAt(i));
                if(count > 1) {
                    System.out.print(count);
                }
                count = 1; //reset
            }
        }
        //handle last character
        System.out.print(str.charAt(str.length() - 1));
        if (count > 1) {
            System.out.print(count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.nextLine();
        CompressedString(str);
    }
}
