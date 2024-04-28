public class ShannonEntropy {
    public static void main(String[] args) {
        // integers are between 1 and m (included)
        int m = Integer.parseInt(args[0]);
        // number of integers
        int num = 0;
        int[] a = new int[m+1];
        while (!StdIn.isEmpty()) {
                int n = StdIn.readInt();
                a[n]++;
                num++;
        }

        double ent = 0.0;
        for (int i = 1; i <= m; i++) {
            double p = (double) a[i] / num;
            if (a[i] > 0) ent -= Math.log(p) / Math.log(2) * p;
        }

        StdOut.printf("%.4f\n", ent);
    }
}