/**
 * Program reads positive integers from user and
 * breaks them into sums of at most four positive perfect squares.
 * BrentKey
 */
 
import java.util.*;

public class Lagrange {
    private int number;      // the number to break up
    private Object[] terms;
    public static final int DEFAULT_MAX_SIZE = 4;
    
    /*
     * largestSquare - private helper method that returns the 
     * largest perfect square less than or equal to the specified 
     * positive integer n.
     */
    private static int largestSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt;
    }

    public Lagrange(int num) {
        number = num;
        terms = new Object[DEFAULT_MAX_SIZE];
        // initialize fields    
    }

    /**
     * printSolution - print the solution to the problem
     */
    public void printSolution() {
        System.out.print(number + " = " + terms[0]);
        for(int i=1; i<terms.length && terms[i] !=null; i++){
          System.out.print(" + " + terms[i]);
        }
    }
    
    /**
     * findSum - recursive-backtracking method.
     * call it to break the specified number (num) into a sum 
     * of at most maxTerms perfect squares.  
     * Returns true if the solution has been found and false otherwise.
     */
     
    public boolean findSum(int num, int maxTerms) {
      if(maxTerms>0){
        terms[DEFAULT_MAX_SIZE - maxTerms] = largestSquare(num);
        findSum(num - largestSquare(num), maxTerms -1);
      }
      Integer currentCount = (Integer) terms[0] + (Integer) terms[1] + (Integer) terms[2] + (Integer) terms[3];
      return currentCount.equals(number);
    }
    
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a positive integer (-1 to quit): ");
            int n = console.nextInt();
            console.nextLine();
            
            if (n == -1) {
                System.out.println("Goodbye!");
                return;
            } else if (n <= 0)
                continue;
    
            Lagrange problem = new Lagrange(n);
            
            if (problem.findSum(n, 4)) {
                problem.printSolution();
            } else {
                System.out.println("could not find a sum for " + n);
                System.out.println();
            }
            System.out.println();
        }
    }
}
