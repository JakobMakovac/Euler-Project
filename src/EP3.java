import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Jakob Makovac on 03/03/2017.
 */
public class EP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repetitions = 1000;
        String input = sc.nextLine();
        BigInteger biggestFactor = new BigInteger(String.valueOf(0));

        BigInteger number = new BigInteger(input);

        while(repetitions > 0){

            BigInteger factor = polardRho(number);
            System.out.println("Current factor is: " + factor.intValue());

            if (factor.compareTo(biggestFactor) > 0 && !factor.equals(number) && factor.isProbablePrime(95)){
                biggestFactor = factor;
            }


            repetitions --;
        }

        System.out.println("Biggest factor is: " + biggestFactor.intValue());
        }

    private static BigInteger polardRho(BigInteger input) {
        System.out.println("Entered pollardRho method");

        Random rand = new Random();

        int tries = 0;

        BigInteger x = new BigInteger(String.valueOf(rand.nextInt()));
        BigInteger y = new BigInteger(String.valueOf(rand.nextInt()));
        BigInteger d = new BigInteger(String.valueOf(1));
        BigInteger difference;

        while(d.equals(BigInteger.ONE)){
            tries++;

            x = polynomial(x, input);
            y = polynomial(polynomial(y, input), input);
            difference = x.subtract(y);
            d = input.gcd(difference.abs());

            if(tries == 1000000){
                d = BigInteger.ZERO;
            }
        }
        return d;
    }

    private static BigInteger polynomial (BigInteger x, BigInteger n){
        return x.multiply(x).add(BigInteger.ONE).mod(n);
    }
}
