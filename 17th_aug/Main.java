import java.util.*;

public class Main {

    static long count = 0;

    static void merge(int[] arr, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[high - low + 1];

        while (i <= mid && j <= high) {

            if (arr[i] < arr[j]) {

                // arr[i] is smaller than every remaining
                // element on the right
                count += (high - j + 1);

                temp[k++] = arr[i++];
            } 
            else {
                temp[k++] = arr[j++];
            }
        }

        HashMap<Character, Integer> res = new HashMap<>();

        res.gecd 

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }

    static void mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        System.out.println(count);

        sc.close();
    }
}