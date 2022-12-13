package Sorting;

public class Sort {
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort(AnyType[] a){
        int j;
        for (int p =1;p<a.length;p++){
            AnyType tmp = a[p];
            for (j=p;j>0&&tmp.compareTo(a[j-1])<0;j--) a[j] = a[j-1];
            a[j] = tmp;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void shellSort(AnyType[] a){
        int j;
        for (int gap = a.length/2;gap>0;gap/=2){
            for (int i = gap; i < a.length; i++) {
                AnyType tmp = a[i];
                for (j = i;j >=gap&&tmp.compareTo(a[j-gap])<0;j-=gap) a[j] = a[j-gap];
                a[j] = tmp;
            }
        }
    }


}
