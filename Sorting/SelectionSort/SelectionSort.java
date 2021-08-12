import java.util.*;
public class SelectionSort
{
    private void selectionSort(int arr[]) {
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            int min = i;
            for(int j=i+1;j<n;j++) {
                if(arr[j] <arr[min])
                min = j;
            }
            int t = arr[min];
            arr[min] = arr[i]; 
            arr[i] = t;
        }
    }
    public static void main()
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.selectionSort(arr);
        System.out.print("Sorted array : ");
        for(int i=0;i<arr.length;i++) 
        System.out.print(arr[i]+" ");
    }
}
