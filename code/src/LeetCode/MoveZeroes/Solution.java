package LeetCode.MoveZeroes;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * @author liutao
 */
public class Solution {

    public static void moveZeroes(int[] nums) {

        int p = removeElement(nums, 0);
        // 将 nums[p..] 的元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int zero) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != zero) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0,3,12};

        Solution.moveZeroes(nums);
    }
}
