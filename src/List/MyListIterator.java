package List;

import Collection.MyIterator;

public interface MyListIterator<E> extends MyIterator<E> {
    boolean hasPrevious();
    E previous();

    void add(E element);
    void set(E newVal);
}
