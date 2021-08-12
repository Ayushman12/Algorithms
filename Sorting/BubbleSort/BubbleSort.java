import java.util.*;
public class BubbleSort
{
    public static void bubbleSort(int arr[],int n) {
        // It is an optimized version of Bubble Sort. We use a flag 
        // called swapped, to check if any number is swapped in array 
        // after comparision.
        
        for(int i=0;i<n-1;i++) {
            boolean swapped = false;
            for(int j =0;j<n-1;j++) {
                if(arr[j] > arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    swapped = true;
                }
            }
            if(swapped == false)
            break;
        }
    }
    public static void main() 
    {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.print("Sorted array: ");
        for(int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
