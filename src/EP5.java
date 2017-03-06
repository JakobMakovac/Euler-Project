/**
 * Created by Jakob Makovac on 03/03/2017.
 */
public class EP5 {
    public static void main(String[] args) throws Exception {
        long result = lcm(1,lcm(2, lcm(3, lcm(4, lcm(5, lcm(6, lcm(7, lcm(8, lcm(9,
                lcm(10, lcm(11, lcm(12, lcm( 13, lcm(14, lcm(15, lcm(16, lcm(17, lcm( 18, lcm(19, 20)))))))))))))))))));
        System.out.println(result);
    }

    private static long lcm (long a, long b) throws Exception {
        return a*b/gcd(a,b);
    }

    private static long gcd (long x1, long x2) throws Exception {
        Exception e = new Exception("gcd of 0");
        if(x1<1 || x2 <1) {
            throw e;
        }
        long a = x1;
        long b = x2;
        long c;

        do {
            c = a % b;
            a = b;
            b = c;
        } while (b != 0);

        return a;
    }
}
