import java.util.ArrayList;

public class Node {
   Node left;
   Node right;
   int value; 

   Node(int value) { this.value = value; }

   public int getValue() { return value; }

   public void setLeftNode(Node node) { this.left = node; }

   public void setRightNode(Node node) { this.right = node; }

   public ArrayList<Node> children() {
       ArrayList<Node> ch = new ArrayList<>();
       if (left != null) ch.add(left);
       if (right != null) ch.add(right);
       return ch;
   }
}
