import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyStack<T>  {

    private MyLinkedList<T> stack = new MyLinkedList<>();

    public MyStack() {
    }

    public T top() {
        return (T) stack.getLast();
    }

    public T pop() {
        T item = stack.getLast();
        stack.removeLast();
        return item;
    }

    public void push(T item) {
        stack.addLast(item);
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }



}
