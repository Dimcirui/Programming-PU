public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        // extra space will be useful when i or j == 1
        int[][] stat = new int[a.length + 1][a.length + 1];
        int max = 0;

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                if (a[i - 1][j - 1] == 1) {
                    // 1. Only when every element within the nearest square are bigger than n-1,
                    //    the lower right corner's element will be n.
                    // 2. The solution looks like this:
                    //      |n| is true    |n-1 n-1| which is true  |n-2 n-2 n-2| ...
                    //          only when  |n-1  n | only when      |n-2 n-1 n-1|
                    //                                              |n-2 n-1  n |
                    // 3.  So, in the process of traversing, every SS will be detected
                    stat[i][j] = Math.min(Math.min(stat[i - 1][j], stat[i][j - 1]), stat[i - 1][j - 1]) + 1;
                    //     and the MSS will be recorded
                    max = Math.max(max, stat[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }

        System.out.println(size(a));
    }
}
