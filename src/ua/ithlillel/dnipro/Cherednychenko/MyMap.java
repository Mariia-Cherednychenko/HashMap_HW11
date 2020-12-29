package ua.ithlillel.dnipro.Cherednychenko;


public class MyMap<K, V> {

    /*private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
*/

    private MySet <Pair<K, V>> pairSet = new MySet<>();


    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return key.equals(pair.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }


   /* private Node[] buckets;
    private int size = 0;

    public MyMap(int size) {
        this.buckets = new Node[size];
    }

    public MyMap() {
        this(16);
    }*/


    public void put(K key, V value) {
        Pair<K, V> elem = new Pair(key, value);

       /* int index = getIndex((Pair<K, V>) elem);
        Node existElem = findElem(elem, index);
        if (existElem != null) {
            existElem.value = elem;
        } else {
            Node newNode = new Node(elem);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }*/
        pairSet.add(elem);
    }

   /* private int getIndex(Pair<K, V> elem) {
        int hash = elem.hashCode();
        hash = hash > 0 ? hash : -hash;
        return hash % buckets.length;
    }*/

    public boolean contains(K key) {
        Pair<K, V> elem = new Pair<>(key, null);

        /*int index = getIndex((Pair<K, V>) elem);
        Node existElem = findElem(elem, index);
        return existElem != null;*/
        return pairSet.contains(elem);
    }

    public V get(K key) {
        Pair<K, V> elem = new Pair<>(key, null);
       /* int index = getIndex((Pair<K, V>) elem);
        Node existElem = findElem(elem, index);
        if (existElem != null) return ((Pair<K, V>) existElem.value).value;
        else return null;*/
       return pairSet.find(elem).value;

    }

    public MySet<Pair<K,V>> pairSet(){
        return this.pairSet;
    }

    /*private Node findElem(Pair<K, V> elem, int bucketIndex) {
        for (Node cur = buckets[bucketIndex]; cur != null; cur = cur.next) {
            if (cur.value.equals(elem))
                return cur;
        }
        return null;
    }*/


}
