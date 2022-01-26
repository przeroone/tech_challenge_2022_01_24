import java.util.regex.Pattern;
import java.math.BigInteger;

public class QuestionOne {
    private static BigInteger f(int n, BigInteger previousAccumulator, BigInteger currentAccumulator) {
        if (n == 0) return previousAccumulator;
        if (n == 1) return currentAccumulator;
        return f(n - 1, currentAccumulator, previousAccumulator.add(currentAccumulator));
    }

    private static void checkArguement(String[] args) {
        Pattern pattern = Pattern.compile("^\\d{0,4}$");
        if (args.length == 0 || !pattern.matcher(args[0]).matches()) {
            System.out.println("Invalid input. Please input a positive number from 0 to 9,999.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        checkArguement(args); // Validate input
        int n = Integer.parseInt(args[0]); // Parse input
        System.out.printf("f(%d) = %d", n, f(n, BigInteger.valueOf(0), BigInteger.valueOf(1))); // Print result
    }
}