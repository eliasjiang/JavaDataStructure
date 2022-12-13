package Test;

public class Sort {

    public static int findSmallest(int[] arr){
        int smallest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<smallest) smallest = arr[i];
        }
        return smallest;
    }
}
