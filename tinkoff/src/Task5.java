import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + a[i];
        }

        long total = 0;

        for (int i = 0; i < n; i++) {
            for (int r = i; r < n; r++) {
                int sumSegment = prefix[r + 1] - prefix[i];
                int f = (sumSegment + s - 1) / s;
                total += f;
            }
        }

        System.out.println(total);
    }
}
