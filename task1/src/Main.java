import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // with try, for the cases where user can input string unintentionally
        try(Scanner scanner = new Scanner(System.in)) {

            int numberOfInputs = scanner.nextInt();

            if (numberOfInputs == 0) {
                System.out.println("Invalid length!");
                return;
            }

            int[] numbersToCheck = getInputsIntoArray(numberOfInputs, scanner);
            printNumberFrequencies(numbersToCheck);

        } catch (InputMismatchException ex) {
            System.out.println("Couldn't read that string as a number bro!");
        }

    }

    // function that will initialize our array that should be checked
    // and fills it with the numbers that we read from input
    private static int[] getInputsIntoArray(int numberOfInputs, Scanner scanner) {
        int[] numbers = new int[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    private static void printNumberFrequencies(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            // getOrDefault will help us to whether select default value or the existing one
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        frequencyMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

}
