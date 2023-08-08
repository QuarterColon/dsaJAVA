public class SegmentTree {
    private static class Node {
        int data;
        int start;
        int end;
        Node left;
        Node right;
        Node root;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void SegmentTree(int arr[]) {
            this.root = constructTree(arr, 0, arr.length - 1);
        }

        private Node constructTree(int arr[], int start, int end) {
            if (start == end) {
                Node leaf = new Node(start, end);
                leaf.data = start;
                return leaf;
            }

            Node node = new Node(start, end);

            int mid = (start + end) / 2;

            node.left = constructTree(arr, start, mid);
            node.right = constructTree(arr, mid + 1, end);

            node.data = node.left.data + node.right.data;
            return node;
        }
    }

}
