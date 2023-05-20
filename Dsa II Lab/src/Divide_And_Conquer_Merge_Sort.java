import java.util.Scanner;

public class Divide_And_Conquer_Merge_Sort {
    public static void merge(int[] arr, int startInd, int mid, int endInd) {
        int leftArrSize = mid - startInd + 1;
        int rightArraySize = endInd - (mid+1) + 1;
        int[] leftArr = new int[leftArrSize];
        for(int i=0;i<leftArrSize;i++){
            leftArr[i] = arr[startInd+i];
        }

        int[] rightArr = new int[rightArraySize];
        for(int i=0;i<rightArraySize;i++){
            rightArr[i] = arr[mid+1+i];
        }

        int leftIndex=0;
        int rightIndex=0;
        for(int i=startInd;i<=endInd;i++){
            if(leftIndex==leftArrSize){
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }
            else if(rightIndex==rightArraySize){
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            }
            else if(leftArr[leftIndex]<=rightArr[rightIndex]){
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            }
            else{
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }

    }

    public static void mergeSort(int[] arr, int startInd, int endInd) {
        if(startInd<endInd){
            int mid = (startInd+endInd)/2;
            mergeSort(arr,startInd,mid);
            mergeSort(arr,mid+1,endInd);
            merge(arr,startInd,mid,endInd);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        mergeSort(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}