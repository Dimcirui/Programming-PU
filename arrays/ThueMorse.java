public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (n > 0) {
            double lg2n = Math.ceil(Math.log(n) / Math.log(2));
            int m = (int) Math.pow(2, lg2n);
            boolean[] a = new boolean[m];

            for (int i = 0; i < lg2n; i++) {
                int num = (int) Math.pow(2, i);
                for (int j = num; j < 2 * num; j++) {
                    a[j] = !a[j - num];
                }
            }

            for (int k = 0; k < n; k++) {
                boolean[] b = new boolean[m];
                for (int x = 0; x < n; x++) {
                    b[x] = a[k] ^ a[x];
                }

                for (int y = 0; y < n; y++) {
                    if (b[y]) System.out.print("-  ");
                    else System.out.print("+  ");
                }
                System.out.println();

            }
        }
    }
}
