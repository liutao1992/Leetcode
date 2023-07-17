package LeetCode.TopKFrequentWords;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给定一个单词列表words和一个整数 k ，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字典顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class Solution {

    private final Map<String, Integer> map = new HashMap<>();

    private final PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>
            ((entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                // 如果出现频率相同，按照字符串字典序排序
                return entry2.getKey().compareTo(entry1.getKey());
            }
            // 队列按照字符串出现频率从小到大排序
            return entry1.getValue().compareTo(entry2.getValue());
            });

    public List<String> topKFrequent(String[] words, int k) {
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer times = map.get(word);
                map.put(word, times + 1);
            }else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> m: map.entrySet()) {
            priorityQueue.offer(m);
            if (priorityQueue.size() < k) {
                // 若队列已超过k限制，则弹出元素
                priorityQueue.poll();
            }
        }
        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < priorityQueue.size(); i++) {
            res.addFirst(priorityQueue.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
