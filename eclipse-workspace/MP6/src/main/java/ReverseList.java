import java.util.LinkedList;
/**
 * A class that adds a reversal method to the existing LinkedList class.
 * @param <T> type of linked list
 */
public class ReverseList<T> extends LinkedList<T> {

    /**
     * Empty list constructor.
     */
    public ReverseList() {
        super();
    }
    /**
     * Create a ReverseLinkedList from another collection type.
     * @param collection the collection to create the ReverseLinkedList from
     */
    public ReverseList(final java.util.Collection<? extends T> collection) {
          super(collection);
    }

    /**
     * helper function for reverse().
     * @param returnList the list to be reversed
     * @return reversedList
     */
    private java.util.LinkedList<T> reverse(final ReverseList<T> returnList) {
        if (peekFirst() == null) {
            return returnList;
        }
        returnList.addFirst(this.removeFirst());
        return reverse(returnList);
    }
    /**
     * Reverse the linked list.
     * @return a new LinkedList containing the same elements
     * as the original list, but in the opposite order.
     */
    public java.util.LinkedList<T> reverse() {
        ReverseList<T> reversedList = new ReverseList<T>();
        return reverse(reversedList);
    }
}
