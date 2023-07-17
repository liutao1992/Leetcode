package LeetCode.MinHeap;

import java.util.Random;

/**
 * @author liutao
 */
public class Solution {

    public static void main(String[] args) throws IllegalAccessException {
        int n = 1000000;
        MinHeap minHeap = new MinHeap(n);
        Random random = new Random();
        for(int i = 0 ; i < n ; i ++) {
            minHeap.push(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            arr[i] = minHeap.pop();
        }

        for(int i = 1 ; i < n ; i ++) {
            if(arr[i - 1] > arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MinHeap completed.");
    }
}
