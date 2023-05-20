import java.util.Scanner;

public class Assignment_Two_Que_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int distance = input.nextInt();
        int fullFuelGoes = input.nextInt();
        int numberOfGs = input.nextInt();
        int[] gasStations = new int[numberOfGs];

        for(int i=0; i<numberOfGs; i++){
            gasStations[i] = input.nextInt();
        }

        int destinationRemains = distance;
        for(int i=0; i<numberOfGs; i++){
            if(gasStations[i] > fullFuelGoes){
                fullFuelGoes += gasStations[i-1];
                System.out.println("stop at gas station " + i + " ( " + gasStations[i-1] + " miles)");
                destinationRemains -= fullFuelGoes;
            }
        }

        if(destinationRemains > 0){
            System.out.println("couldn't reach the destination");
        }
    }
}

/*
20
10
8
2 4 5 8 12 14 16 19
-------
25
10
5
2 4 5 8 12
*/
