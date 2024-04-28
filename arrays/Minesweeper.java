public class Minesweeper {
    public static void main(String[] args) {
        // m-by-n grids, k mines
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        // create extra edges for boundary conditions
        boolean[][] mines = new boolean[m + 2][n + 2];
        int[][] neibor = new int[m + 2][n + 2];

        // place mines (shuffling algorithm can be a better way)
        for (int i = 0; i < k; i++) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);
            if (mines[x + 1][y + 1]) {
                i--;    // better not to modify loop control variables inside a for loop, instead, using a while loop is better
                continue;
            }
            mines[x + 1][y + 1] = true;
        }

        // count mines, first two loops are used for traverse, and last two are used for counting
        for (int r = 0; r < m; r++) {
            for (int s = 0; s < n; s++) {
                int count = 0;
                for (int p = -1; p <= 1; p++) {
                    for (int q = -1; q <= 1; q++) {
                        if (mines[r + 1 + p][s + 1 + q]) count++;
                    }
                }

                neibor[r + 1][s + 1] = count;
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (mines[x + 1][y + 1]) {
                    System.out.print("*  ");
                }
                else {
                    System.out.print(neibor[x + 1][y + 1] + "  ");
                }
            }

            System.out.println();
        }
    }
}
