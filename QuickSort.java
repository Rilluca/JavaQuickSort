import java.util.Random; //import random number generator

public class QuickSort {

    public static void main(String[] args) {

        Random rand = new Random(); //generate random numbers
        int[] numbers = new int[10]; 

        for(int i=0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10); //an array of 10 random 0 to 100 integers
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

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex; //choose a random pivot
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex); //swap pivot to the end of the array

        //int pivot = array[highIndex]; //choose the number at the end of the array as pivot   
        int leftPointer = lowIndex; //left pointer to point at the left of the array
        int rightPointer = highIndex - 1; //right pointer to point at the right of the array before the pivot
    
        while (leftPointer < rightPointer) { //while left is still less than right
    
            //walk from the left until we find a number greater than the pivot, or hit the right pointer
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++; //increment left pointer
            }
        
            //walk from the right until we find a number less than the pivot, or hit the left pointer
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--; //decrement right pointer
            }
        
            swap(array, leftPointer, rightPointer); //swap left pointer with right pointer

        }

        swap(array, leftPointer, highIndex); //swap left pointer with pivot

        quicksort(array, lowIndex, leftPointer - 1); //recursive
        quicksort(array, leftPointer + 1, highIndex);

        if (array[leftPointer] > array[highIndex]) { //fixes issue where the last value could potentially be out of order
            swap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }

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