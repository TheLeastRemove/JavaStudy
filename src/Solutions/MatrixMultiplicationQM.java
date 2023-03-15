package Solutions;

import java.util.Arrays;

public class MatrixMultiplicationQM
{

//    public static void main(String[] args)
//    {
//        int[][] A = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        int[][] B = {{9, 8, 7},
//                {6, 5, 4},
//                {3, 2, 1}};
//
//        int[][] C = multiply(A, B);
//        int[][] D = transpose(A);
//
//        System.out.println("A = " + Arrays.deepToString(A));
//        System.out.println("B = " + Arrays.deepToString(B));
//        System.out.println("A x B = " + Arrays.deepToString(C));
//        System.out.println("Transpose of A = " + Arrays.deepToString(D));
//    }

    public static int[][] multiply(int[][] A, int[][] B)
    {
        int m = A.length;
        int n = B[0].length;
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int sum = 0;
                for (int k = 0; k < A[0].length; k++)
                {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }

    public static int[][] transpose(int[][] A)
    {
        int m = A.length;
        int n = A[0].length;
        int[][] B = new int[n][m];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
