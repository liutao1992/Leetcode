package LiuBai.MaxHeap;

import java.util.ArrayList;

/**
 * @author liutao
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int cap) {
        data = new ArrayList<>(cap);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     * @throws IllegalAccessException
     */
    private int parent(int index) throws IllegalAccessException {
        if (index < 0) {
            throw new IllegalAccessException("参数异常");
        }
        return index/2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 1;
    }


    /**
     * 向堆中添加元素(添加数组末尾)
     * @param e
     */
    public void add(E e) throws IllegalAccessException {
        data.add(e);
        swim(data.size() - 1);
    }


    /**
     * 看堆中的最大元素
     * @return
     */
    public E findMax(){
        if(data.size() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        // 数组中最后一个值代替堆顶位置
        swap(0, data.size() - 1);
        // 删除数组中最后一个元素
        data.remove(data.size() - 1);
        // 堆顶执行下沉操作
        sink(0);
        return ret;
    }

    /**
     * 上浮 (依次与父节点进行比较)
     * @param k 元素在数组中对应索引
     */
    private void swim(int k) throws IllegalAccessException {
       while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
           swap(k, parent(k));
           k = parent(k);
       }
    }

    /**
     * 堆下沉操作，维护堆排序
     * @param k 下沉元素对应索引
     */
    private void sink(int k) {
        while (leftChild(k) < data.size()) {
            // 初始化索引
            int maxChildIndex = leftChild(k);
            // 判断是否存在右孩子，若存在右孩子，则比较左孩子与右孩子大小
            if (rightChild(k) < data.size() && data.get(leftChild(k)).compareTo(data.get(rightChild(k))) < 0) {
                // 若左孩子 小于 右孩子，则将右孩子索引赋值给maxChildIndex
                maxChildIndex = rightChild(k);
            }
            // 使用下沉节点与最大节点比较
            // 若当前下沉节点 大于等于 最大节点，则停止下沉
            if (data.get(k).compareTo(data.get(maxChildIndex)) >= 0) {
                break;
            }
            // 互换节点位置
            swap(k, maxChildIndex);
            // 继续下一轮比较
            k = maxChildIndex;
        }
    }


    private void swap(int k, int j) {
        E tmp = data.get(k);
        data.set(k, data.get(j));
        data.set(j, tmp);
    }

}
