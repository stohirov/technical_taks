class Main {
    static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in)
            int numberOfInputs = scanner.nextInt()

            if (numberOfInputs == 0) {
                println "Invalid length!"
                return
            }

            int[] numbersToCheck = getInputsIntoArray(numberOfInputs, scanner)
            printNumberFrequencies(numbersToCheck)

        } catch (InputMismatchException ex) {
            println "Couldn't read that string as a number bro!"
        }
    }

    static int[] getInputsIntoArray(int numberOfInputs, Scanner scanner) {
        int[] numbers = new int[numberOfInputs]
        for (int i = 0; i < numberOfInputs; i++) {
            numbers[i] = scanner.nextInt()
        }
        return numbers
    }

    static void printNumberFrequencies(int[] numbers) {
        Map<Integer, Integer> frequencyMap = [:]
        numbers.each { num ->
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }
        frequencyMap.each { key, value ->
            println "$key -> $value"
        }
    }
}
