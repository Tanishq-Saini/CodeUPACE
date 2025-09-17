import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s = userInput.nextLine();
        System.out.println("The Maximum Length of the String is : "+ length(s));
    }
    static int length(String s){
        int start = 0;
        int end = 0;
        int max_length = 0;
        List<Character> list = new ArrayList<Character>();
        while(end < s.length()){
            if(!list.contains(s.charAt(end))){
                list.add(s.charAt(end));
                end++;
                max_length = Math.max(max_length,list.size());
            }
            else{
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return max_length;
    }
}
