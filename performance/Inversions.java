public class Inversions {
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) count++;
            }
        }
        return count;
    }

    public static int[] generate(int n, long k) {
        int[] a = new int[n];

        // a completely reversed array
        if (k == (long) n * (n - 1) / 2) {
            for (int i = 0; i < n; i++) a[i] = n - i - 1;
        }

        // partly reversed
        else if (0 <= k && k < (long) n * (n - 1) / 2) {
            int count = 1;
            long auxk = k;

            // step 1: move end numbers to the beginning
            while (auxk >= (long) n - count) {
                a[count - 1] = n - count;
                auxk -= n - count;
                count++;
            }
            // the last moved number should be handled separately
            int index = n - 1 - (int) auxk;
            a[index] = n - count;

            // step 2: adding sequential numbers
            for (int i = count - 1; i < index; i++) {
                a[i] = i - count + 1;
            }
            for (int i = index + 1; i < n; i++) {
                a[i] = i - count;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] a = generate(n, k);

        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }
}
