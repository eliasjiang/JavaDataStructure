package hashing;

import org.junit.jupiter.api.Test;

public class simpleStringHashTable {
    public static int hash(String key,int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal = 37*hashVal+key.charAt(i);
        }
        hashVal%=tableSize;
        if(hashVal<0){
            hashVal +=tableSize;
        }
        return hashVal;
    }
    @Test
    public void test(){
        System.out.println(hash("myname",100));
    }
}
