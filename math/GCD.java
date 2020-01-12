public class GCD {
    /**
     * GCD - Greatest Common Divisor
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

    public static void main(String[] args) {
        int a = 256;
        int b = 144;

        System.out.println(String.format("gcd(%d, %d) = %d", a, b, gcd(a, b)));

        return;
    }
}
