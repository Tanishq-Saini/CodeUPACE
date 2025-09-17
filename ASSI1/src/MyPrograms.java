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
                System.out.println("Expanded: " + expandString(s2));
                break;

            case 3:
                System.out.print("Enter number: ");
                int num = userInput.nextInt();
                System.out.println("In English: " + integerToEnglish(num));
                break;

            case 4:
                System.out.print("Enter String: ");
                String s3 = userInput.nextLine();
                System.out.println("The length of Substring is : "+lengthOfSubstring(s3));
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
        int count = 1;
        for(int i=0; i<str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                System.out.print(str.charAt(i));
                if(count >= 1) {
                    System.out.print(count);
                }
                count = 1; //reset
            }
        }
        //handle last character
        System.out.print(str.charAt(str.length() - 1));
        if (count >= 1) {
            System.out.print(count);
        }
    }

    static String expandString(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i += 2) {
            char ch = s.charAt(i);
            int count = s.charAt(i+1) - '0'; //char convert into int
            for(int j=0; j< count; j++) {
                result = result + ch;
            }
        }
        return result;
    }
    static String integerToEnglish(int n) {
        String[] belowTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] belowTwenty = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] belowHundred = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(n == 0){
            return "Zero";
        }
        if(n < 10){
            return belowTen[n];
        }
        if(n < 20 && n != 10){
            return belowTwenty[n - 10];
        }
        if(n < 100){
            return belowHundred[n / 10] +  (n % 10 != 0 ? " " + belowTen[n % 10]:"");
        }
        if(n < 1000){
            return belowTen[n / 100] + " Hundred" + (n % 100 != 0 ? " " + integerToEnglish(n % 100): "");
        }
        return integerToEnglish(n / 1000) + " Thousand" + (n % 1000 != 0 ? " " + integerToEnglish(n % 1000) : "");
    }

    static int lengthOfSubstring(String input){
        boolean[] visitChar = new boolean[256];
        int start = 0;
        int end = 0;
        int maxLength = 0;

        while(end < input.length()){
            char currentChar = input.charAt(end);

            if(!visitChar[currentChar]){
                visitChar[currentChar] = true;
                end++;
                maxLength = (maxLength > end-start) ? maxLength : end-start;
            } else {
                visitChar[input.charAt(start)] = false;
                start++;
            }
        }

        return maxLength;

    }

    static boolean isPrime(int n) {
        if(n <= 1){
            return false;
        }
        int c = 2;
        while(c * c <= n){
            if(n % c == 0){
                return false;
            }
            c++;
        }
        return c * c > n;
    }
}
