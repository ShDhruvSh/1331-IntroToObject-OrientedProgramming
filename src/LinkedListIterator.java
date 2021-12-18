import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates an iterator to be used by LinkedList.
 *
 * @author dsharma97
 * @version 11.0.12
 * @param <E> generic data type E
 */
public class LinkedListIterator<E> implements Iterator<E> {
    private Node<E> next;

    /**
     * Creates a LinkedListIterator starting from the first/head node.
     *
     * @param first head node
     */
    public LinkedListIterator(Node<E> first) {
        next = first;
    }

    /**
     * Checks of there is a next element.
     *
     * @return if next element exists
     */
    public boolean hasNext() {
        if (next == null) {
            return false;
        } else {
            return next.getData() != null;
        }
    }

    /**
     * Iterates to the next element and returns it.
     *
     * @throws NoSuchElementException is next element doesn't exist
     * @return the data of the next element
     */
    public E next() throws NoSuchElementException {
        if (hasNext()) {
            E data = next.getData();
            next = next.getNext();
            return data;
        } else if (next == null) {
            throw new NoSuchElementException();
        } else {
            E data = next.getData();
            next = null;
            return data;
        }
    }
}
