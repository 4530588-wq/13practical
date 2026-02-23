// Code is stored as 13template.java
import java.lang.Math.*;   import java.io.*;
import java.lang.reflect.Array;
import java.text.*;
import java.util.Arrays;
import java.util.Random;

public class timeMethods {
    public static int N =;
    static class Node{
        int key;
        String data;
        Node(int key,String data){
            this.key = key;
            this.data = data;
        }
    }


    public static void main(String args[]) {
        Random rand = new Random();
        int target = 4862;
        int[] randomKeys = new int[30];
        for(int a=0;a<randomKeys.length;a++){
            int index = rand.nextInt(32654)+1;
            randomKeys[a] = index;
        }


        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start = 1;
        long finish = 32654;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        runTime = 0;
        for (repetition = 0; repetition < repetitions; repetition++) {
            start = System.currentTimeMillis();

            // call the procedures to time here:
            Linearsearch(randomKeys,target);
            Binarysearch(randomKeys,target,start,finish);
            // Figure out how to alter this guideline here,

            finish = System.currentTimeMillis();

            time = (double) (finish - start);
            runTime += time;
            runTime2 += (time * time);
        }

        double aveRuntime = runTime / repetitions;
        double stdDeviation =
                Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime) / (repetitions - 1);

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime / 1000 + "s.");
        System.out.println("Total time\u00b2  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime / 1000)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + n);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime / n * 1000)
                + '\u00B5' + "s. ");

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println();
    }

    public static Node Linearsearch(Node[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].key == key) {
                return arr[i];
            }
        }
        return null;
    }

    public static Node Binarysearch(Node[] arr, int key){
        Arrays.sort(arr);
        int low =0;
        int high = arr.length -1;
        while (low <= high) {
            int mid = (high-low)/2;
                if (arr[mid].key == key) {
                    return arr[mid];
                }
                else if (arr[mid].key < key) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        return null;
        }
    }
}

    static void oneofyourMethods(int n,
                                 yourMethodParameter1,
                                 yourMethodParameter2, . . . ) {
// The declarations and body of your method / s
// The final statement of this code.} }