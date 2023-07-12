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

        // 判断数组是否越界
        while (leftChild(k) < data.size()) {
            // 获取左孩子索引
            int j = leftChild(k);

            // 如果有右孩子并且左孩子比右孩子小
            if (rightChild(k) < data.size() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                // j 指向右孩子
                j = rightChild(k);
            }
            // 比"较大的孩子"大
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                // 停止下沉
                break;
            }
            swap(k, j);
            // k 指向交换后的新位置，继续比较
            k = j;
        }
    }


    private void swap(int k, int j) {
        E tmp = data.get(k);
        data.set(k, data.get(j));
        data.set(j, tmp);
    }

}
