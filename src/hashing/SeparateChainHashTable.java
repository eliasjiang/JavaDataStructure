package hashing;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainHashTable<E> {
    public SeparateChainHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    public SeparateChainHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i]  = new LinkedList<E>();
        }
    }
    public void insert(E x){
        List<E> whichList = theLists[myHash(x)];
        if(!whichList.contains(x)){
            whichList.add(x);
            if(++currentSize> theLists.length){
                reHash();
            }
        }
    }
    public void remove(E x){
        List<E> whichList = theLists[myHash(x)];
        if(whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
        }
    }
    public boolean contains(E x){
        List<E> whichList = theLists[myHash(x)];
        return whichList.contains(x);
    }
    public void makeEmpty(){
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    public static final int DEFAULT_TABLE_SIZE = 101;
    private List<E>[] theLists;
    private int currentSize;

    private void reHash(){

    }
    private int myHash(E x){
        int hashVal = x.hashCode();
        hashVal %=theLists.length;
        if(hashVal<0) hashVal+=theLists.length;
        return hashVal;
    }

    private static int nextPrime(int n){

    }

    private static boolean isPrime(int n){

    }
}
