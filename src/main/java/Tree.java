import javafx.util.Pair;

public class Tree {
    public Node root;

    public static class Node {
        public String data;
        public Node left;
        public Node right;

        public Node(String data) {
            this.data = data;
        }
    }

//    public int findMin(Node root) {
//        if (root.left != null) {
//           return findMin(root.left);
//        }
//        else {
//            return root.data;
//        }
//    }
//    public int findMax(Node root) {
//        if (root.right != null) {
//           return findMin(root.right);
//        }
//        else {
//            return root.data;
//        }
//    }
//
//    public int findMinIt(Node root) {
//        if (root == null) return -1; //it's empty
//        Node actual = root;
//        while (actual.left != null) {
//            actual = actual.left;
//        }
//        return actual.data;
//    }
//
//    //is root local variable? check
//    public int findMinIt(Node root) {
//        while (root.left != null) {
//            root = root.left;
//        }
//        return root.data;
//    }

//    public int findHeight(Node root, int h, max) {
//        h++;
//        if (root.left == null && root.left == null) {
//            return;
//        }
//        if (root.left !== null) {
//            findHeight(root.left, h);
//        }
//    }

    public void insertPair(String firstName, String secondName) throws InterruptedException {
        if (root == null) {
            root = new Node(firstName);
            Node secondNode = new Node(secondName);
            root.left = secondNode;
        }
        else {
            Node mainNode =  retrieveNode(root, firstName);
            Node newNode = new Node(firstName);
            if (mainNode == null) {
                mainNode = newNode;
            }
            else {
                if (mainNode.left == null) {
                    mainNode.left = newNode;
                    return;
                }
                else if (mainNode.right == null) {
                    mainNode.right = newNode;
                    return;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private Node retrieveNode(Node root, String firstName) {
        Node left;
        Node right;
        if (root == null) return null;

        left = retrieveNode(root.left, firstName);
        right = retrieveNode(root.right, firstName);

        if (root.data.equals(firstName)) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;
    }

    public void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);

        preOrder(root.left);
        preOrder(root.right);
    }


    public int twoParrent(Node root,String firstname,String secondName){
        Node actualNode = root;
        int leftValue;
        int rightValue;

        if (actualNode == null) return 0;

        leftValue = twoParrent(actualNode.left,firstname,secondName);
        rightValue = twoParrent(actualNode.right,firstname,secondName);

        if (leftValue + rightValue == 2) {
            System.out.println(actualNode.data);
        }
        if (actualNode.data.equals(firstname) || actualNode.data.equals(firstname)) {
            return 1;
        }

        return leftValue + rightValue;

    }
    public static void main(String[] args) throws InterruptedException {
        Tree tree = new Tree();

        tree.insertPair("Sarah", "Fred");
        tree.insertPair("Sarah", "Paul");
        tree.insertPair("Fred", "Hilary");
        tree.insertPair("Fred", "Jenny");
        tree.insertPair("Jenny", "James");
        tree.twoParrent(tree.root,"Hilary", "James");

        tree.preOrder(tree.root);
    }
}
