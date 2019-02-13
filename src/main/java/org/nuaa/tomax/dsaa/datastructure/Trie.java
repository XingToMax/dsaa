package org.nuaa.tomax.dsaa.datastructure;

/**
 * @Name: Trie
 * @Description: Trie for search words
 * @Author: tomax
 * @Date: 2019-02-13 22:36
 * @Version: 1.0
 */
public class Trie {
    private Trie children[];
    private boolean leaf;
    private String word;

    public Trie() {
        children = new Trie[26];
    }

    /**
     * insert word to trie
     * @param word target word
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }

        if (word.isEmpty()) {
            leaf = true;
            word = "";
            return;
        }
        Trie current = this;
        for (char ch : word.toCharArray()) {
            int val = ch - 'a';
            if (current.getChildren()[val] == null) {
                current.getChildren()[val] = new Trie();
            }
            current = current.getChildren()[val];
        }

        current.setLeaf(true);
        current.setWord(word);
    }

    /**
     * check whether the word is contains in the trie or not
     * @param word target word
     * @return search result
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        if (word.isEmpty() && isLeaf()) {
            return true;
        }

        Trie current = this;
        for (char ch : word.toCharArray()) {
            int val = ch - 'a';
            if (current.getChildren()[val] == null) {
                return false;
            }
            current = current.getChildren()[val];
        }
        return current.isLeaf();
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        Trie current = this;
        for (char ch : prefix.toCharArray()) {
            int val = ch - 'a';
            if (current.getChildren()[val] == null) {
                return false;
            }
            current = current.getChildren()[val];
        }
        return true;
    }



    public Trie[] getChildren() {
        return children;
    }

    public void setChildren(Trie[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
