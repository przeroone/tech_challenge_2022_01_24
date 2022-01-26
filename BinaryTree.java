import java.util.ArrayList;

public class BinaryTree {
    Node root;
   
    public void addNode(Node node) {
        if (root == null) {
           this.root = node;
           return;
        }
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0) {
            Node currentNode = queue.get(0);
            queue.remove(0);
            if (currentNode.left == null) {
                currentNode.left = node;
                break;
            }
            queue.add(currentNode.left);
            if (currentNode.right == null) {
                currentNode.right = node;
                break;
            }
            queue.add(currentNode.right);
        }
    }

    private ArrayList<String> getChildren(Node node, int desiredDepth, int currentDepth, ArrayList<String> nodes) {
        int nextDepth = currentDepth + 1;
        for(Node currentNode: node.children()) {
            if (currentDepth == desiredDepth)
                nodes.add(String.valueOf(currentNode.getValue()));
            else if (currentDepth < desiredDepth)
                getChildren(currentNode, desiredDepth, nextDepth, nodes);
        }
        return nodes;
    }

    public void printNodesOfDepth(int depth) {
        ArrayList<String> nodes = new ArrayList<>();
        if (depth == 0)
            nodes.add(String.valueOf(root.getValue()));
        else
            nodes = getChildren(root, depth, 1, new ArrayList<String>());

        String printStr = "";
        if (nodes.isEmpty())
            printStr = "No node exists in depth %d";
        else 
            printStr = "Nodes in depth %d:\n" + String.join(", ", nodes);
        System.out.printf(printStr, depth);
    }
}