import java.util.Iterator;
public class BST<K extends Comparable<K> , V> implements Iterable<K> {
    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;
        public Node(K key , V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST() {
        root = null;
        size = 0;
    }
    private Node root;
    private int size;

    public void put(K key , V value) {
        root = put(root , key , value);
        size++;
    }
    private Node put(Node node , K key , V value) {
        if(node == null) {
            size++;
            return new Node(key , value);
        }
        if(key.compareTo(node.key) < 0) node.left = put(node.left , key , value);

        else if(key.compareTo(node.key) > 0) node.right = put(node.right , key , value);

        else node.value = value;

        return node;
    }

    public V get(K key) {
        return get(root , key);
    }
    private V get(Node node , K key) {

        if(node == null) return null;

        if(key.compareTo(node.key) < 0) return get(node.left , key);

        else if(key.compareTo(node.key) > 0) return get(node.right , key);

        else return node.value;

    }

    public void delete(K key) {
        root = delete(root , key);
        size--;
    }
    private Node delete(Node node , K key) {
        if(node == null) return null;

        if(key.compareTo(node.key) < 0) node.left = delete(node.left , key);

        else if(key.compareTo(node.key) > 0) node.right = delete(node.right , key);

        else {
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;

            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        return node;
    }

    private Node min(Node node) {
        if(node.left == null) return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(K key) {
        return get(key) != null;
    }

    public Iterator<K> iterator(){
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<K> {
        private MyQueue<K> queue = new MyQueue<>();
        public BSTIterator() {
            inOrder(root);
        }
        private void inOrder(Node node) {
            if(node == null) return;
            inOrder(node.left);
            queue.enqueue(node.key);
            inOrder(node.right);
        }
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        public K next() {
            return queue.dequeue();
        }
    }




}