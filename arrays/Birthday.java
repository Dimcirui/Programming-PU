public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[n + 2];   // at most n+1 people can enter before encountering

        for (int i = 0; i < trials; i++) {
            // use a boolean array to determine whether two people share a same birthday
            boolean[] birthday = new boolean[n];
            int sum = 0;

            // simulate the process of entering
            while (true) {
                int day = (int) (Math.random() * n);  // generate birthday
                sum++;
                if (birthday[day]) break;   // encounter happens if 'true' before recording data
                birthday[day] = true;
            }
            count[sum]++;
        }

        // calculate the probability
        double totalp = 0;
        for (int j = 1; j <= n + 1; j++) {
            double p = count[j] / (double) trials;
            totalp += p;
            System.out.println(j + "\t" + count[j] + "\t" + totalp);
            if (totalp >= 0.5) break;
        }
    }
}
