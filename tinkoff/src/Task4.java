import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        long minOperations = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long operationsX = (a[i] % x == 0) ? 0 : x - (a[i] % x);
            long operationsY = (a[i] % y == 0) ? 0 : y - (a[i] % y);
            long operationsZ = (a[i] % z == 0) ? 0 : z - (a[i] % z);

            long totalOperations = operationsX + operationsY + operationsZ;
            if (totalOperations < minOperations) {
                minOperations = totalOperations;
            }

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long operationsYj = (a[j] % y == 0) ? 0 : y - (a[j] % y);
                long operationsZj = (a[j] % z == 0) ? 0 : z - (a[j] % z);

                long totalOperationsCombined = Math.min(operationsX + operationsYj, Math.min(operationsX + operationsZj, operationsY + operationsZj));
                if (totalOperationsCombined < minOperations) {
                    minOperations = totalOperationsCombined;
                }
            }
        }

        System.out.println(minOperations);
    }
}