import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(s.indexOf("R") < s.indexOf("M") ? "Yes" : "No");
    }
}
