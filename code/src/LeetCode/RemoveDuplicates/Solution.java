package LeetCode.RemoveDuplicates;

import java.util.Arrays;

/**
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
 * nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liutao
 */
public class Solution {

    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            // 1,2,2,2,3,5,7
            if (nums[slow] != nums[fast]) {
                slow++; // 这里的前提他是从小到大的排序【这里最容易出错】
                nums[slow] = nums[fast];
                System.out.println("nums:" + Arrays.toString(nums));
            }
            fast ++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,2,2,3,5,7};

        /**
         * 第1轮循环 1,2,2,2,3,5,7
         * slow = 0  ==> arr[slow] => 1
         * fast = 1  ==> arr[fast] => 2
         * 因为 arr[slow] != arr[fast]
         * 所以 slow + 1 => slow => 2 => arr[slow] => 2
         * 赋值后数组的变化 ==> 1,2,2,2,3,5,7
         *
         * 此时 slow与fast下标相同,都为1，且都指向数组元素2 ==> arr[slow] => 2
         *
         * fast ++
         *
         * 第2轮循环 1,2,2,2,3,5,7
         *
         * slow == 1  ==> arr[slow] => 2
         * fast == 2  ==> arr[fast] => 2
         *
         * 因为 arr[slow] == arr[fast] 所以 fast + 1
         *
         * 第3轮循环 1,2,2,2,3,5,7
         *
         * slow == 1  ==> arr[slow] => 2
         * fast == 3  ==> arr[fast] => 2
         *
         * 因为 arr[slow] == arr[fast] 所以 fast + 1
         *
         * 第4轮循环 1,2,2,2,3,5,7
         *
         * slow == 1  ==> arr[slow] => 2
         * fast == 4  ==> arr[fast] => 3
         *
         * 因为 arr[slow] != arr[fast]
         * 所以 slow + 1 => slow = 2 ==> arr[slow] => 2
         * 此时赋值：arr[slow] = 3 ==> nums:[1, 2, 3, 2, 3, 5, 7]
         *
         * 第5轮循环 1, 2, 3, 2, 3, 5, 7
         *
         * slow == 2  ==> arr[slow] => 3
         * fast == 5  ==> arr[fast] => 5
         *
         * 因为 arr[slow] != arr[fast]
         * 所以 slow + 1 => slow => 3 ==> arr[slow] => 2
         *
         * 此时赋值：arr[slow] = 5 ==> nums:[1, 2, 3, 5, 3, 5, 7]
         *
         * 第6轮循环 1, 2, 3, 5, 3, 5, 7
         *
         * slow == 3  ==> arr[slow] => 5
         * fast == 6  ==> arr[fast] => 6
         * 因为 arr[slow] != arr[fast]
         * 所以 slow + 1 => slow => 4 ==> arr[4] => 3
         * 此时赋值：arr[slow] = 5 ==> nums:[1, 2, 3, 5, 7, 5, 7]
         */

        // [1、2、2、5]

        int size = Solution.removeDuplicates(arr);
        System.out.println(size);
    }

}
