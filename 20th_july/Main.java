import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int subArray = n * (n - 1) / 2;
        System.out.println("total no of subarrays: " + subArray);

        int summ = 0;
        for(int i=0; i<n; i++){
            summ += arr[i];
        }

        System.out.println("summation of all the element: " + summ);

        System.out.println("sum of all possible sub arrays");

    
        int moduloSum = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                    if (k != j) System.out.print(", ");
                }
                System.out.println("] Sum = " + sum);
                int modul = sum%n;
                System.out.println("modulo = " + modul );
                
                moduloSum += modul;
 
            }
        }

        System.out.println(moduloSum);
    }
}