package DataStruct.UF;

/**
 * @author liutao
 */
public class UnionFind {

    /**
     * 分量id（以触点作为索引）
     */
    private int[] id;
    /**
     * 分量数量
     */
    private int count;

    public UnionFind(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int find(int p) {
        return this.id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        // 若p和q已经在相同分量中则不需要采取任何行动
        if (pID == qID) {
            return;
        }
        // 将p与q进行合并
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
            count--;
        }
    }
}
