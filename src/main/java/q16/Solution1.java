package q16;

import java.util.Arrays;

public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestTarget = nums[0] + nums[1] + nums[2];
        int closestDistance = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - 2; i++) {
            int inum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + inum;
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
                int currentDistance = Math.abs(target - sum);
                if (closestDistance > currentDistance) {
                    closestDistance = currentDistance;
                    closestTarget = sum;
                }
            }
        }
        return closestTarget;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
