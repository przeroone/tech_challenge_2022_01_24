import java.util.regex.Pattern;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionTwo {
    private static void checkArguement(String[] args) {
        Pattern pattern = Pattern.compile("^\\d{0,1}$");
        if (args.length == 0 || !pattern.matcher(args[0]).matches()) {
            System.out.println("Invalid input. Please input a positive number from 0 to 9.");
            System.exit(0);
        }
    } 

    public static void main(String[] args) {
        checkArguement(args); // Validate input
        int n = Integer.parseInt(args[0]); // Parse input
        // Build binary tree
        BinaryTree bt = new BinaryTree();
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for(int i = 0; i < (Math.pow(2, n + 1) - 1); i++) {
            int v = rand.nextInt(1, 1000 + 1);
            bt.addNode(new Node(v));
        }
        bt.printNodesOfDepth(n);
    }
}
