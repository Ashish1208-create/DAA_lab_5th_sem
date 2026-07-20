import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        int max = Integer.MIN_VALUE;
        // input
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // max
        for (int i = 0; i < n; i++) {
            if (nums[i] > max)
                max = nums[i];
        }

        // sec max
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > secMax && max > nums[i])
                secMax = nums[i];
        }

        // smallest
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min)
                min = nums[i];
        }

        // sec min
        int secMin = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x < min) {
                secMin = min;
                min = x;
            } else if (x > min && x < secMin) {
                secMin = x;
            }
        }

        int maxDiff = max - min;
        int secMaxDiff = secMax - min;
        int minDiff = secMin - min;


        System.out.println("Max Differnce :" + maxDiff);
        System.out.println("Second max Differnce :" + secMaxDiff);
        System.out.println("Min Differnce :" + minDiff);
        System.out.println(secMin);
    }
}