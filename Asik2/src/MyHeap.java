public class MyHeap <T extends Comparable<T>>  {

    MyArrayList<T> heap = new MyArrayList<>(); // Based on ArrayList

    public MyHeap() { // Null constructor
    }

    public void empty() { // clear function
        heap.clear();
    }

    public int size() {
        return heap.size();
    } // size function

    public T getMax() { // first element
        return heap.get(0);
    }

    public T extractMax() { // gets max and swaps with last element then removes last element
        T max = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(0);
        return max;
    }

    public void insert(T item) { // inserts item to the end of the heap and puts it to the respective place
        heap.add(item);
        int i = heap.size() - 1;
        heapify(i);
    }

    private void heapify(int i) { // heapify function to maintain the heap property after deletion or insertion
        int left = leftChildOf(i);
        int right = rightChildOf(i);
        int largest = i;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(largest)) > 0) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void traverse(int i) { // traverse function to print the heap
        if (i < heap.size()) {
            System.out.println(heap.get(i));
            traverse(leftChildOf(i));
            traverse(rightChildOf(i));
        }
    }

    public int leftChildOf(int i) {
        return 2 * i + 1;
    } // returns left child though math

    public int rightChildOf(int i) {
        return 2 * i + 2;
    } // returns right child through math

    public int parentOf(int i) {
        return (i - 1) / 2;
    } // returns parent through math

    public void swap(int i, int j) { // swaps two elements
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }




}
