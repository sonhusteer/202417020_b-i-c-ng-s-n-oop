package Lab01;
import java.util.Scanner;
public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        double[][] matrix1 = new double[rows][cols];
        double[][] matrix2 = new double[rows][cols];
        double[][] sumMatrix = new double[rows][cols];

  
        System.out.println("Enter elements for Matrix 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Matrix1[%d][%d] = ", i, j);
                matrix1[i][j] = sc.nextDouble();
            }
        }

       
        System.out.println("Enter elements for Matrix 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Matrix2[%d][%d] = ", i, j);
                matrix2[i][j] = sc.nextDouble();
            }
        }

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

     
        System.out.println("\nSum of the two matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sumMatrix[i][j] + "\t");
            }
            System.out.println(); 
        }

        sc.close();
    }
}
