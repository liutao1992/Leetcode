package DataStruct.UF;

/**
 * @author liutao
 */
public class UnionFind1 {

    private int[] parent;

    public UnionFind1(int size){
        parent = new int[size];
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for( int i = 0 ; i < size ; i ++ ) {
            parent[i] = i;
        }
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p
     * @return
     */
    public int find(int p) {
        // 不断查找根节点
        while (p != parent[p]) {
            p = parent[p];
        }
        // 返回p的根节点
        return p;
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(q) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        // 分别获取p、q元素的根节点
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            parent[pRoot] = parent[qRoot];
        }
    }
}
