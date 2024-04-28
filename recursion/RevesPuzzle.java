public class RevesPuzzle {
    // num of discs, source, target, auxiliary
    private static void hanoi(int n, int k, char sor, char aux, char tar) {
        if (n == 0) return;
        // the bottom disk should be 'n', while the number first passed in is n-k
        // so, n = (n-k) + k
        else {
            // move n-1 discs to 'aux' (i.e. 'aux' used as tar), while 'tar' used as aux
            hanoi(n-1, k, sor, tar, aux);
            System.out.println("Move disc " + (n + k) + " from " + sor + " to " + tar);
            // move n-1 discs from 'aux' to 'tar', while 'sor' used as aux
            hanoi(n-1, k, aux, sor, tar);
        }
    }

    private static void reve(int n, char sor, char aux1, char aux2, char tar) {
        if (n == 0) return;
        else if (n == 1) {
            System.out.println("Move disc 1 from " + sor + " to " + tar);
            return;
        }
        else {
            int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
            // move k smallest discs from sor to aux1
            reve(k, sor, tar, aux2, aux1);
            // the rest n-k discs are transformed into hanoi problem
            // with 3 poles: sor, aux2, tar
            hanoi(n - k, k, sor, aux2, tar);
            // move k discs from 'aux1' to tar
            reve(k, aux1, sor, aux2, tar);
        }
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        //  A - source, B & C - auxiliary, D - target
        char a = 'A', b = 'B', c = 'C', d = 'D';
        
        // move from A to D
        reve(n, a, b, c, d);
    }
}
