public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;

        System.out.println("(" + x + ", " + y + ")");
        while (Math.abs(x) + Math.abs(y) < r) {
            int rand = (int) (Math.random() * 4);
            if (rand == 0) x++;
            else if (rand == 1) x--;
            else if (rand == 2) y++;
            else if (rand == 3) y--;
            steps++;
            System.out.println("(" + x + ", " + y + ")");
        }

        System.out.println("steps = " + steps);
    }
}
