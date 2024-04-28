public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int num = 0;
        int max = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            String codon = dna.substring(i, i+3);
            if (codon.equals("CAG")) {
                i += 2;
                num++;
                max = Math.max(max, num);
            }
            else num = 0;
        }
        return max;
    }
    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\t", "");
        return s.replace("\n", "");
    }
    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats > 180) return "not human";
        else if (maxRepeats <= 35) return "normal";
        else if (maxRepeats <= 39) return "high risk";
        else return "Huntington's";
    }
    
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String raw = in.readAll();
        String dna = removeWhitespace(raw);

        int repeats = maxRepeats(dna);
        System.out.println("max repeats = " + repeats);
        System.out.println(diagnose(repeats));
    }
}
