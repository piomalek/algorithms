public class LCM {

    /**
     * LCM - Lowest Common Multiple
     */
    private static int lcm(int a, int b) {
        if(a == 0 || b == 0) return 0;
        return Math.abs(a*b) / GCD.gcd(a,b);
    }

    public static void main(String[] args) {
        int a = 256;
        int b = 144;

        System.out.println(String.format("lcm(%d, %d) = %d", a, b, lcm(a, b)));

        return;
    }
}
