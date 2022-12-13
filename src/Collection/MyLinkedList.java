package Collection;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    private static class Node<E> {
        public Node(E d, Node<E> p, Node<E> n) {
            data = d;
            prev = p;
            next = n;
        }

        public E data;
        public Node<E> prev;
        public Node<E> next;
    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(E element) {
        add(size(), element);
        return true;
    }

    public void add(int id, E element) {
        addBefore(getNode(id), element);
    }

    public E get(int id) {
        return getNode(id).data;
    }

    public E set(int id, E newVal) {
        Node<E> p = getNode(id);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public E remove(int id) {
        return remove(getNode(id));
    }

    private void addBefore(Node<E> p, E element) {
        Node<E> newNode = new Node<>(element, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private E remove(Node<E> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    private void checkForBound(int id) {
        if (id < 0 || id > size()) throw new IndexOutOfBoundsException();
    }

    private Node<E> getNode(int id) {
        checkForBound(id);
        Node<E> p;

        if (id < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < id; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > id; i--) {
                p = p.prev;
            }
        }
        return p;

    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext(){
            return current!=endMarker;
        }

        public E next(){
            if(modCount!=expectedModCount) throw new ConcurrentModificationException();
            if(!hasNext()) throw new NoSuchElementException();

            E nextItem = current.data;
            current = current.next;
            okToRemove=true;
            return nextItem;
        }

        public void remove(){
            if (modCount!=expectedModCount) throw new ConcurrentModificationException();
            if(!okToRemove) throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }


}
