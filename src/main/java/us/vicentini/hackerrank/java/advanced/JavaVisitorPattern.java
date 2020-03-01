package us.vicentini.hackerrank.java.advanced;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

enum Color {
    RED, GREEN
}


@ToString
abstract class Tree {

    private int value;
    private Color color;
    private int depth;


    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }


    public int getValue() {
        return value;
    }


    public Color getColor() {
        return color;
    }


    public int getDepth() {
        return depth;
    }


    public abstract void accept(TreeVis visitor);
}


class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();


    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }


    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }


    public void addChild(Tree child) {
        children.add(child);
    }
}


class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }


    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}


abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}


class SumInLeavesVisitor extends TreeVis {
    private int result = 0;


    public int getResult() {
        //implement this
        return result;
    }


    public void visitNode(TreeNode node) {
        //implement this
    }


    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}


class ProductOfRedNodesVisitor extends TreeVis {
    private static final int STUPIDITY = 1000000007;
    private long result = 1;


    public int getResult() {
        //implement this
        return (int) result;
    }


    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % STUPIDITY;
        }
    }


    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % STUPIDITY;
        }
    }
}


class FancyVisitor extends TreeVis {
    //Creates a FancyVisitor object whose getResult method returns the absolute difference between
    // the sum of the values of non-leaf nodes at even depth and the sum of the values of green leaf nodes, which is .
    // The locked stub code prints the returned value on a new line.
    int nonLeafNodesAtEvenDepth = 0;
    int valuesGreenLeafNodes = 0;


    public int getResult() {
        //implement this
        return Math.abs(nonLeafNodesAtEvenDepth - valuesGreenLeafNodes);
    }


    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafNodesAtEvenDepth += node.getValue();
        }
    }


    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            valuesGreenLeafNodes += leaf.getValue();
        }
    }
}


class MyTree extends Tree {

    private final Integer idx;


    public MyTree(int idx, int value, Color color) {
        super(value, color, 0);
        this.idx = idx;
    }


    public Integer getIdx() {
        return idx;
    }


    @Override
    public void accept(TreeVis visitor) {

    }
}


/**
 * Stupidiest challenge ever,
 * The description is not clear, the difficult part of the change is not about Java Visitor pattern it is to
 * try to understand the stupid tree patter from the author
 * <p>
 * Java Visitor Pattern
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 */
public class JavaVisitorPattern {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner myScan = new Scanner(System.in);
        int nTests = myScan.nextInt();
        int[] values = new int[nTests];
        for (int i = 0; i < nTests; i++) {
            values[i] = myScan.nextInt();
        }
        Color[] colors = new Color[nTests];
        for (int i = 0; i < nTests; i++) {
            colors[i] = myScan.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        Map<Integer, MyTree> map = new HashMap<>();
        for (int i = 0; i < nTests; i++) {
            map.put(i, new MyTree(i, values[i], colors[i]));
        }

        Map<MyTree, LinkedList<Integer>> dependency = new HashMap<>();

        while (myScan.hasNext()) {
            int u = myScan.nextInt() - 1;
            int v = myScan.nextInt() - 1;
            MyTree uTree = map.get(u);
            MyTree vTree = map.get(v);

            if (!dependency.containsKey(uTree)) {
                LinkedList<Integer> value = new LinkedList<>();
                dependency.put(uTree, value);
            }
            dependency.get(uTree).add(v);

            if (!dependency.containsKey(vTree)) {
                LinkedList<Integer> value = new LinkedList<>();
                dependency.put(vTree, value);
            }
            dependency.get(vTree).add(u);
        }

        return recalculateDepth(map.get(0), map, dependency, 0);
    }


    private static Tree recalculateDepth(MyTree tree,
                                         Map<Integer, MyTree> map,
                                         Map<MyTree, LinkedList<Integer>> dependency,
                                         int depth) {
        if (!dependency.containsKey(tree) || dependency.get(tree).isEmpty()) {
            return new TreeLeaf(tree.getValue(), tree.getColor(), depth);
        } else {
            TreeNode treeNode = new TreeNode(tree.getValue(), tree.getColor(), depth);
            for (Integer childIdx : dependency.get(tree)) {
                MyTree child = map.get(childIdx);
                removeReverseDependency(dependency, child, tree.getIdx());
                treeNode.addChild(recalculateDepth(child, map, dependency, depth + 1));
            }

            return treeNode;
        }
    }


    private static void removeReverseDependency(Map<MyTree, LinkedList<Integer>> dependency, MyTree tree,
                                                Integer retroReference) {
        if (dependency.containsKey(tree)) {
            dependency.get(tree).remove(retroReference);
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
