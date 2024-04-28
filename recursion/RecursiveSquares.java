public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, 0.5 * length);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, 0.5 * length);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        double halfL = 0.5 * length;
        draw(n - 1, x - halfL, y + halfL, halfL);
        draw(n - 1, x + halfL, y + halfL, halfL);
        drawSquare(x, y, length);
        draw(n - 1, x - halfL, y - halfL, halfL);
        draw(n - 1, x + halfL, y - halfL, halfL);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
