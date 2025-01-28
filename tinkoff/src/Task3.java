import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int adj = 0;
        int goodDays = 0;

        for (int i = 2; i < n; i++) {
            if (a[i] >= a[0] && a[i] <= a[1]) {
                goodDays++;
            } else {
                int target = Math.max(a[0], Math.min(a[i], a[1]));
                adj += Math.abs(a[i] - target);
                goodDays++;
            }
            if (goodDays >= m) {
                break;
            }
        }

        System.out.println(adj);
    }
}