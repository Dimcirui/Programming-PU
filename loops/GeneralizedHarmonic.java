public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double har = 0;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                har += 1/(Math.pow(i, r));
            }
        }
        else har = 1.0;

        System.out.println(har);
    }
}