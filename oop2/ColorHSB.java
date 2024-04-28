public class ColorHSB {
    private static final int UPPER_H = 359, UPPER_SB = 100;
    private final int hue, satu, bri;

    // Creates a HSB color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        hue = h;
        satu = s;
        bri = b;

        if (h < 0 || h > UPPER_H) throw new IllegalArgumentException("The hue must be between 0 and " + (UPPER_H));
        if (s < 0 || s > UPPER_SB) throw new IllegalArgumentException("The saturation must be between 0 and " + (UPPER_SB));
        if (b < 0 || b > UPPER_SB) throw new IllegalArgumentException("The brightness must be between 0 and " + (UPPER_SB));
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + satu + ", " + bri + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (satu * bri == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("Please input at least one color");
        int h2 = that.hue;
        int s2 = that.satu;
        int b2 = that.bri;
        return Math.min((hue - h2) * (hue - h2), (UPPER_H + 1 - Math.abs(hue - h2)) * (UPPER_H + 1 - Math.abs(hue - h2)))
                + (satu - s2) * (satu - s2) + (bri - b2) * (bri - b2);
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(h, s, b);

        int minDist = UPPER_H * UPPER_SB * UPPER_SB;
        ColorHSB nearC = color;
        String nearName = "";

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            h = StdIn.readInt();
            s = StdIn.readInt();
            b = StdIn.readInt();
            ColorHSB preC = new ColorHSB(h, s, b);

            if (minDist > color.distanceSquaredTo(preC)) {
                minDist = color.distanceSquaredTo(preC);
                nearC = preC;
                nearName = name;
            }
        }

        System.out.println(nearName + " " + nearC);
    }
}
