public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == data.length;
    }

    private boolean isEmpty(){
        return end == 0;
    }

    public boolean push (int item){
        if (isFull()){
            System.out.println("Queue is full");
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove () throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty!!!");
        }
        int removed = data[0];

        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;

        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" <- ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        queue.remove();

        queue.display();

    }
}
