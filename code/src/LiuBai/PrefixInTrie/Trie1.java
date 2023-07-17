package LiuBai.PrefixInTrie;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于map实现
 * @author liutao
 */
public class Trie1 {

    /**
     * 构建前缀树节点
     */
    private class TrieNode {
        /**
         * isWord表示该节点是否为字符串的结尾。
         */
        public Boolean isWord;
        public Map<Character, TrieNode> next;

        public TrieNode(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public TrieNode() {
            this.isWord = false;
        }
    }

    /**
     * 前缀树根节点
     */
    private TrieNode root;
    /**
     * 前缀树大小
     */
    private int size;


    public Trie1() {
        this.root = new TrieNode();
        this.size = 0;
    }

    /**
     * 获取前缀树中单词数量
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 向前缀树中添加单词
     * @param words
     */
    public void add(String words) {
        // 从根节点开始构建前缀树
        TrieNode curNode = root;
        for (int i = 0; i < words.length(); i++) {
            // 依次遍历每个字符
            Character word = words.charAt(i);
            // 判断当前字符是否存在前缀树中
            if (curNode.next.get(word) == null) {
                // 若不存在，则新建一个节点，用来存储新添加的字符
                curNode.next.put(word, new TrieNode());
            }
            // 若存在，则继续遍历
            curNode = curNode.next.get(word);
        }

        // 判断该单词之前是否存在
        if (!curNode.isWord) {
            curNode.isWord = true;
            // 当单词添加完毕后，则维护Size大小
            size ++;
        }
    }

    /**
     * 查询前缀树中是否存在该单词
     * @param words
     * @return
     */
    public boolean contains(String words) {
        // 从根节点开始遍历
        TrieNode curNode = root;
        for (int i = 0; i < words.length(); i++) {
            // 遍历每个字符
            Character word = words.charAt(i);
            // 若不存在，则直接return false
            if (curNode.next.get(word) == null) {
                return false;
            }
            // 若存在则继续遍历
            curNode = curNode.next.get(word);
        }
        return curNode.isWord;
    }

}
