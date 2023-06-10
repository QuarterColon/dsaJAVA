import java.util.Scanner;

class BinaryTrees {
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner in){
        System.out.println("Enter the root node:");
        int value = in.nextInt();
        root = new Node(value);
        populate(in, root);
    }

    private void populate(Scanner in, Node node){
        System.out.println("Enter left of"+ node.value+ "?");
        Boolean left = in.nextBoolean();
        if (left) {
            System.out.println("Enter value:");
            int value = in.nextInt();
            node.left = new Node(value);
            populate(in, node.left);
        }

        System.out.println("Enter left of"+ node.value+ "?");
        Boolean right = in.nextBoolean();
        if (right) {
            System.out.println("Enter value:");
            int value = in.nextInt();
            node.right = new Node(value);
            populate(in, node.right);
        }
    }
}