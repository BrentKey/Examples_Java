/*Intersect.java
*
*Author: Brent Key
*Generate two random arrays of integers
*Return list of matching integers between the arrays
*/

import java.util.*;

public class Intersect{
  
  private static int MAX_VAL = 100;
  
  public static int[] randomArray(int n, int maxVal) {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxVal + 1));
        }

        return arr;
    }

  public static int[] randomArray(int n) {
        return randomArray(n, MAX_VAL);
    }
  
  private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
  
  //sort arrays using bubble sort
  public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    //match integers in each array, create new array 
   public static int [] intersect(int [] a, int [] b){
     int[] c = new int[(int)Math.min(a.length, b.length)];
     int i =0;
     for(int f=0; f<a.length; f++){
       for(int k=0; k<b.length; k++){
         if(a[f] == b[k]){
           c[i]=a[f];
           i++;
         }
       }  
   }
     removeDups(c);
     return c;
   }
   
   public static void printArray(int[] arr) {

     System.out.print("{ ");

        for (int i = 0; i < arr.length; i++)
        System.out.print(arr[i] + " ");

        System.out.println("}");
    }
    
    //remove any duplicates from array of matches
    public static int removeDups(int [] arr){
      bubbleSort(arr);
      int count = 0;
      for(int i = 0; i<arr.length - 1; i++){
        if(arr[i] == arr[i + 1]){
          arr[i] = 0;
        }
      }
      for(int i=0; i<arr.length-1; i++){
        int temp = 0;
        for(int j=i; j<arr.length; j++){
          if(arr[i] == 0 && arr[j] != 0){
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
      }
      for(int i =0; i <arr.length - 1; i++){
        if (arr[i] != 0){
          count++;
      }
      }
      return count;
    }
    
    public static void main(String args[]) {
        int[] a;       // the array
        int numItems;
        int [] b;
        int numItems2;
        //specify length of arrays
        Scanner in = new Scanner(System.in);
        System.out.print("How many items in the first array? ");
        numItems = in.nextInt();
        in.nextLine();
        a = randomArray(numItems);
        
        System.out.print("How many items in the second array? ");
        numItems2 = in.nextInt();
        in.nextLine();
        b = randomArray(numItems2);
        
        bubbleSort(a);
        bubbleSort(b);
        printArray(a);
        printArray(b);
        printArray(intersect(a,b));      
    }
}
