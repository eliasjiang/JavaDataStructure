package Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private E[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public E get(int id) {
        checkForBound(id);
        return theItems[id];
    }

    public E set(int id, E newVal) {
        checkForBound(id);
        E old = theItems[id];
        theItems[id] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) return;

        E[] old = theItems;
        theItems = (E[]) new Object[newCapacity];

        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(E element){
        add(size(),element);
        return true;
    }

    public void add(int id,E element){
        if(theItems.length==size()) ensureCapacity(size()*2+1);
        for (int i = theSize; i >id ; i--) {
            theItems[i] = theItems[i-1];

        }
        theItems[id] = element;
        theSize++;
    }

    public E remove(int id){
        checkForBound(id);
        E removedItem = theItems[id];
        for (int i = id; i < size()-1; i++) {
            theItems[i] = theItems[i+1];
        }
        theSize--;
        return removedItem;
    }

    public void checkForBound(int id) {
        if (id < 0 || id >= size()) throw new ArrayIndexOutOfBoundsException();
    }

    public Iterator<E> iterator(){return new ArrayListIterator();}

    private class ArrayListIterator implements Iterator<E>{
        private int current = 0;

        public boolean hasNext(){return current<size();}

        public E next(){
            if(!hasNext()) throw new NoSuchElementException();
            return theItems[current++];
        }

        public void remove(){
            MyArrayList.this.remove(--current);
        }
    }
}