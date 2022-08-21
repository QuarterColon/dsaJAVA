import yo.SudokuSolver;

public class LL{

    private Node head;
    private Node tail;
    private int size;

    public LL() {

        this.size = 0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){

        if(index == 0){
            insertFirst(val);
            return;
        }

        if (index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;

    }

    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node){
        if (index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;

    }



    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if (index == (size -1)){
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        if (f != null && second != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

            while (f != null) {
                ans.insertLast(f.value);
                f = f.next;
            }

            while (s != null) {
                ans.insertLast(s.value);
                s = s.next;
            }
            return ans;
        }

    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }

        return false;
    }

    public int lengthCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public Node detectStartNode(Node head){
        int length = 0;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = lengthCycle(slow);
                break;
            }
        }
        if (length == 0){
            return null;
        }

        fast = head;
        slow = head;

        while (length > 0){
            slow = slow.next;
            length--;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public boolean isHappy(int n){
        int s = n;
        int f = n;

        do{
            s = Square(s);
            f = Square(Square(f));
        } while(s != f);

        if (s == 1){
            return true;
        }
        return false;
    }
    private int Square(int n){
        int sum = 0;

        while(n>0){
            int r = n % 10;
            sum = r * r;
            n/=10;
        }
        return sum;
    }

    public Node middleNode(Node head){
        Node s = head;
        Node f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(9);
        list2.insertLast(14);

        LL ans = merge(list1, list2);

        ans.display();
    }
}