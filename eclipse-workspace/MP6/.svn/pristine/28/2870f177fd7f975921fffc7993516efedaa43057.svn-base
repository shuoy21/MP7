
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


    /**
     * Current node's value.
     */
    private int value;

    /**
     * Initialize a new binary tree.
     * @param setValue value for the root of the tree
     */
    public Tree(final int setValue) {
        parent = null;
        value = setValue;
    }

    /**
     * Initialize a new binary tree node for an existing tree.
     * @param setValue value for the new node
     * @param setParent the parent of this node
     */
    public Tree(final int setValue, final Tree setParent) {
        parent = setParent;
        value = setValue;
    }

    /**
     * Insert a new value into the binary tree.
     * Insertion should fail and return false if the value already exists in the tree.
     * @param newValue the new value to insert
     * @return true if the value does not already exist
     * and is successfully inserted, false otherwise
     */
    public boolean insert(final int newValue) {
        if (value == newValue) {
            return false;
        }
        Tree currentTree = this;
            if (value > newValue) {
                if (right == null) {
                    right = new Tree(newValue, this);
                    return true;
                } else {
                    currentTree = right;
                }
            }
            if (value < newValue) {
                if (left == null) {
                    left = new Tree(newValue, this);
                    return true;
                } else {
                    currentTree = left;
                }
            }
            return currentTree.insert(newValue);
        }

    /**
     * Return the minimum value stored in this binary tree.
     * @return the minimum value stored in the tree.
     */
    public int minimum() {
        int leftMin, rightMin;
        if (left == null && right == null) {
            return value;
        }
        if (left != null) {
            leftMin = left.minimum();
        } else {
            leftMin = value;
        }
        if (right != null) {
            rightMin = right.minimum();
        } else {
            rightMin = value;
        }
        int min = Math.min(leftMin, rightMin);
        if (value < min) {
            return value;
        }
        return min;
    }
    /**
     * Return the maximum value stored in this binary tree.
     * @return the maximumvalue stored in the tree.
     */
    public int maximum() {
        int leftMax, rightMax;
        if (left == null && right == null) {
            return value;
        }
        if (left != null) {
            leftMax = left.maximum();
        } else {
            leftMax = value;
        }
        if (right != null) {
            rightMax = right.maximum();
        } else {
            rightMax = value;
        }
        int max = Math.max(rightMax, leftMax);
        if (value > max) {
            return value;
        }
        return max;
    }
    /**
     * Return the number of nodes below this node in the tree.
     * @return the number of nodes below this node in the tree.
     */
    public int descendants() {
        int leftDecend, rightDecend;
        if (left == null && right == null) {
            return 0;
        }
        if (left != null) {
            leftDecend = 1 + left.descendants();
        } else {
            leftDecend = 0;
        }
        if (right != null) {
            rightDecend = 1 +  right.descendants();
        } else {
            rightDecend = 0;
        }
        return leftDecend + rightDecend;
    }
    /**
     * Search the binary tree for a specific value.
     * @param searchValue the value to search for
     * @return the node containing the specified value,
     * or null if the value is not present in the tree
     */
    public Tree search(final int searchValue) {
        Tree currentNode = this;
        if (value == searchValue) {
            return this;
        }
        if (left == null && right == null) {
            return null;
        }
        if (value > searchValue) {
            if (right == null) {
                return null;
            }
            currentNode = right;
        }
        if (value < searchValue) {
            if (left == null) {
                return null;
            }
            currentNode = left;
        }
        return currentNode.search(searchValue);
    }

    /**
     * Return the depth of this node from the root of the tree.
     * @return the depth of this node relative to the root
     */
    public int depth() {
        if (parent == null) {
            return 0;
        }
        return 1 + parent.depth();
    }
}
