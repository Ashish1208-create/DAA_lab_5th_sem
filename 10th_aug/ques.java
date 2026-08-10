//write a code for execution of merge sort for a given input how many time u copy elements of right subarray 
// before copying the left subbarray where even numbers are in odd positions but in descending order and odd numbers 
// in even positions but in ascending order while the counter just count the copying it wont consider the index 

// First input : 1 to 1000 
// Second input: reverse order (1000 to 1)
// Third input: odd numbers in odd position, ascending order and Even number in Even position, descending order

import java.util.Scanner;

public class ques {
    // static long counter;
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            mergeSort(nums, 0, n - 1);

            for (int i : nums) {
                System.out.print(i + " ");
            }
            System.out.println();
        }  
  }   
  
  static void mergeSort(int[] nums, int low, int high){
    if(low>=high){
        return;
    }

    int mid = (low+high)/2;

    mergeSort(nums, low, mid);
    mergeSort(nums, mid+1, high);

    merge(nums, low, mid, high);
  }

  static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;       // left subarray
        int j = mid + 1;   // right subarray
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                // Left element copied first
                temp[k++] = arr[i++];
            } 
            else {
                // RIGHT element copied before LEFT element
                // counter++;
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy back
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    } 
}
