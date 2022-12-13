package Collection;

public interface MyIterator<E>{
    boolean hasNext();
    E next();
    void remove();
}
