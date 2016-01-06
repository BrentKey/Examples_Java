/*Brent Key
*normal partition for quicksort
*Array to sort is hardcoded
*/

import java.util.*;

public class quicksort_norm {
     private long[] data; 
      
     //initialize array
     public quicksort_norm(int max) {
         data = new long[max];
         //hard coded array-can change, max size is specified below (50)
         data = new long[]{48, 25, 31, 32, 82, 49, 55, 50, 43, 1, 7, 25, 27, 38, 29, 55, 73, 23, 55, 20, 38, 47, 80, 36, 19, 36, 70, 84, 42, 87, 57, 24, 40, 5, 70, 96, 51, 3, 81, 12, 25, 63, 53, 26, 52, 31, 34, 23, 9, 89};
      }
     
     // total number of comparisons in the algorithm, to evaluate run time
     private static long compares;     
     
     //initialize compare value
     public static void initStats() {
        compares = 0;
     } 
 
     //counts comparisons for every compare() that is executed
     private static boolean compare(boolean comparison) {
          compares++;
          return comparison;
     }
     
     //print initial array and sorted array, print number of comparisons used in sorting
     public void display() {
          System.out.print("Array: ");
          for (int index = 0; index < data.length; index++)
               System.out.print(data[index] + " ");
          System.out.println("\nComparisons: " + compares);
     }

     public void quickSort() {
          recQuickSort(0, data.length - 1);
     }
     
     //sort array based on pivot value, return pivot place in array
     public int partition(int left, int right) {
          long pivot = data[left];
          int index5 = left - 1;  // index going left to right
          int index6 = right + 1;   // index going right to left
          
          while (true) {
               // Moving from left to right, find an element >= the pivot.
               do {
                    index5++;
               } 
               while (compare(data[index5] < pivot));
               // Moving from right to left, find an element <= the pivot.
               do {
                    index6--;
               } 
               while (compare(data[index6] > pivot));
               if (compare(index5 >= index6))
                    break;
               else
                    swap(index5, index6);  //switch values to proper subarray
          }   
          return index6;
     }
     
    //recrusive quicksort calls, for each new level of subarrays
    public void recQuickSort(int left, int right) {
        int size = right - left;
        if (compare(size <= 2)) // manual sort if array has less than 3 elements
             manualSort(left, right);
        else{
             int pivot = partition(left, right);
             System.out.print("Trace Subarray: "); //before each recursive call, print array as is
             for(int index = 0; index < data.length; index++)
                  System.out.print(data[index] + " ");
             System.out.println("");
             if (compare(left < pivot))
                  recQuickSort(left, pivot);      // left subarray
             if (compare(right > pivot + 1))
                  recQuickSort(pivot + 1, right);   // right subarray
        }
    }  
     
     public void swap(int index1, int index2) {
          long temp = data[index1];
          data[index1] = data[index2];
          data[index2] = temp;
     }

     //manual sort when array/subarray is small enough
     public void manualSort(int left, int right) {
          int size = right - left + 1;
          if (size <= 1)
               return; // no sort necessary
          else{ // 2-sort left and right
               if (compare(data[left] > data[right]))
                    swap(left, right);
          return;
          } 
     }

     public static void main(String[] args) {
          //call new array with specified size
          quicksort_norm arr = new quicksort_norm(50);  //in brackets is size of the array 

          arr.display(); //print array
          arr.quickSort(); //sort array and print trace
          arr.display(); //print final array and number of comparisons
     }
}
