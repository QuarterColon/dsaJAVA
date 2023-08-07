public class AVL {
    public class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public AVL(){

    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(Node node){
        return node==null;
    }

    public void display(){
        display(root, "Root node:");
    }

    public void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);

        display(node.left, "left child of"+node.value+":");
        display(node.right,"right child of"+node.value+":");
    }

    private Node insert(int value, Node node){
        if (node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return rotate(node);
    }

    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // right - right
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

        }
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // left-left
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right - right
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if (node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
}
