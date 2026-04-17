package Lab01;
import java.util.Arrays;
import java.util.Scanner;

public class bai65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        int n = scanner.nextInt();
         int[] myArray = new int[n];
        for(int i=0;i<n;i++){
         myArray[i] = scanner.nextInt();
        }
int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
         Arrays.sort(myArray);
         double average = (double) sum / n;
          System.out.println("\n--- KeT QUa ---");
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(myArray));
        System.out.println("Tong các phan tu: " + sum);
        System.out.println("Gia tri trung binh: " + average);

        scanner.close();

    }
}
