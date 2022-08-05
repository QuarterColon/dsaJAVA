import java.sql.SQLOutput;

public class DLL {

    private Node head;
    private Node tail;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if (head == null){
            node.prev = null;
            head = node;
            return;
        }
        while (last.next != null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public Node find(int after){
        Node node = head;
        while(node != null){
            if(node.val == after){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int val, int after){
        Node p = find(after);
        if (p == null){
            System.out.println("Does Not Exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if( node.next != null) {
            node.next.prev = node;
        }

    }
    public void display(){
        Node node = head;
        Node last = tail;
        while (node != null){
            System.out.print(node.val + "->");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        while (last != null){
            System.out.print(last.val+"->");
            last = last.prev;
        }

        System.out.println("START");
    }


    class Node{

        int val;
        Node next;
        Node prev;

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        DLL list = new DLL();

        list.insertFirst(3);
        list.insertFirst(8);
        list.insertFirst(10);
        list.insertFirst(15);
        list.insertFirst(20);
        list.insertLast(69);
        list.insert(7,3);

        list.display();
    }
}