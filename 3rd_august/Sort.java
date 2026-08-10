import java.util.Scanner;

// package 3rd_august;

public class Sort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        Sort s = new Sort();

        s.quickSort(nums, 0, n-1);
        
        for(int x : nums){
            System.out.print(x + " ");
        }
    }

    static void quickSort(int[] nums, int low, int high){
        
        if(low<high){
            int pivot = partition(nums, low, high);
            
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot+1, high);
            
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j=low; j<high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
