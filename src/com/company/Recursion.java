package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    public static int[] massive(int n) {
        int massive[] = new int[n];
        for (int i = 0; i < n; i++) {
            massive[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(massive));
        return massive;
    }

    public static int[][] massive(int a, int b) {
        int massive[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            massive[i] = new int[b];
            for (int k = 0; k < b; k++) {
                massive[i][k] = (int) (Math.random() * 100);
                System.out.print(massive[i][k] + " ");
            }
            System.out.println("");
        }

        return massive;
    }

    public static int operationSum(int[] massive, int numberOneDimensionMassive) {
        if (numberOneDimensionMassive == 0) {
            return 0;

        } else
            return massive[numberOneDimensionMassive - 1] + operationSum(massive, numberOneDimensionMassive - 1);
    }

    public static int operationSum(int[][] massive, int numberOfRows, int numberOfColums) {
        if (numberOfRows == 0) {
            return 0;

        } else {

            int sumNew = operationSum(massive[numberOfRows - 1], massive[numberOfRows - 1].length);
            return sumNew + operationSum(massive, numberOfRows - 1, numberOfColums);
        }


    }


    public static void main(String[] arg) {
        System.out.println("Введіть розмір одновимірного масиву n:");
        Scanner input = new Scanner(System.in);
        int numberOneDimensionMassive = input.nextInt();
        input = new Scanner(System.in);

        System.out.println("Max is "+operationSum(massive(numberOneDimensionMassive), numberOneDimensionMassive));

        System.out.println("Введіть розміри двохвимірного прямокутного масиву а*b:");
        int numberOfRows = input.nextInt();
        input = new Scanner(System.in);
        int numberOfColums = input.nextInt();
        System.out.println("Max is "+operationSum(massive(numberOfRows, numberOfColums), numberOfRows, numberOfColums));
    }


}
