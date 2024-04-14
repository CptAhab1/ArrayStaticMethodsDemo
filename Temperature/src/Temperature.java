/*
Alex Habbart
0855541
4/8/24
CSC 516
Lab 3
 */

/*
This program will demonstrate several static methods on an array of temperatures
 */

import java.util.Arrays;
import java.util.Scanner;

public class Temperature {
    public static void main(String[] args){
        readInputs();
        generateTemps(arraySize);
        displayOutputs();
    }

// Global variables
    public static int maxTemp = 80;

    public static int minTemp = 60;

    public static int arraySize;

    public static double avg;

    public static int[] tempsArray;

    public static int getArraySize(){return arraySize;}

    //Read user input for the number of temperatures to generate
    public static void readInputs(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a number: ");
        arraySize = scanner.nextInt();

        System.out.println("I will find the average of "
            + arraySize
            + " temperatures between 60 and 80 degrees.");
    }

    //Generate random temperatures and stores in array
    public static int[] generateTemps(int arraySize){
        tempsArray = new int[arraySize];

        for (int i = 0; i<arraySize; i++)
            tempsArray[i] = (int)(Math.random() * (maxTemp - minTemp) + minTemp);

        return tempsArray;
    }

    //Finds average temperature in array
    public static double avgTemp(int[] tempsArray){
        double total = 0;

        for (double x: tempsArray)
            total += x;

        double avg = total/arraySize;

        return avg;
    }

    //Counts how many temperatures are above the average temperature
    public static int tempsAboveAvg(int[] tempsArray, double avg){
        int tempsAboveAvg = 0;

        for (double x: tempsArray){
            if (x>avg)
                tempsAboveAvg += 1;
        }

        return tempsAboveAvg;
    }

    //Display results
    public static void displayOutputs(){
        System.out.println("\n\tRandom temperatures: " + Arrays.toString(tempsArray));
        System.out.println("\tAverage temperature: " + String.format("%.2f",avgTemp(tempsArray)));
        System.out.println("\tTemperatures above average: " + tempsAboveAvg(tempsArray, avgTemp(tempsArray)));
    }
}
