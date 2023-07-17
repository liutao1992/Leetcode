package LiuBai.DesignAddAndSearchWordsDataStructure;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liutao
 */
public class WordDictionary {

    private static class Node{
        public boolean isWord;
        public Node next[];
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new Node[26];
        }
        public Node(){
            this(false);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new Node();
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index){
        // 判断当前字符遍历长度已达到字符末尾
        if(index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.'){
            if(node.next[c - 'a'] == null) {
                return false;
            }
            return match(node.next[c - 'a'], word, index + 1);
        }
        else{
            for(char nextChar = 'a'; nextChar <= 'z'; nextChar ++) {
                if(node.next[nextChar - 'a'] != null && match(node.next[nextChar - 'a'], word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

