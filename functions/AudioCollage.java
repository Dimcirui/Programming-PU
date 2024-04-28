public class AudioCollage {

    // amplify the sound by multiplying alpha
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) b[i] = a[i] * alpha;
        return b;
    }

    // reverse the sound
    public static double[] reverse(double[] a) {
        int x = a.length;
        double[] b = new double[x];
        for (int i = 0; i < x; i++) b[x - i - 1] = a[i];
        return b;
    }

    // return the concatenation of two sounds
    public static double[] merge(double[] a, double[] b) {
        int x = a.length, y = b.length;
        double[] c = new double[x + y];
        for (int i = 0; i < x; i++) c[i] = a[i];
        for (int i = 0; i < y; i++) c[x + i] = b[i];
        return c;
    }

    // sum the values of the corresponding samples
    public static double[] mix(double[] a, double[] b) {
        int x = a.length, y = b.length;
        if (x < y) {
            double[] c = new double[y];
            for (int i = 0; i < y; i++) {
                c[i] = b[i];
            }
            for (int i = 0; i < x; i++) {
                c[i] += a[i];
            }
            return c;
        }
        else {
            double[] c = new double[x];
            for (int i = 0; i < x; i++) {
                c[i] = a[i];
            }
            for (int i = 0; i < y; i++) {
                c[i] += b[i];
            }
            return c;
        }
    }

    // n samples to ⌊n/a⌋ samples,
    public static double[] changeSpeed(double[] a, double alpha) {
        int newL = (int) (a.length / alpha);
        double[] b = new double[newL];
        for (int i = 0; i < newL; i++) b[i] = a[(int) (i * alpha)];
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] smp1 = StdAudio.read("beatbox.wav");
        double[] smp2 = StdAudio.read("chimes.wav");
        double[] smp3 = StdAudio.read("cow.wav");
        double[] smp4 = StdAudio.read("piano.wav");
        double[] smp5 = StdAudio.read("dialup.wav");
        double[] ed1 = amplify(smp1, 0.7);
        double[] ed2 = reverse(smp3);
        double[] ed3 = merge(ed1, ed2);
        double[] ed4 = changeSpeed(smp2, 1.25);
        double[] ed5 = mix(ed3, ed4);
        double[] ed6 = mix(smp4, smp5);
        double[] edfin = mix(ed5, ed6);
        StdAudio.play(edfin);
    }
}