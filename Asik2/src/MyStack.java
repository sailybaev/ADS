import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyStack<T>  {

    private MyLinkedList<T> stack = new MyLinkedList<>(); // based on linked list

    public MyStack() { // constructor
    }

    public T top() { // top element
        return (T) stack.getLast();
    }

    public T pop() { // gets top element and removes it
        T item = stack.getLast();
        stack.removeLast();
        return item;
    }

    public void push(T item) {
        stack.addLast(item);
    } // adds elements to the top of the stack

    public boolean isEmpty() {
        return stack.size() == 0;
    } // checks if the stack is empty

    public int size() {
        return stack.size();
    } // size function

    public void clear() {
        stack.clear();
    } // clear function



}
