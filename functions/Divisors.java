public class Divisors {
    // the greatest common divisor
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int t;
        while (b != 0) {
            t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    // the least common multiple
    public static int lcm(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a * b == 0) return 0;
        else return b / gcd(a, b) * a;   // avoid preventable arithmetic overflow
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are relatively prime with n.
    public static int totient(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) if (areRelativelyPrime(n, i)) num++;
        return num;
    }


    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + a + ") = " + totient(b));
    }
}
