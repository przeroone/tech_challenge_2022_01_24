import java.util.regex.Pattern;
import java.math.BigInteger;

public class QuestionThree {
    static BigInteger combination(int n) {
        BigInteger[] c = new BigInteger[n + 1];
    
        c[0] = BigInteger.valueOf(1);
    
        for(int i = 1; i <= n; i++) {
            c[i] = BigInteger.valueOf(0);
            for(int j = 1; j <= 6; j++)
                if (i - j >= 0) c[i] = c[i].add(c[i - j]);
        }
    
        return c[n];
    }

    private static void checkArguement(String[] args) {
        Pattern pattern = Pattern.compile("^\\d{0,3}$");
        if (args.length == 0 || !pattern.matcher(args[0]).matches()) {
            System.out.println("Invalid input. Please input a positive number from 0 to 999.");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        checkArguement(args); // Validate input
        int n = Integer.parseInt(args[0]); // Parse input
        System.out.printf("There are %d ways to arrive exactly at the finishing point that is %d spaces away from the starting point.", combination(n), n); // Print result
    } 
}