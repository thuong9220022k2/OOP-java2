import java.util.Scanner;

import java.util.Arrays;
public class SumAndAverage{

    // public static void sort(int array[], int N){
    //     int min = array[0];
    //     int t = 0;
    //     for(int i=1;i<N;i++){
    //         if(array[i] < min){
    //            min = t;
    //            t = array[i];
    //            array[i] = min; 
    //         }
    //    }
    //    for(int i=0;i<N;i++){
    //        System.out.println(array[i]);
    //     }
    // }
    public static int sum(int array[],int N){
        int sum = 0;
        for(int i=0;i<N;i++){
            sum+=array[i];

        }
        return sum;
    }
    public static int average(int array[],int N){
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += array[i];

        }
        int avg = sum/N;
        return avg;
    }

    public static void main (String [] args){

        Scanner key = new Scanner(System.in);
        int N = key.nextInt();
        int array[] = new int[N];
        for(int i=0;i<N;i++){
           array[i] = key.nextInt();
        }
        Arrays.sort(array);
        for(int i=0;i<N;i++){
           System.out.println(array[i]);
        }
        int a = sum(array,N);
        System.out.println(a);
        int b = average(array,N);
        System.out.println(b);       
    }
}