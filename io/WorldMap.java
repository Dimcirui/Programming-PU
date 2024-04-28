public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int n = StdIn.readInt();
            double[] x = new double[n];
            double[] y = new double[n];
                for (int i = 0; i < n; i++) {
                    x[i] = StdIn.readDouble();
                    y[i] = StdIn.readDouble();
                }
            StdDraw.polygon(x, y);
        }
    }
}
