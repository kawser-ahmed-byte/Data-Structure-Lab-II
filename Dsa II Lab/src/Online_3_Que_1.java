
import java.util.Scanner;

public class Online_3_Que_1 {
    public static int box(int[] length, int numberOfBoxes, int capacity){
        int[] bnx = new int[capacity+1];
        int[] boxCount = new int[capacity+1];

        bnx[0] = 0;
        if(capacity==0)return 0;
        else{
            for(int m=1;m<=capacity;m++){
                bnx[m] = Integer.MAX_VALUE;
                for(int i=0;i<numberOfBoxes;i++){
                    if(length[i]<=m){
                        if(1+bnx[m-length[i]] < bnx[m]){
                            bnx[m] = 1+bnx[m-length[i]];
                            boxCount[m] = length[i];
                        }
                    }
                }
            }
            System.out.println("minimum "+bnx[capacity]+" boxes.");
        }

        int cargoLength = capacity;
        while(cargoLength!=0){
            System.out.println(boxCount[cargoLength]+" meter");
            cargoLength -= boxCount[cargoLength];
        }
        return bnx[capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBoxes = scanner.nextInt();
        int[] length = new int[numberOfBoxes];

        for(int i=0;i<numberOfBoxes;i++){
            length[i] = scanner.nextInt();
        }

        int capacity = scanner.nextInt();

        box(length,numberOfBoxes,capacity);

    }
}
/*
5
1 23 25 12 10
46
*/