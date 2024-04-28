public class Ramanujan {
    public static boolean isRamanujan(long n) {
        // Fermat's Last Theorem
        if (Math.floor(Math.cbrt(n)) == Math.cbrt(n)) return false;

        int count = 0;
        for (long a = 0; a * a * a <= n / 2; a++) {
            double b = Math.cbrt(n - a * a * a);
            if (Math.floor(b) == b) {
                count++;
            }
            if (count == 2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
