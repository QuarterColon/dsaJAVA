

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item){

        if(isFull()){
            System.out.println("Stack is full.");
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
    public boolean isFull(){
        return ptr == data.length - 1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

    public int pop() throws Exception{
        if (isEmpty()){
            throw new Exception("Cannot pop from an EMPTY STACK");
        }
        return data[ptr--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an EMPTY STACK");
        }
        return data[ptr];
    }
    public static void main(String[] args) throws Exception{
        CustomStack stack = new DynamicStack();
        stack.push(13);
        stack.push(74);
        stack.push(98);
        stack.push(46);
        stack.push(67);
        stack.push(95);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }


}
