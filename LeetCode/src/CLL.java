public class CLL {
    private Node head;
    private Node tail;



    public void insert(int value){
        Node node = new Node(value);

        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int value){
        Node node = head;
        if (node == null){
            return;
        }

        if(node.val == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if (n.val == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public void display(){
        Node node = head;
        if (head != null){
            do{
                System.out.print(node.val+"->");
                node = node.next;
            } while (node != head);
        }
    }

    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.delete(4);

        list.display();
    }


}
