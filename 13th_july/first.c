#include <stdio.h>
#include <limits.h>

int main() {
    int n;

    scanf("%d", &n);

    if (n <= 2) {
        printf("Give valid input");
        return 0;
    }

    int nums[n];

    // Input
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    // Maximum
    int max = INT_MIN;
    for (int i = 0; i < n; i++) {
        if (nums[i] > max)
            max = nums[i];
    }

    // Second Maximum
    int secMax = INT_MIN;
    for (int i = 0; i < n; i++) {
        if (nums[i] > secMax && nums[i] < max)
            secMax = nums[i];
    }

    // Minimum
    int min = INT_MAX;
    for (int i = 0; i < n; i++) {
        if (nums[i] < min)
            min = nums[i];
    }

    // Second Minimum
    int secMin = INT_MAX;
    for (int i = 0; i < n; i++) {
        if (nums[i] > min && nums[i] < secMin)
            secMin = nums[i];
    }

    // Differences
    int maxDiff = max - min;
    int secMaxDiff = secMax - min;
    int minDiff = secMin - min;

    printf("Max Difference : %d\n", maxDiff);
    printf("Second Max Difference : %d\n", secMaxDiff);
    printf("Min Difference : %d\n", minDiff);

    return 0;
}