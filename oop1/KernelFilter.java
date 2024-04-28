import java.awt.Color;

public class KernelFilter {
    private static Picture filter(Picture picture, double[][] weights, int scale) {
        int halfscale = scale / 2;
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);

        // Processing
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                double sumR = 0;
                double sumG = 0;
                double sumB = 0;
                for (int i = -halfscale; i <= halfscale; i++) {
                    for (int j = -halfscale; j <= halfscale; j++) {
                        // n is the maximum number of downward crossings allowed
                        // int n = (scale / 2) / Math.min(w, h);
                        // In most cases, n = 1 is enough.
                        int n = 1;
                        Color color = picture.get((col + i + n * w) % w, (row + j + n * h) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();

                        sumR += r * weights[i + halfscale][j + halfscale];
                        sumG += g * weights[i + halfscale][j + halfscale];
                        sumB += b * weights[i + halfscale][j + halfscale];
                    }
                }
                
                


                // Rounding
                int fiR = (int) Math.round(sumR);
                int fiG = (int) Math.round(sumG);
                int fiB = (int) Math.round(sumB);
                // Clamping
                if (fiR > 255) fiR = 255;
                else if (fiR < 0) fiR = 0;
                if (fiG > 255) fiG = 255;
                else if (fiG < 0) fiG = 0;
                if (fiB > 255) fiB = 255;
                else if (fiB < 0) fiB = 0;

                Color newColor = new Color(fiR, fiG, fiB);
                target.set(col, row, newColor);
            }
        }
        return target;
    }

    public static Picture identity(Picture picture) {
        return picture;
    }

    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                                {1.0 / 16, 2.0 / 16, 1.0 / 16},
                                {2.0 / 16, 4.0 / 16, 2.0 / 16},
                                {1.0 / 16, 2.0 / 16, 1.0 / 16}
                            };
        return filter(picture, weights, weights.length);
    }

    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                                {0, -1, 0},
                                {-1, 5, -1},
                                {0, -1, 0}
                            };
        return filter(picture, weights, weights.length);
    }

    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                                {-1, -1, -1},
                                {-1, 8, -1},
                                {-1, -1, -1}
                            };
        return filter(picture, weights, weights.length);
    }

    public static Picture emboss(Picture picture) {
        double[][] weights = {
                                {-2, -1, 0},
                                {-1, 1, 1},
                                {0, 1, 2}
                            };
        return filter(picture, weights, weights.length);
    }

    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) weights[i][j] = 1.0 / 9;
            }
        }
        return filter(picture, weights, weights.length);
    }
    
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);

        Picture id = identity(source);
        id.show();

        Picture gau = gaussian(source);
        gau.show();

        Picture shar = sharpen(source);
        shar.show();

        Picture lap = laplacian(source);
        lap.show();

        Picture emb = emboss(source);
        emb.show();

        Picture motB = motionBlur(source);
        motB.show();
    }
}
