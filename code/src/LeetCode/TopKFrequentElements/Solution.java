package LeetCode.TopKFrequentElements;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 * @author liutao
 */
public class Solution {

    private final Map<Integer, Integer> map = new HashMap<>();

    private final PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer times = map.get(num);
                map.put(num, times + 1);
            }else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> m:map.entrySet()) {
          // 向优先队列中插入k元素
            priorityQueue.offer(m);
            if (priorityQueue.size() > k) {
                // 弹出最小元素，维护队列内是 k 个频率最大的元素
                priorityQueue.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            // res 数组中存储前 k 个最大元素
            res[i] = Objects.requireNonNull(priorityQueue.poll()).getKey();
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,2,2,3};

        Solution solution = new Solution();

        int[] topKFrequent = solution.topKFrequent(nums, 2);

        for (int num: topKFrequent) {
            System.out.println(num);
        }
    }
}
