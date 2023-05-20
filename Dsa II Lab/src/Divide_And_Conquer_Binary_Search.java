import java.util.*;
public class Divide_And_Conquer_Binary_Search  {

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 50, 100, 150, 200};

        if(binarySearch(arr,0,6,100)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }
    }

    public static boolean binarySearch(int[] arr, int startInd, int lastInd, int key){
        if(startInd > lastInd){
            return false;
        }
        else{
            Random rand = new Random();
            int mid = startInd + rand.nextInt(lastInd - startInd + 1);
            if(arr[mid] == key){
                return true;
            }
            else if(key < arr[mid]){
                return binarySearch(arr, startInd, mid-1, key);
            }
            else{
                return binarySearch(arr, mid+1, lastInd, key);
            }
        }
    }
}