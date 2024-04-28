public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] a = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            a[j] = Integer.parseInt(args[j]);
            sum[j] = sum[j-1] + a[j];
        }

        for (int k = 0; k < m; k++) {
            int r = (int) (Math.random() * sum[n]);

            for (int i = 1; i <= n; i++) {
                if (sum[i-1] <= r && r < sum[i]) {
                    System.out.print(i + " ");
                    break;
                }
            }
            
        }
    }
}