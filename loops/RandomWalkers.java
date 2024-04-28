public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double aver = 0;

        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;

            while (Math.abs(x) + Math.abs(y) != r) {
                int rand = (int) (Math.random() * 4);
                if (rand == 0) x++;
                else if (rand == 1) x--;
                else if (rand == 2) y++;
                else if (rand == 3) y--;
                steps++;
            }

            aver += steps;
        }

        aver /= trials;

        System.out.println("average number of steps = " + aver);
    }
}
