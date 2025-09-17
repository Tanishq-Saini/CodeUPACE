import java.util.Scanner;

public class Prime {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            boolean prime = isprime(n);
            System.out.println(prime);
        }

        static boolean isprime(int n) {
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
