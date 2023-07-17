package DataStruct.Trie;

/**
 * 前缀树（基于数组实现）
 * @author liutao
 */
public class TrieBaseArray {

    /**
     * 构建前缀树节点
     */
    private static class TrieNode{
        char word;
        TrieNode[] children;
        // isWord表示该节点是否为字符串的结尾。
        boolean isWord;

        private TrieNode(char word) {
            this.word = word;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    /**
     * 前缀树根节点
     */
    private final TrieNode root;


    public TrieBaseArray() {
        this.root = new TrieNode('/');
    }

    /**
     * 添加字符
     * @param word
     */
    public void add(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            // 遍历字符
            char c = word.charAt(i);
            int index = c - 'a';
            // 判断字符是否存在前缀树中
            if (cur.children[index] == null) {
                // 若不存在，则新增节点
                cur.children[index] = new TrieNode(c);
            }
            // 继续遍历字符
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    /**
     * 检索
     * @param word
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            // 遍历字符
            char c = word.charAt(i);
            int index = c - 'a';
            // 判断字符是否存在前缀树中
            if (cur.children[index] == null) {
                // 若不存在，则新增节点
                return false;
            }
            // 继续遍历字符
            cur = cur.children[index];
        }
        return cur.isWord;
    }
}
