package us.vicentini.hackerrank.algorithms.datastructures.balancedtrees;

public class SelfBalancingTree {
    static Node insert(Node root, int val) {
        if (root == null) {
            return createNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        updateHt(root);
        root = balanceAVL(root);
        return root;
    }


    private static Node createNode(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.ht = 0;
        return newNode;
    }


    private static Node balanceAVL(Node root) {
        int ht = computeHtDiff(root);
        if (ht == 2) {
            if (computeHtDiff(root.left) == -1) {
                root.left = rotateLeft(root.left);
            }
            root = rotateRight(root);
        } else if (ht == -2) {
            if (computeHtDiff(root.right) == 1) {
                root.right = rotateRight(root.right);
            }
            root = rotateLeft(root);
        }
        return root;
    }


    private static int computeHtDiff(Node root) {
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left - right;
    }


    private static Node rotateRight(Node node) {
        Node aux = node.left;
        node.left = aux.right;
        aux.right = node;

        updateHt(aux.right);
        updateHt(aux);
        return aux;
    }


    private static Node rotateLeft(Node node) {
        Node aux = node.right;
        node.right = aux.left;
        aux.left = node;
        updateHt(aux.left);
        updateHt(aux);
        return aux;
    }


    private static void updateHt(Node root) {
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        root.ht = Math.max(left, right) + 1;
    }


    private static int getHeight(Node node) {
        return node == null ? -1 : node.ht;
    }


    public static void printDepth(Node node) {
        if (node == null) {
            System.out.println("|");
            return;
        }
        printDepth(node.left);
        System.out.println(String.format("%s[%d] ", spaces(node.ht), node.val));
        printDepth(node.right);
    }


    private static String spaces(int depth) {
        StringBuilder sb = new StringBuilder(depth);
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Node root = null;
        for (int i = 0; i < 20; i++) {
            root = insert(root, i);
            printDepth(root);
            System.out.println("-----------------------------------");
        }
    }


    private static class Node {
        int val;    //Value
        int ht;        //Height
        Node left;    //Left child
        Node right;    //Right child


        @Override
        public String toString() {
            return "Node{" +
                   "val=" + val +
                   ", ht=" + ht +
                   '}';
        }
    }
}


