import java.util.Random; //import random number generator

public class QuickSort {

    public static void main(String[] args) {

        Random rand = new Random(); //generate random numbers
        int[] numbers = new int[10]; 

        for(int i=0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100); //an array of 10 random 0 to 100 integers
        }

    System.out.println("Before:");
    printArray(numbers);

    quicksort(numbers, 0, numbers.length - 1); //quick sort

    System.out.println("\nAfter:");
    printArray(numbers);

    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) { 

        if (lowIndex >= highIndex) { //return result if the array only has 1 element
            return;
        }

        int pivot = array[highIndex]; //choose a pivot
        int leftPointer = lowIndex; //left pointer at the left side of the array
        int rightPointer = highIndex; //right pointer at the right side of the array
        
        while (leftPointer < rightPointer) { //while left is still less than right

            while (array[leftPointer] <= pivot && leftPointer < rightPointer) { //while left is greater than or hit pivot and is less than right
                leftPointer++; //increment left pointer
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) { //while right is lesser than or hit pivot and is less than left
                rightPointer--; //decrement right pointer
            }
            
            //left now points to the larger number than pivot and right points to the smaller number than pivot

            swap(array, leftPointer, rightPointer); //swap the number of the pointers

        } 

        swap(array, leftPointer, highIndex); //swap left pointer with pivot

        quicksort(array, lowIndex, leftPointer - 1); //recursive
        quicksort(array, leftPointer + 1, highIndex);

    }

    private static void swap(int[] array, int index1, int index2) { //method to swap the position of both indexes

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    private static void printArray(int[] numbers) { //print array

        if (numbers.length >= 1) {
            System.out.print(numbers[0]);
        }

        for (int i = 1; i < numbers.length; i++) {
            System.out.print(", " + numbers[i]);
        }

    }

}