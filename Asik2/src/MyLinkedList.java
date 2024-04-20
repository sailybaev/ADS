import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T>{

    class MyNode<E> {
        E element; // The data of the node
        MyNode next; // The reference to the next node
        MyNode prev; // The reference to the previous node

        public MyNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        } // Constructor with one parameter (element)

        public MyNode(E element, MyNode next, MyNode prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        } // Constructor with three parameters (element, next, prev)

        public MyNode() {
            this.element = null;
            this.next = null;
            this.prev = null;
        } // Constructor with no parameter
    } // Node class

    private MyNode head; // The reference to the first node
    private MyNode tail; // The reference to the last node
    private int size; // The number of elements in the list


    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    } // Constructor with no parameter



    private void checkCap(int index) {
        if(index < 0|| index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    } // Checks if the given index is in the range of the list.

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    } // Appends the specified element to the end of this list

    @Override
    public void set(int index, T item) {
        checkCap(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;
    } // Replaces the element at the specified position in this list with the specified element

    @Override
    public void add(int index, T item) {
        checkCap(index);
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            MyNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
    } // Inserts the specified element at the specified position in this list

    @Override
    public void addFirst(T item) {
        add(0, item);
    } // Inserts the specified element at the beginning of this list

    @Override
    public void addLast(T item) {
        add(item);
    } // Appends the specified element to the end of this list

    @Override
    public T get(int index) {
        checkCap(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.element;
    } // Returns the element at the specified position in this list

    @Override
    public T getFirst() {
        return (T) head.element;
    } // Returns the first element in this list

    @Override
    public T getLast() {
        return (T) tail.element;
    }// Returns the last element in this list

    @Override
    public void remove(int index) {
        checkCap(index);
        if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    } // Removes the element at the specified position in this list

    @Override
    public void removeFirst() {
        remove(0);
    } // Removes the first element from this list

    @Override
    public void removeLast() {
        remove(size - 1);
    } // Removes the last element from this list

    @Override
    public void sort() {
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (((Comparable)j.element).compareTo(i.element) < 0) {
                    Object current = i.element;
                    i.element = j.element;
                    j.element = current;
                }
            }
        }
    } // Sorts the elements of this list in ascending order




    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(object)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    } // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(object)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    } // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    } // Returns true if this list contains the specified element

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.element;
            current = current.next;
        }
        return arr;
    } // Returns an array containing all of the elements in this list in proper sequence

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    } // Removes all of the elements from this list

    @Override
    public int size() {
        return size;
    } // Returns the number of elements in this list

    @Override
    public Iterator iterator() {
        return new MyIterator();
    } // Returns an iterator over the elements in this list in proper sequence

    public class MyIterator implements Iterator<T> {
        private MyNode current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext() != true) {
                throw new NoSuchElementException();
            }
            T element = (T) current.element;
            current = current.next;
            index++;
            return element;
        }
    } // Iterator class

}
