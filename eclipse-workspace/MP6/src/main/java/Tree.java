/**
 * A class that implements a basic binary tree storing integers.
 * <p>
 * You need to complete this class by adding methods to insert values, compute the minimum and
 * maximum, search for a value, and compute a value's depth in the tree and number of descendants.
 * You will also need to complete several constructors used during tree creation and value
 * insertion.
 * <p>
 * Our binary tree is an example of a <i>recursive data structure</i>, since each tree instance
 * refers to several other tree instances to complete the entire structure. As you might expect,
 * recursive algorithms are particularly useful on recursive data structures.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/6/">MP6 Documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Binary_tree">Binary Tree</a>
 */
public class Tree {

    /**
     * Current node's value.
     */
    private int value;

    /**
     * Current node's parent. May be null if I'm the root of the tree.
     */
    private Tree parent;

    /**
     * Current node's left child, or null if none.
     */
    private Tree left;

    /**
     * Current node's left child, or null if none.
     */
    private Tree right;

    public Tree(final int setValue) {
        this.value = setValue;
        this.parent = null;
    }

    public Tree(final int setValue, final Tree setParent) {
    this.value = setValue;
    this.parent = setParent;
    }

    public boolean insert(final int newValue) {
        if (value == newValue) {
            return false;
        } else if (value > newValue) {
            if (right == null) {
                right = new Tree(newValue, this);
                return true;
            } else {
                return right.insert(newValue);
            }
        } else {
            if (left == null) {
                left = new Tree(newValue, this);
                return true;
            } else {
                return left.insert(newValue);
            }
        }
    }

    public int minimum() {
        if (left == null && right == null) {
            return value;
        }
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        if (right != null) {
            rightMin = right.minimum();
        }
        if (left != null) {
            leftMin = left.minimum();
        }
        int min = Math.min(leftMin, rightMin);
        if (value > min) {
            return min;
        } else {
            return value;
        }
    }

    public int maximum() {
        if (left == null && right == null) {
            return value;
        }
        int rightMax = Integer.MIN_VALUE;
        int leftMax = Integer.MIN_VALUE;
        if (right != null) {
            rightMax = right.maximum();
        }
        if (left != null) {
            leftMax = left.maximum();
        }
        int max = Math.max(rightMax, leftMax);
        if (value < max) {
            return max;
        } else {
            return value;
        }
    }

    public Tree search(int searchValue) {
        if (value == searchValue) {
            return this;
        }
        if (left == null && right == null) {
            return null;
        }

        Tree result = null;
        if (left != null) {
            result = left.search(searchValue);
        }

        if (result == null && right != null) {
            result = right.search(searchValue);
        }

        return result;
    }

    public int depth() {
        if (parent == null) {
            return 0;
        }

        return 1 + parent.depth();
    }

    public int descendants() {
        if (left == null && right == null) {
            return 0;
        }
        int leftDescendants = 0;
        int rightDescendants = 0;
        if (left != null) {
            leftDescendants += 1 + left.descendants();
        }
        if (right != null) {
            rightDescendants += 1 + right.descendants();
        }
        return leftDescendants + rightDescendants;
    }

}
