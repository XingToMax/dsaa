package org.nuaa.tomax.dsaa.datastructure;

/**
 * @Name: App
 * @Description: TODO
 * @Author: tomax
 * @Date: 2019-02-13 22:52
 * @Version: 1.0
 */
public class App {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }
}
