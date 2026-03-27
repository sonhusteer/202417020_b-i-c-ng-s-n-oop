package Lab01;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        double[] my_array = new double[n];

        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            my_array[i] = sc.nextDouble();
        }

        
        Arrays.sort(my_array);

        
        double sum = 0;
        for (double num : my_array) {
            sum += num;
        }
        double average = sum / n;

        
        System.out.println("\n--- Results ---");
        System.out.println("Sorted Array: " + Arrays.toString(my_array));
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value: " + average);

        sc.close();
    }
}