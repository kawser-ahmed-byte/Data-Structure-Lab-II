import java.util.Scanner;
public class Divide_And_Conquer_Quick_Sort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int startInd, int lastInd) {
        int pivot = arr[lastInd];
        int i = startInd-1;
        for(int j=startInd;j<lastInd;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,lastInd);
        return i+1;
    }

    public static void quickSort(int[] arr, int startInd, int lastInd) {
        if(startInd<lastInd) {
            int parts = partition(arr, startInd, lastInd);
            quickSort(arr, startInd, parts-1);
            quickSort(arr, parts+1, lastInd);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}