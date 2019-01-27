package org.nuaa.tomax.dsaa;

/**
 * @Author: ToMax
 * @Description: red-black tree
 * 1. node color is red or black
 * 2. root node is black
 * 3. leaf node is null and black
 * 4. both son nodes of each red node is black
 * 5. every path from root node to leaf node contains same num of black nodes
 * @Date: Created in 2019/1/26 22:17
 */
public class RedBlackTree<K, V> {

    private Node<K, V> root;
    private int size;

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Comparable<? super K> k = (Comparable<? super K>) key;
        Node<K, V> p = root;
        while (p != null) {
            int comp = k.compareTo(p.key);
            if (comp < 0) {
                p = p.left;
            } else if (comp > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        Node<K, V> p = root;
        if (key == null) {
            throw new NullPointerException();
        }
        if (p == null) {
            root = new Node<>(key, value, null, null, null, false);
            size = 1;
            return null;
        }
        return null;

    }

    public V remove(K key) {
        return null;
    }

    /**
     * node rotate left
     * @param current node need to rotate left
     */
    private void leftRotate(Node<K, V> current) {
        if (current != null) {
            Node<K, V> right = current.right;
            if (right != null) {
                // current -> right => right -> left
                current.right = right.left;
                if (right.left != null) {
                    right.left.father = current;
                }
                // right -> father => current.father
                right.father = current.father;
                if (current.father == null) {
                    root = right;
                } else if (current.father.right == current) {
                    current.father.right = right;
                } else {
                    current.father.left = right;
                }
                // current -> father => right
                right.left = current;
                current.father = right;
            }
        }
    }

    /**
     * node rotate right
     * @param current node need to rotate right
     */
    private void rightRotate(Node<K, V> current) {
        if (current != null) {
            Node<K, V> left = current.left;
            if (left != null) {
                // current -> left => left -> right
                current.left = left.right;
                if (left.right != null) {
                    left.father = current;
                }
                // left -> father => current => father
                left.father = current.father;
                if (current.father == null) {
                    root = left;
                } else if (current.father.right == current) {
                    current.father.right = left;
                } else {
                    current.father.left = left;
                }
                // current -> father => left
                left.right = current;
                current.father = left;
            }
        }
    }

    private void redBlackTreeInsertFix(Node<K, V> current) {
        // node insert is red
        current.red = true;
        while (current != null && current != root && current.father.red) {
            Node<K, V> uncle = uncleOf(current);
            Node<K, V> grandfather = grandfatherOf(current);
            if (uncle != null && uncle.red) {
                current.father.red = false;
                uncle.red = false;
                uncle.father.red = true;
                current = uncle.father;
            } else if (current == current.father.right) {
                current = current.father;
                leftRotate(current);
            } else {
                current.father.red = false;
                if (grandfather != null) {
                    grandfather.red = true;
                }
                rightRotate(grandfather);
            }
        }
    }

    private Node<K, V> grandfatherOf(Node<K, V> target) {
        return target != null && target.father != null ? target.father.father : null;
    }

    private Node<K, V> uncleOf(Node<K, V> target) {
        Node<K, V> grandfather = grandfatherOf(target);
        if (grandfather == null) {
            return null;
        } else if (grandfather.left == target.father) {
            return grandfather.right;
        } else {
            return grandfather.left;
        }
    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> father;
        Node<K, V> right;
        Node<K, V> left;
        boolean red;

        public Node(K key, V value, Node<K, V> father, Node<K, V> right, Node<K, V> left, boolean red) {
            this.key = key;
            this.value = value;
            this.father = father;
            this.right = right;
            this.left = left;
            this.red = red;
        }
    }
}
