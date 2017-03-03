/**
 * Created by Jakob Makovac on 03/03/2017.
 */
public class EP5 {
    public static void main(String[] args) throws Exception {
       
    }

    private static int lcm (int a, int b) throws Exception {
        return a*b/gcd(a,b);
    }

    private static int gcd (int x1, int x2) throws Exception {
        Exception e = new Exception("gcd of 0");
        if(x1<1 || x2 <1) {
            throw e;
        }
        int a = x1;
        int b = x2;
        int c;

        do {
            c = a % b;
            a = b;
            b = c;
        } while (b != 0);

        return a;
    }
}
