package q33;

/**
 * TODO simplify
 */
public class Solution {

    public int search(int[] nums, int target) {
        return nums.length == 0 ? -1 : search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int left, int right, int target) {
        if (left < 0 || right < 0 || left > right) {
            return -1;
        }
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        int mid = (right + left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] < nums[right]) {
            if (target < nums[mid]) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        } else if (nums[mid] < nums[left]) {
            if (target < nums[right] && target > nums[mid]) {
                return search(nums, mid + 1, right, target);
            } else {
                return search(nums, left, mid - 1, target);
            }
        } else {
            if (target > nums[left] && target < nums[mid]) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{9, 0, 2, 7, 8}, 3));
    }
}
