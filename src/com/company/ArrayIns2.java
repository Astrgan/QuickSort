package com.company;

public class ArrayIns2 extends ArrayIns {
    public ArrayIns2(int max) {
        super(max);
    }

    public void recQuickSort(int left, int right){
        int size = right-left+1; if(size <= 3)
            manualSort(left, right);
        else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }

    private void manualSort(int left, int right) {
        int size = right-left+1;
        if(size <= 1)
            return;
        if(size == 2){
            if( theArray[left] > theArray[right] )
                swap(left, right);
            return;
        }
        else {
            if( theArray[left] > theArray[right-1] )
                swap(left, right-1);
            if( theArray[left] > theArray[right] )
                swap(left, right);
            if( theArray[right-1] > theArray[right] )
                swap(right-1, right);
        }
    }

    private long medianOf3(int left, int right) {
        int center = (left+right)/2;
        if( theArray[left] > theArray[center] )
            swap(left, center);
        if( theArray[left] > theArray[right] )
            swap(left, right);
        if( theArray[center] > theArray[right] )
            swap(center, right);

        swap(center, right-1); // Размещение медианы на правом краю
        return theArray[right-1]; // Метод возвращает медиану
    }

}
