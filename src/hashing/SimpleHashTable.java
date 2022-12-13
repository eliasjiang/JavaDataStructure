package hashing;

public class SimpleHashTable {
    private int[] table;
    private int hashTableSize;
    public void setHashTable(int size){
        this.hashTableSize = size;
        table = new int[hashTableSize];
    }
    public int simpleHashFunction(int key){
        int index = key%hashTableSize;
        return index;
    }

    public void store(int key){
        int index = simpleHashFunction(key);
        table[index] = key;
    }
    public int showIndex(int key){
        return simpleHashFunction(key);
    }

}

class Test{
    @org.junit.jupiter.api.Test
    void test(){
        SimpleHashTable s1 = new SimpleHashTable();
        s1.setHashTable(10);
        s1.store(12);
        System.out.println(s1.showIndex(12));
    }
}
