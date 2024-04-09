import java.util.Iterator;

public class MyArrayList implements MyList {

    private Object[] arr;
    private int length = 0;
    private static final int DEFAULT_CAPACITY = 10;


    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        arr = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }


    private void increaseCapacity() {
        Object[] temp = new Object[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }


    @Override
    public void add(Object item) {
        if (length == arr.length) {
            increaseCapacity();
        }
        arr[length++] = item;
    }

    @Override
    public void set(int index, Object item) {
        arr[index] = item;
    }

    @Override
    public void add(int index, Object item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
        if (length == arr.length) {
            increaseCapacity();
        }
        System.arraycopy(arr, index, arr, index + 1, length - index);
        arr[index] = item;
        length++;
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
        return arr[index];
    }

    @Override
    public Object getFirst() {
        return arr[0];
    }

    @Override
    public Object getLast() {
        return arr[length - 1];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
        int numMoved = length - index - 1;
        if (numMoved > 0) {
            System.arraycopy(arr, index + 1, arr, index, numMoved);
        }
        arr[--length] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((int) arr[i] > (int) arr[j]) {
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[length];
        System.arraycopy(arr, 0, temp, 0, length);
        return temp;
    }

    @Override
    public void clear() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public Object next() {
                return arr[index++];
            }
        };

    }
}