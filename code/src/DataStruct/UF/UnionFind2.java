package DataStruct.UF;

/**
 * @author liutao
 */
public class UnionFind2 {

    /**
     * 记录对应节点的根节点
     */
    private int[] parent;

    /**
     * 记录sz[i]表示以i为根的集合中元素个数
     */
    private int [] sz;

    public UnionFind2(int size){
        parent = new int[size];
        sz = new int[size];
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for( int i = 0 ; i < size ; i ++ ) {
            parent[i] = i;
            // 默认每个节点对应树大小为1
            sz[i] = 1;
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
        if (pRoot == qRoot) {
            return;
        }
        // 比较两棵树大小
        // 将元素少的集合合并到元素多的集合
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            // 维护size
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = parent[pRoot];
            sz[pRoot] += sz[qRoot];
        }
    }
}
