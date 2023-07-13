package LiuBai.SeatReservationManager;

import java.util.PriorityQueue;

/**
 * @author liutao
 */
public class SeatManager {

    /**
     * java 提供的PriorityQueue为最小堆实现
     */
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            priorityQueue.offer(i);
        }
    }

    public int reserve() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        }
        return -1;
    }

    public void unreserve(int seatNumber) {
        priorityQueue.offer(seatNumber);
    }
}
