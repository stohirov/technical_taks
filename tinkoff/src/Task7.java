import java.util.Scanner;

public class Task7 {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] sums = new long[n * (n - 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sums[index++] = a[i] + a[j];
            }
        }

        for (int p = 1; p <= k; p++) {
            long result = 0;
            for (long sum : sums) {
                result = (result + pow(sum, p, MOD)) % MOD;
            }
            System.out.println(result);
        }
    }

    static long pow(long base, int exponent, int mod) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent = exponent / 2;
        }
        return result;
    }
}