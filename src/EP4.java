/**
 * Created by Jakob Makovac on 03/03/2017.
 */
public class EP4 {
    public static void main(String[] args) {
        int largestPalindrome = 0;

        for (int i = 1; i < 1000; i++){
            for (int j = 1; j < 1000; j++){
                if(isPalindrome(i*j) && i*j > largestPalindrome){
                    largestPalindrome = i*j;
                }
            }
        }

        System.out.println("Largest palindrome when multiplying two 3-digit numbers is: " + largestPalindrome);
    }

    private static boolean isPalindrome (int x){
        String numString = String.valueOf(x);
        int numLength = numString.length();

        for (int i = 0; i < numLength; i++){
            if(numString.charAt(i) != numString.charAt(numLength-i-1)){
                
                return false;
            }
        }

        return true;
    }
}
