public class MyHashTable <K , V>{

    private HashNode<? , ?>[] buckets;
    private int M = 11;
    private Double loadFactor = 0.75;
    private int size = 0;
    public MyHashTable(){
        this.buckets = new HashNode[M];
    }

    public MyHashTable(int initialCapacity){
        this.M = (int) (initialCapacity * loadFactor);
        this.buckets = new HashNode[M];
    }

    public int getM() {
        return M;
    }

    public int countElements(int index){
        int count = 0;
        HashNode<?,?> temp = buckets[index];
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    private int hash(K key) {
        int index = (key.hashCode() & 0x7fffffff) % M;
        return index ;
    }

    public void increaseCapacity() {
        M = M * 2;
        HashNode<? , ?>[] temp = buckets;
        buckets = new HashNode[M];
        for(int i = 0 ; i < temp.length ; i++) {
            if(temp[i] != null) {
                HashNode<? , ?> node = temp[i];
                while(node != null) {
                    put((K) node.key , (V) node.value);
                    node = node.next;
                }
            }
        }
    }

    public void put(K key , V value) {
        if((double) size / M > loadFactor) {
            increaseCapacity();
        }
        int index = hash(key);
        HashNode<K , V> newNode = new HashNode<>(key , value);
        if(buckets[index] == null) {
            buckets[index] = newNode;
            size++;
            return;
        }
        else {
            HashNode<? , ?> temp = buckets[index];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
            return;
        }
    }

    public V get(K key) {
        int index = hash(key);
        while(buckets[index] != null) {
            if(buckets[index].key.equals(key)) {
                return (V) buckets[index].value;
            }
            buckets[index] = buckets[index].next;
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<?,?> temp = buckets[index];
        HashNode<?,?> prev = null;
        while(temp != null) {
            if(temp.key.equals(key)) {
                if(prev == null) {
                    buckets[index] = temp.next;
                }
                else {
                    prev.next = temp.next;
                }
                return (V) temp.value;
            }
            prev = temp;
            temp = temp.next;
        }
        size--;
        return null;
    }

    public boolean contains(K key) {
        int index = hash(key);

        while(buckets[index] != null) {
            if(buckets[index].key.equals(key)) {
                return true;
            }
            buckets[index] = buckets[index].next;
        }
        return false;
    }

    public K getKey(V value) {
        for(int i = 0 ; i < M ; i++) {
            if(buckets[i] != null) {
                if(buckets[i].value.equals(value)) {
                    return (K) buckets[i].key;
                }
            }
        }
        return null;
    }

    public int size(){
        return size;
    }
    public class HashNode<K, V> {
        K key;
        V value;
        HashNode<?, ?> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
         public String toString() {
            return "{" + key + " : " + value + "}";
        }
    }

}
