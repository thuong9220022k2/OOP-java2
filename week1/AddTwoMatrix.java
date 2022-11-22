import java.util.Scanner ;

public class AddTwoMatrix{

    static void printMatrix(int M[][],int rowSize,int colSize){
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                System.out.print(M[i][j] + " ");
 
            System.out.println();
        }
    }

    static int[][] add(int A[][], int B[][],int rowSize,int colSize){
        int i, j;
        int C[][] = new int[rowSize][solSize];
 
        for (i = 0; i < rowSize; i++)
            for (j = 0; j < colSize; j++)
                C[i][j] = A[i][j] + B[i][j];
 
        return C;
    }
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        int rowSize = key.nextInt();
        int colSize = key.nextInt();
        int A[][] = new int[rowSize][colSize];
        int B[][] = new int[rowSize][colSize];
        int D[][] = new int[rowSize][colSize];
        System.out.println("Matrix A");
        for(int i=0;i<rolSize;i++){
            for(j=0;j<colSize;j++){
                A[i][j] = key.nextInt();

            }
        }
        System.out.println("Matrix B");
        for(int i=0;i<rolSize;i++){
            for(j=0;j<colSize;j++){
                B[i][j] = key.nextInt();

            }
        }
        int[][] D = add(A,B,rowSize,colSize);
        System.out.println(D);




    }
}