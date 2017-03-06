import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jakob Makovac on 06/03/2017.
 */
public class EP7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int counter = 1;
        int lastPrime = 0;

        ArrayList<Integer> primes = new ArrayList<>();

        while (primes.size() < limit){
            System.out.println("Size of primes Arraylist: " +primes.size());
            if(counter == 1){
                primes.add(2);
                lastPrime = 2;
            } else
            if(isPrime(counter, primes)){
                System.out.println("Current number: " + counter);
                primes.add(counter);
                lastPrime = counter;
            }
            counter = counter + 2;
        }

        System.out.println(lastPrime);
    }

    private static boolean isPrime(int counter, ArrayList<Integer> list) {
        for(int x: list){
            if(counter % x == 0){
                System.out.println("Not a prime");
                return false;
            }
        }
        System.out.println("Prime");
        return true;
    }
}
