public class MyHeap <T extends Comparable<T>>  {

    MyArrayList<T> heap = new MyArrayList<>();

    public MyHeap() {
    }

    public void empty() {
        heap.clear();
    }

    public int size() {
        return heap.size();
    }

    public T getMax() {
        return heap.get(0);
    }

    public T extractMax() {
        T max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return max;
    }

    public void insert(T item) {
        heap.add(item);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i).compareTo(heap.get(parentOf(i))) > 0) {
            T temp = heap.get(i);
            heap.set(i, heap.get(parentOf(i)));
            heap.set(parentOf(i), temp);
            i = parentOf(i);
        }
    }

    private void heapify(int i) {
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
            T temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            heapify(largest);
        }
    }

    private void traverse(int i) {
        if (i < heap.size()) {
            System.out.println(heap.get(i));
            traverse(leftChildOf(i));
            traverse(rightChildOf(i));
        }
    }

    public int leftChildOf(int i) {
        return 2 * i + 1;
    }
    public int rightChildOf(int i) {
        return 2 * i + 2;
    }

    public int parentOf(int i) {
        return (i - 1) / 2;
    }

    public void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }




}
