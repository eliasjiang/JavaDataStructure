package hashing;

public class QuadraticProbingHashTable<E> {
    public QuadraticProbingHashTable(){this(DEFAULT_TABLE_SIZE);}
    public QuadraticProbingHashTable(int size){
        allocateArray(size);
        makeEmpty();
    }
    public void makeEmpty(){
        currentSize = 0;
        for(int i=0;i<array.length;i++){
            array[i] = null;
        }
    }

    public boolean contains(E x){
        int currentPos = findPos(x);
        return isActive(currentPos);
    }
    public void insert(E x){
        int currentPos = findPos(x);
        if(isActive(currentPos)) return;
        array[currentPos] = new HashEntry<E>(x,true);
        if(++currentSize>array.length/2) rehash();
    }
    public void remove(E x){
        int currentPos = findPos(x);
        if(isActive(currentPos)) array[currentPos].isActive = false;
    }

    private static class HashEntry<E>{
        public E element;
        public boolean isActive;

        public HashEntry(E e){this(e,true);}

        public HashEntry(E e,boolean i){element = e;isActive = i;}

    }

    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<E>[] array;
    private int currentSize;

    private void allocateArray(int arraySize){
        array = new HashEntry[arraySize];
    }
    private boolean isActive(int currentPos){
        return array[currentPos]!=null&&array[currentPos].isActive;
    }
    private int findPos(E x){
        int offset = 1;
        int currentPos = myHash(x);

        while (array[currentPos]!=null&&!array[currentPos].element.equals(x)){
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length){
                currentPos -= array.length;
            }
        }
        return currentPos;
    }
    private void rehash(){
        HashEntry<E>[] oldArray = array;
        allocateArray(nextPrime(2*oldArray.length));
        currentSize = 0;
        for (int i = 0; i < oldArray.length; i++) {
            if(oldArray[i]!=null&&oldArray[i].isActive) insert(oldArray[i].element);
        }
    }

    private int myHash(E x){}
    private static int nextPrime(int n){}
    private static boolean isPrime(int n){}
}
