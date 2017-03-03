/**
 * Created by Jakob Makovac on 03/03/2017.
 */
public class EP4 {
    public static void main(String[] args) {
        isPalindrome(303031);
    }

    private static boolean isPalindrome (int x){
        String numString = String.valueOf(x);
        int numLength = numString.length();

        for (int i = 0; i < numLength; i++){
            if(numString.charAt(i) != numString.charAt(numLength-i-1)){
                System.out.println("Number is not a palindrome.");
                return false;
            }
        }
        System.out.println("Number is a palindrome.");
        return true;
    }
}
