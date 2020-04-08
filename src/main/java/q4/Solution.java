package q4;

/**
 * recursive
 */
public class Solution {
    int[] nums1;
    int[] nums2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return (nums2.length & 1) == 0 ? (nums2[(nums2.length - 1) / 2] + nums2[nums2.length / 2]) / 2d : nums2[nums2.length / 2];
        }
        if (nums2.length == 0) {
            return (nums1.length & 1) == 0 ? (nums1[(nums1.length - 1) / 2] + nums1[nums1.length / 2]) / 2d : nums1[nums1.length / 2];
        }

        this.nums1 = nums1;
        this.nums2 = nums2;
        return recursive(0, nums1.length - 1, 0, nums2.length - 1);
    }

    public double recursive(int left1, int right1, int left2, int right2) {
        // median index of each array
        int midIndexLeft1 = (right1  - left1) / 2 + left1;
        int midIndexRight1 = (right1  - left1 + 1) / 2 + left1;
        int midIndexLeft2 = (right2  - left2) / 2 + left2;
        int midIndexRight2 = (right2  - left2 + 1) / 2 + left2;

        if (right1 - left1 > 1 && right2 - left2 > 1) {
            // the length of left and right part which is split by median
            int leftLength1 = midIndexLeft1 - left1;
            int rightLength1 = right1 - midIndexRight1;
            int leftLength2 = midIndexLeft2 - left2;
            int rightLength2 = right2 - midIndexRight2;

            if (nums1[midIndexLeft1] + nums1[midIndexRight1] > nums2[midIndexLeft2] + nums2[midIndexRight2]) {
                int moveLength = Math.min(leftLength2, rightLength1);
                return recursive(left1, right1 - moveLength, left2 + moveLength, right2);
            } else {
                int moveLength = Math.min(leftLength1, rightLength2);
                return recursive(left1 + moveLength, right1, left2, right2 - moveLength);
            }
        } else {
            midIndexLeft1 -= midIndexLeft1 == left1 ? 0 : 1;
            midIndexRight1 += midIndexRight1 == right1 ? 0 : 1;
            midIndexLeft2 -= midIndexLeft2 == left2 ? 0 : 1;
            midIndexRight2 += midIndexRight2 == right2 ? 0 : 1;
//            System.out.println(String.format("%d, %d, %d, %d", left1, right1, left2, right2));
            return findMedianByMerge(midIndexLeft1, midIndexRight1, midIndexLeft2, midIndexRight2);
        }
    }

    public double findMedianByMerge(int left1, int right1, int left2, int right2) {
        int lengthSum = right1 + right2 + 2 - left1 - left2;
        int[] sortArray = new int[lengthSum];
        int i = left1;
        int j = left2;
        int k = 0;
        while (i <= right1 && j <= right2) {
            if (nums1[i] < nums2[j])
                sortArray[k++] = nums1[i++];
            else
                sortArray[k++] = nums2[j++];
        }
        while (i <= right1)
            sortArray[k++] = nums1[i++];
        while (j <= right2)
            sortArray[k++] = nums2[j++];
        return (sortArray[(lengthSum - 1) / 2] + sortArray[lengthSum / 2]) / 2d;
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.nums1 = new int[]{1, 2, 10};
//        s.nums2 = new int[]{3, 4, 5, 6};
//        System.out.println(s.findMedianByMerge(0, s.nums1.length - 1, 0, s.nums2.length - 1));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
