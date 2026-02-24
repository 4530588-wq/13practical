// Code is stored as 13template.java
import java.io.*;
import java.text.*;
import java.util.*;

public class TimeMethods {

    public static int N = 32654;   // maximum expected records

    static class Node {
        int key;
        String data;

        Node(int key, String data) {
            this.key = key;
            this.data = data;
        }
    }

    static Node[] nodes = new Node[N];

    public static void main(String args[]) throws Exception {

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        int repetition, repetitions = 30;

        /* ================= LOAD FILE ================= */

        File file = new File("C:\\Users\\lithe\\Documents\\ulysses.numbered");
        Scanner input = new Scanner(file);

        int index = 0;
        while (input.hasNextLine() && index < N) {
            String line = input.nextLine();
            String[] parts = line.split(" ", 2);

            int key = Integer.parseInt(parts[0]);
            String data = parts[1];

            nodes[index++] = new Node(key, data);
        }
        input.close();

        int n = index;   // actual number of records loaded

        System.out.println("Records loaded: " + n);

        /* ================= LINEAR SEARCH TIMING ================= */

        runTime = 0;
        runTime2 = 0;

        for (repetition = 0; repetition < repetitions; repetition++) {

            start = System.currentTimeMillis();

            linearsearch(n);

            finish = System.currentTimeMillis();

            time = (double) (finish - start);
            runTime += time;
            runTime2 += (time * time);
        }

        double aveRuntime = runTime / repetitions;
        double stdDeviation =
                Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime) / (repetitions - 1);

        System.out.println("\nLINEAR SEARCH RESULTS");
        System.out.println("Average time = " + fiveD.format(aveRuntime / 1000) + " s");
        System.out.println("Standard deviation = " + fourD.format(stdDeviation) + " ms");

        /* ================= SORT FOR BINARY ================= */

        Arrays.sort(nodes, 0, n, Comparator.comparingInt(x -> x.key));

        /* ================= BINARY SEARCH TIMING ================= */

        runTime = 0;
        runTime2 = 0;

        for (repetition = 0; repetition < repetitions; repetition++) {

            start = System.currentTimeMillis();

            binarysearch(n);

            finish = System.currentTimeMillis();

            time = (double) (finish - start);
            runTime += time;
            runTime2 += (time * time);
        }

        aveRuntime = runTime / repetitions;
        stdDeviation =
                Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime) / (repetitions - 1);

        System.out.println("\nBINARY SEARCH RESULTS");
        System.out.println("Average time = " + fiveD.format(aveRuntime / 1000) + " s");
        System.out.println("Standard deviation = " + fourD.format(stdDeviation) + " ms");

    } // end main


    /* ================= LINEAR SEARCH ================= */

    static void linearsearch(int n) {

        for (int i = 0; i < n; i++) {

            int target = (int) (Math.random() * 32654) + 1;

            for (int j = 0; j < n; j++) {
                if (nodes[j].key == target)
                    break;
            }
        }
    }


    /* ================= BINARY SEARCH ================= */

    static void binarysearch(int n) {

        for (int i = 0; i < n; i++) {

            int target = (int) (Math.random() * 32654) + 1;

            int low = 0;
            int high = n - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (nodes[mid].key == target)
                    break;
                else if (nodes[mid].key < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
    }

}