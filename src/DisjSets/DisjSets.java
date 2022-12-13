package DisjSets;

public class DisjSets {
    public DisjSets(int numElements){
        s = new int[numElements];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }
    public void unionSimple(int root1,int root2){
        s[root2] = root1;
    }

    public void unionByHeight(int root1,int root2){
        if(s[root2]<s[root1]) s[root1] = root2;
        else{
            if(s[root1] == s[root2]) s[root1]--;
            s[root2] = root1;
        }
    }

    public int findSimple(int x){
        if(s[x] < 0) return x;
        else return findSimple(s[x]);
    }

    public int findCompression(int x){
        if(s[x]<0) return x;
        else return s[x] = findCompression(s[x])
    }

    private int[] s;
}
