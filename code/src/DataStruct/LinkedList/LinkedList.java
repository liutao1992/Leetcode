package DataStruct.LinkedList;

/**
 * @author liutao
 */
public class LinkedList {

    private static class Node{
        private int val;
        private Node next;

        private Node(int val, Node next){
            this.val = val;
            this.next = next;
        }

        private Node(int val){
            this.val = val;
        }

        private Node(){
            this.next = null;
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummyHead;

    /**
     * 节点个数
     */
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public void add(int index, int val) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(val, prev.next);
        size++;
    }
}
