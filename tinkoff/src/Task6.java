import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        System.out.println(maxHappyTriples(n, points));
    }

    public static int maxHappyTriples(int n, int[][] points) {
        boolean[] used = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if (used[j]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (used[k]) continue;
                    if (!isCollinear(points[i], points[j], points[k])) {
                        used[i] = used[j] = used[k] = true;
                        count++;
                        break;
                    }
                }
                if (used[i]) break;
            }
        }

        return count;
    }

    private static boolean isCollinear(int[] p1, int[] p2, int[] p3) {
        return (p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1])) == 0;
    }
}