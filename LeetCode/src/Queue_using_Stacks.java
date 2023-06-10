import java.util.Stack;

public class Queue_using_Stacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public Queue_using_Stacks() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();

        while (!second.isEmpty()){
            first.push(second.pop());
        }

        return removed;
    }
    
    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();

        while (!second.isEmpty()){
            first.push(second.pop());
        }

        return peeked;
    }
    
    public boolean empty() {

        return first.isEmpty();
    }
}

