package ua.ithlillel.dnipro.Cherednychenko;

import java.util.Iterator;

public class MySet<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int curBucket = -1;
            private Node cur = null;

            @Override
            public boolean hasNext() {
                if (cur != null && cur.next != null) {
                    cur = cur.next;
                    return true;
                }
                for (++curBucket; curBucket < buckets.length; ++curBucket) {
                    if (buckets[curBucket] != null) {
                        cur = buckets[curBucket];
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                return (T) cur.value;
            }
        };
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }

    }

    private Node[] buckets;
    private int size = 0;

    public MySet(int size) {
        this.buckets = new Node[size];
    }

    public MySet() {
        this(16);
    }

    private Node findElem(T elem, int bucketIndex) {
        for (Node cur = buckets[bucketIndex]; cur != null; cur = cur.next) {
            if (cur.value.equals(elem))
                return cur;
        }
        return null;
    }

    /*private void appendOrReplace(T elem, int bucketIndex){
        Node prev=null;
        for (Node cur = buckets[bucketIndex]; cur != null; cur = cur.next) {
            if (cur.value.equals(elem))
            {
                cur.value=elem;
                return;
            }
            prev=cur;
        }
        if (prev == null) {

            buckets[bucketIndex] = new Node (elem);
        }
        else{
            prev.next=new Node (elem);
        }
    }*/

    public void add(T elem) {
        int index = getIndex(elem);
        Node existElem = findElem(elem, index);
        if (existElem != null) {
            existElem.value = elem;
        } else {
            Node newNode = new Node(elem);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }
    }

    private int getIndex(T elem) {
        int hash = elem.hashCode();
        hash = hash > 0 ? hash : -hash;
        return hash % buckets.length;
    }

    public T find(T elem) {
        int index = getIndex(elem);
        Node existElem = findElem(elem, index);
       return existElem!=null? (T)existElem.value:null;
    }

    public boolean contains(T elem) {
        int index = getIndex(elem);
        Node existElem = findElem(elem, index);
        return existElem != null;
    }
    public T get(int index) {
        int i = 0;

        for (T t : this) {
            if (i == index) return t;
            i++;
        }
        return null;
    }


}
