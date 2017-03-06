import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jakob Makovac on 06/03/2017.
 */
public class EP8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        ArrayList<Integer> zeroPositions = new ArrayList<>();
        long biggestProduct = 0;

        String input = "73167176531330624919225119674426574742355349194934\n" +
                "96983520312774506326239578318016984801869478851843\n" +
                "85861560789112949495459501737958331952853208805511\n" +
                "12540698747158523863050715693290963295227443043557\n" +
                "66896648950445244523161731856403098711121722383113\n" +
                "62229893423380308135336276614282806444486645238749\n" +
                "30358907296290491560440772390713810515859307960866\n" +
                "70172427121883998797908792274921901699720888093776\n" +
                "65727333001053367881220235421809751254540594752243\n" +
                "52584907711670556013604839586446706324415722155397\n" +
                "53697817977846174064955149290862569321978468622482\n" +
                "83972241375657056057490261407972968652414535100474\n" +
                "82166370484403199890008895243450658541227588666881\n" +
                "16427171479924442928230863465674813919123162824586\n" +
                "17866458359124566529476545682848912883142607690042\n" +
                "24219022671055626321111109370544217506941658960408\n" +
                "07198403850962455444362981230987879927244284909188\n" +
                "84580156166097919133875499200524063689912560717606\n" +
                "05886116467109405077541002256983155200055935729725\n" +
                "71636269561882670428252483600823257530420752963450";

        //remove all line breaks from input.
        input = input.replace("\n", "");

        //Removes all numbers that are between two zeros separated for less then the limit given.
        input = removeNumBetweenZeros(input, limit);

        //Stores positions that result in a zero so we can skip them when computing products
        zeroPositions = findZeros(input, limit);

        //Compute all the products of given length and stores the largest.
        for(int i = 0; i < input.length()-limit+1; i++){
            if(!zeroPositions.contains(i)){
                long current = computeProduct(input.substring(i, i+limit));
                if(current>biggestProduct){
                    biggestProduct = current;
                }
            }
        }
        System.out.println("Largest product is: " + biggestProduct);
    }

    private static long computeProduct(String in) {
        System.out.println(in);
        long out = 1;
        for(int i = 0; i < in.length(); i++){
            out *= Character.getNumericValue(in.charAt(i));
        }
        System.out.println(out);
        return out;
    }

    private static ArrayList<Integer> findZeros(String in, int lim) {
        ArrayList<Integer> zeros = new ArrayList<>();

        //Creates Arraylist with every starting position that will result in 0
        for (int i = 0; i < in.length(); i++){
            if(in.charAt(i) == '0'){
                for(int j = i-lim+1; j <= i; j++){
                    zeros.add(j);
                }
            }
        }

        return zeros;
    }

    private static String removeNumBetweenZeros (String in, int lim){
        String temp = "", out = "";
        int stepsFromLastZero = 1000;

        for (int i = 0; i<in.length(); i++){
            char currentChar = in.charAt(i);
            temp += currentChar;

            if(currentChar == '0'){
                if(stepsFromLastZero >= lim){
                    out += temp;
                }
                stepsFromLastZero = 0;
                temp ="";
            }

            stepsFromLastZero ++;

        }

        return out;
    }

}
