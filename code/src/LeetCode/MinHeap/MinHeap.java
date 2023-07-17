package LeetCode.MinHeap;

import java.util.ArrayList;

/**
 * 最小堆实现
 * @author liutao
 */
public class MinHeap {

    private final ArrayList<Integer> data;

    public MinHeap() {
        this.data = new ArrayList<>();
    }

    public MinHeap(int cap) {
        this.data = new ArrayList<>(cap);
    }

    /**
     * k元素对应父节点的索引值
     * @param k
     * @return
     */
    private int parent(int k) {
        if (k < 0) {
            return 1;
        }
        return k / 2;
    }

    private int leftChild(int k) {
        return 2*k;
    }

    private int rightChild(int k) {
        return 2*k + 1;
    }

    /**
     * 添加元素
     * @param e
     */
    public void push(int e) {
        data.add(e);
        // 维护最小堆
        swim(data.size() - 1);
    }


    /**
     * 弹出最小元素
     */
    public int pop() throws IllegalAccessException {
        if (data.isEmpty()) {
            throw new IllegalAccessException("队列为空");
        }
        int ret = data.get(0);
        // 互换元素位置
        swap(0, data.size() - 1);
        // 删除数组末尾元素
        data.remove(data.size() - 1);
        // 对顶元素进行下沉
        sink(0);
        return ret;
    }

    /**
     * 下沉操作
     * @param k
     */
    private void sink(int k) {
        while (leftChild(k) < data.size()) {
            int minNodeIndex = leftChild(k);
            // 判断是否存在右节点
            // 若存在，则进行比较 取出左右子结点中较小的
            if (rightChild(k) < data.size() && data.get(leftChild(k)).compareTo(data.get(rightChild(k))) > 0) {
                minNodeIndex = rightChild(k);
            }
            // 使用下沉节点与当前较小节点进行比较
            // 若下沉元素已经比较小了，则结束下沉
            if (data.get(k).compareTo(data.get(minNodeIndex)) <= 0) {
                break;
            }
            // 反之则交换位置，继续下一轮比较
            swap(k, minNodeIndex);
            k = minNodeIndex;
        }
    }

    /**
     * 上浮操作
     * @param k
     */
    private void swim(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0) {
            // 比较父子节点，若小于父亲节点，则进行位置交换
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void swap(int k, int j) {
        int tmp = data.get(k);
        data.set(k, data.get(j));
        data.set(j, tmp);
    }
}
