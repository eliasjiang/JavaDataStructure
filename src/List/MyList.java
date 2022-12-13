package List;

import Collection.MyCollection;

public interface MyList<E> extends MyCollection<E> {
    E get(int id);
    E set(int id,E newVal);
    void add(int id,E element);
    void remove(int id);

    MyListIterator<E> listIterator(int pos);
}
