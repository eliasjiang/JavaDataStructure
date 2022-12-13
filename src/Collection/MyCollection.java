package Collection;

public interface MyCollection<E> extends MyIterable<E> {
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(E element);
    boolean add(E element);
    boolean remove(E element);
    MyIterator<E> iterator();
}
