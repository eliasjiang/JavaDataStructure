package Heap;

import java.nio.BufferUnderflowException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    /*Constructor*/
    public BinaryHeap(){

    }

    public BinaryHeap(int capacity){

    }

    public BinaryHeap(AnyType[] items){
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize+2)*11/10];
        int i=1;
        for (AnyType item:items){
            array[i++] = item;
        }
        buildHeap();
    }


    /*Operation*/
    public void insert(AnyType x){
        //enlarge
        if(currentSize == array.length-1){
            enlargeArray(array.length*2+1);
        }

        int hole = ++currentSize;
        //0位置的妙用
        for (array[0] = x;x.compareTo(array[hole/2])<0;hole/=2){
            array[hole] = array[hole/2];
        }
        array[hole] = x;
    }

    public AnyType findMin(){
        return array[1];
    }

    public AnyType deleteMin() throws Exception {
        if(isEmpty()) throw new Exception();

        AnyType minItem = findMin();

        array[1] = array[currentSize--];//将X移入

        percolateDown(1);//下滤法

        return minItem;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    public void makeEmpty(){

    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private AnyType[] array;

    private void percolateDown(int hole){
        int child;
        AnyType tmp = array[hole];
        for (;hole*2<=currentSize;hole=child){
            child = hole*2;
            if(child!=currentSize&&array[child+1].compareTo(array[child])<0){
                child++;
            }
            if(array[child].compareTo(tmp)<0)
                array[hole] = array[child];
            else break;
        }
        array[hole] = tmp;
    }

    private void buildHeap(){
        for (int i=currentSize/2;i>0;i--){
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize){

    }

}
