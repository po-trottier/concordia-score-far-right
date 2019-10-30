public class BinaryTree {

    private static Node root;

    public BinaryTree(int data)
    {
        root = new Node(data);
    }

    public void add(Node parent, Node child, String side)
    {
        if (side.equals("left"))
        {
            parent.setLeft(child);
        }
        else
        {
            parent.setRight(child);
        }
    }


    class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }



        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getRight() {
            return right;
        }
    }

}
