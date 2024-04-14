/*
This class contains 4 static methods: a display which instructs the user to input the size of an array
and its elements, a function which counts how many even numbers and returns true if there are an
even number of even numbers, a method which swaps the min and max element, and
a display of the outputs.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArraysStaticMethods {

    //Public variables
    public static int[] array;
    public static int[] swappedArray;

    public static int arraySize;

    public static int max;
    public static int min;

    public static int indexOfMax;

    public static int indexOfMin;

    //Getter for array
    public static int[] getArray() {
        return (array);
    }

    //Reads user input for size of and elements in array
    public static void readInputs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tArray Methods Demo\n");

        System.out.print("What is the length of the array? ");
        arraySize = scanner.nextInt();

        array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.print("Enter an integer: ");
            array[i] = scanner.nextInt();
        }
    }

    //Returns true if even number of even numbers, false otherwise
    public static boolean even(int[] array) {
        int countEven = 0;
        boolean isEven;

        for (int x : array) {
            if (x % 2 == 0)
                countEven++;
        }

        if (countEven % 2 == 0)
            isEven = true;
        else
            isEven = false;

        return (isEven);
    }

    //Swaps the position of the max and min values in the array
    /*
    Fun learning moment: I first used Arrays.binarySearch to find the indeces, then went to show
    my gf my work, and she gave me an array that wasn't in ascending order.
    This caused a bug as I had just been using [1,2,3,4] as my inputs to test
    and never saw what happened if I used an unsorted array.
     */
    public static int[] swap(int[] array) {
       max = array[0];
       min = array[0];

       for (int i = 0; i<array.length;i++) {
            if (array[i] > max) {
                max = array[i];
                indexOfMax = i;
            }
           if (array[i] < min) {
               min = array[i];
               indexOfMin = i;
           }
        }

       swappedArray = array.clone();

       swappedArray[indexOfMax]=min;
       swappedArray[indexOfMin]=max;

       return (swappedArray);
    }

    //Displays results
    public static void displayOutputs() {
        System.out.println("\n\tThe array you entered: " + Arrays.toString(array));

        System.out.print("\tAre there an even number of even numbers in this array? ");
        if (even(array))
            System.out.println("Yes.");
        else
            System.out.println("No.");

        System.out.println("\tArray with min and max values swapped: "
                + Arrays.toString(swap(array)));
    }
}
