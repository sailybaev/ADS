import java.util.Iterator;
public class BST<K extends Comparable<K> , V> implements Iterable<K> {
    private class Node{
        private K key;
        private V value;
        private int length = 1;
        private Node left;
        private Node right;
        public Node(K key , V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getLength(Node nodel) {
        return nodel.length;
    }

    public BST() {
        root = null;
        size = 0;
    }
    private Node root;
    private int size;

    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
            return;
        }

        Node current = root;


        while (true) {
            if (key.compareTo(current.key) < 0) {

                if (current.left != null) current = current.left;

                else {
                    current.left = new Node(key, value);
                    size++;
                    return;
                }

            }

            else if (key.compareTo(current.key) > 0) {

                if (current.right != null) current = current.right;

                else {
                    current.right = new Node(key, value);
                    size++;
                    return;
                }
            }

            else {
                current.value = value;
                current.length--;
                return;
            }

        }

    }

    public V get(K key) {
        return get(root , key);
    }

    private V get(Node node , K key) {

        if(node == null) return null;

        while(node != null) {

            if(key.compareTo(node.key) < 0) node = node.left;

            else if(key.compareTo(node.key) > 0) node = node.right;

            else return node.value;

        }

        return null;
        
    }

    public void delete(K key) {
        if (root == null) return;

        Node par = null;
        Node current = root;
        boolean chl = false;

        while (current != null) {
            current.length--;
            if (key.compareTo(current.key) < 0) {
                par = current;
                current = current.left;
            }
            else if (key.compareTo(current.key) > 0) {
                par = current;
                current = current.right;
            }

            else {
                if (current.left != null && current.right != null) {
                    chl = true;
                    Node temp = current;
                    par = current;
                    current = current.right;

                    while (current.left != null) {
                        par = current;
                        current = current.left;
                    }

                    temp.key = current.key;
                    temp.value = current.value;
                    current.length++;
                }
                break;
            }

        }

        if (current == null) return;


        Node a;
        if (current.left != null) a = current.left;
        else if (current.right != null) a = current.right;
        else a = null;

        if (par == null) root = a;
        else if (par.left == current) par.left = a;
        else par.right = a;

        if (!chl) size--;

    }

    public Node getNode(K key) {
        return getNode(root , key);
    }
    public Node getNode(Node node , K key) {
        if(node == null) return null;

        while(node != null) {

            if(key.compareTo(node.key) < 0) node = node.left;

            else if(key.compareTo(node.key) > 0) node = node.right;

            else return node;

        }

        return null;
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