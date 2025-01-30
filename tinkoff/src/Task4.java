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

    private static String s = """
            Сначала программа считывает входные данные: размер массива n, числа x, y, z, а затем сам массив a из n элементов. После этого она инициализирует переменную minOperations максимально возможным значением, чтобы в дальнейшем сравнивать с ней количество операций.
            
            Основная логика программы заключается в двух вложенных циклах. Внешний цикл проходит по каждому элементу массива a[i]. Для каждого элемента вычисляется количество операций, необходимых для того, чтобы он стал делиться на x, y и z. Например, для x это вычисляется как x - (a[i] % x), если a[i] не делится на x, иначе — 0. Аналогично вычисляются операции для y и z. Затем сумма этих операций сравнивается с текущим значением minOperations, и если она меньше, то minOperations обновляется.
            
            Далее идет внутренний цикл, который также проходит по массиву, но уже для комбинирования операций. Для каждого другого элемента a[j] (кроме текущего a[i]) вычисляются операции, чтобы сделать его делимым на y и z. Затем программа рассматривает три возможные комбинации операций:\s
            1. Сделать a[i] делимым на x, а a[j] — на y.
            2. Сделать a[i] делимым на x, а a[j] — на z.
            3. Сделать a[i] делимым на y, а a[j] — на z.
            
            Из этих комбинаций выбирается минимальное значение, и если оно меньше текущего minOperations, то minOperations обновляется.
            """;
}