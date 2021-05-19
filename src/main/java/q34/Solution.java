package q34;

public class Solution {
    private int[] nums;
    private int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int[] result = new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                result[0] = findLeftBorder(left, middle - 1);
                result[1] = findRightBorder(middle + 1, right);
                break;
            }
        }
        return result;
    }

    private int findLeftBorder(int left, int right) {
//        System.out.println("left:" + left + " right:" + right);
        while (true) {
            int middle = (left + right) / 2;
            if (nums[middle] < this.target) {
                if (nums[middle + 1] == this.target) {
                    return middle + 1;
                }
                left = middle + 1;
            } else {
                if (middle == 0 || nums[middle - 1] < this.target) {
                    return middle;
                }
                right = middle - 1;
            }
        }
    }

    private int findRightBorder(int left, int right) {
//        System.out.println("left:" + left + " right:" + right);
        while (true) {
            int middle = (left + right) / 2;
            if (nums[middle] > this.target) {
                if (nums[middle - 1] == this.target) {
                    return middle - 1;
                }
                right = middle - 1;
            } else {
                if (middle + 1 == nums.length || nums[middle + 1] > this.target) {
                    return middle;
                }
                left = middle + 1;
            }
        }
    }

    public static void main(String[] args) {
        print(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 8));
        print(new Solution().searchRange(new int[]{5,7,7,8,8,10,11}, 8));
        print(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 6));
        print(new Solution().searchRange(new int[]{}, 0));
        print(new Solution().searchRange(new int[]{1}, 1));
        print(new Solution().searchRange(new int[]{1,1}, 1));
        print(new Solution().searchRange(new int[]{0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10}, 4));
        print(new Solution().searchRange(new int[]{0,0,1,1,2,2,2,2,3,3,4,4,4,5,6,6,6,7,8,8}, 4));
        print(new Solution().searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3));
    }

    private static void print(int[] result) {
        System.out.println("left:" + result[0] + " right:" + result[1]);
    }
}
