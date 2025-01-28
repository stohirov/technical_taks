import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            long ai = scanner.nextLong();
            nums[i] = ai;
        }

        for (long num: nums) {
            long maxCost = findMaxBouquetCost(num);
            System.out.println(maxCost);
        }
    }

    private static long findMaxBouquetCost(long ai) {
        if (ai < 7) {
            return -1;
        }

        long maxCost = 0;
        for (int x = 60; x >= 0; x--) {
            long cost = (1L << x);
            if (cost > ai) {
                continue;
            }
            long remaining = ai - cost;
            long y = findMaxPowerOfTwo(remaining);
            if (y == -1) {
                continue;
            }
            long z = findMaxPowerOfTwo(remaining - y);
            if (z == -1) {
                continue;
            }
            long total = cost + y + z;
            if (total > maxCost) {
                maxCost = total;
            }
        }

        return maxCost == 0 ? -1 : maxCost;
    }

    private static long findMaxPowerOfTwo(long num) {
        if (num < 1) {
            return -1;
        }
        return Long.highestOneBit(num);
    }
}