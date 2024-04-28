public class TrinomialDP {
    public static long trinomial(int n, int k) {
        n = Math.abs(n);
        k = Math.abs(k);

        if (k > n) return 0;
        else if (n == 0 && k == 0) return 1;
        else {
            long[][] t = new long[n + 2][n + 2];
            t[0][0] = 1;

            // when i == n, j == n, the upper bound of array is [n][n+1]
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    t[i][j] = t[i-1][Math.abs(j-1)] + t[i-1][j] +t[i-1][j+1];
                }
            }

            return t[n][k];
        }
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));
    }
}
