package Solutions;


/**
 * 使用了内部类 TrieNode 来表示 Trie 树的每一个节点。
 * 这个节点包含一个长度为 26 的 children 数组，用来存储每个子节点，
 * 以及一个布尔型的 isEndOfWord 变量，用来标记当前节点是否为某个单词的结尾。
 * 同时定义了三个方法 insert、search 和 delete 来实现插入、查找和删除操作。
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入一个单词

    /**
     * 从根节点开始，遍历单词的每一个字符，如果当前节点的 children 数组中没有对应的字符，
     * 则创建一个新的 TrieNode 节点，然后将当前节点指向新创建的节点。
     * 如果当前节点的 children 数组中已经存在对应的字符，则将当前节点指向对应的节点。
     * 当遍历完单词的所有字符后，将当前节点的 isEndOfWord 标记为 true。
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // 查找一个单词是否存在

    /**
     * 从根节点开始，遍历单词的每一个字符，如果当前节点的 children 数组中没有对应的字符，
     * 则说明单词不存在，返回 false。
     * 如果当前节点的 children 数组中存在对应的字符，则将当前节点指向对应的节点。
     * 当遍历完单词的所有字符后，判断当前节点的 isEndOfWord 是否为 true，如果为 true，
     * 则说明单词存在，返回 true，否则说明单词不存在，返回 false。
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    // 删除一个单词

    /**
     * 从根节点开始，遍历单词的每一个字符，如果当前节点的 children 数组中没有对应的字符，
     * 则说明单词不存在，返回 false。
     * 如果当前节点的 children 数组中存在对应的字符，则将当前节点指向对应的节点。
     * 当遍历完单词的所有字符后，判断当前节点的 isEndOfWord 是否为 true，如果为 true，
     * 则说明单词存在，将当前节点的 isEndOfWord 标记为 false，然后判断当前节点是否为叶子节点，
     * 如果是叶子节点，则将当前节点置为 null，返回 true，否则返回 false。
     * 如果当前节点的 isEndOfWord 不为 true，则说明单词不存在，返回 false。
     *
     * @param word
     * @return
     */
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int depth) {
        if (depth == word.length()) {
            if (!node.isEndOfWord) {
                return false;
            }
            node.isEndOfWord = false;
            return isNodeEmpty(node);
        }
        int index = word.charAt(depth) - 'a';
        if (node.children[index] == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node.children[index], word, depth + 1);
        if (shouldDeleteCurrentNode) {
            node.children[index] = null;
            return isNodeEmpty(node);
        }
        return false;
    }


    private boolean isNodeEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    // Trie 树的节点
    private static class TrieNode {
        private final TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // 插入单词
        trie.insert("hello");
        trie.insert("world");
        trie.insert("hi");
        trie.insert("hey");

        // 查找单词
        System.out.println(trie.search("hello"));  // true
        System.out.println(trie.search("world"));  // true
        System.out.println(trie.search("hi"));     // true
        System.out.println(trie.search("hey"));    // true
        System.out.println(trie.search("he"));     // false

        // 删除单词
        System.out.println(trie.delete("hello"));  // true
        System.out.println(trie.delete("world"));  // true
        System.out.println(trie.delete("hi"));     // true
        System.out.println(trie.delete("hey"));    // true
        System.out.println(trie.delete("he"));     // false


    }
}

