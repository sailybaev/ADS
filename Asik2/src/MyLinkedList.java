import java.util.Iterator;
public class MyLinkedList implements MyList{

    class MyNode<E> {
        E element;
        MyNode next;
        MyNode prev;

        public MyNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }

        public MyNode(E element, MyNode next, MyNode prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public MyNode() {
            this.element = null;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;


    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }



    @Override
    public void add(Object item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, Object item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;
    }

    @Override
    public void add(int index, Object item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
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
    }

    @Override
    public void addFirst(Object item) {
        add(0, item);
    }

    @Override
    public void addLast(Object item) {
        add(item);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public Object getFirst() {
        return head.element;
    }

    @Override
    public Object getLast() {
        return tail.element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
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
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if ((int) i.element > (int) j.element) {
                    Object current = i.element;
                    i.element = j.element;
                    j.element = current;
                }
            }
        }
    }

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
    }

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
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.element;
            current = current.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Object next() {
                Object element = current.element;
                current = current.next;
                return element;
            }
        };
    }

}
