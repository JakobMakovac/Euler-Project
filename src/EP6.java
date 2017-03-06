import java.util.Scanner;

/**
 * Created by Jakob Makovac on 06/03/2017.
 */
public class EP6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int sum = 0;

        int[] numbers = new int[limit];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = i+1;
        }

        for (int i = 0; i<numbers.length;i++){
            int current = numbers[i];
            for (int j = 0; j<numbers.length; j++){
                if (j != i){
                    sum += current*numbers[j];
                }
            }
        }

        System.out.println(sum);
    }
}
