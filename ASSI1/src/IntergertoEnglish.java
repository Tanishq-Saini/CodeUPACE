import java.sql.SQLOutput;
import java.util.Scanner;

public class IntergertoEnglish {
    static String[] belowTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    static String[] belowTwenty = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] belowHundred = {"","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = userInput.nextInt();
        System.out.println(numbertowords(num));
    }
    static String numbertowords(int n){
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
            return belowTen[n / 100] + " Hundred" + (n % 100 != 0 ? " " + numbertowords(n % 100): "");
        }
        return numbertowords(n / 1000) + " Thousand" + (n % 1000 != 0 ? " " + numbertowords(n % 1000) : "");

    }
}
