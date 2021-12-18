import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Creates a LinkedList using Nodes.
 *
 *  @author dsharma97
 *  @version 11.0.12
 *  @param <E> elements used in list
 */

public class LinkedList<E> implements List<E> {
    private int size;
    private Node<E> head;

    /**
     * Zero argument constructor for LinkedList.
     */
    public LinkedList() {
        size = 0;
        head = null;
    }

    /**
     * Creates a LinkedList out of the inputted array of elements.
     *
     * @param elements what will be converted into nodes which will make up the LinkedList
     */
    public LinkedList(E[] elements) {
        size = elements.length;
        head = new Node(elements[0]);
        Node currNode = head;
        for (int i = 1; i < elements.length; i++) {
            currNode.setNext(new Node(elements[i]));
            currNode = currNode.getNext();
        }
    }


    /**
     * Inserts the element at the front of the list.
     *
     * @param element data we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     */
    public void add(E element) {
        if (element != null && size == 0) {
            Node<E> newHead = new Node<>(element);
            newHead.setNext(head);
            head = newHead;
            size++;
        } else if (element != null && size > 0) {
            Node<E> newHead = new Node<>(element);
            newHead.setNext(head);
            head = newHead;
            size++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Inserts the element at the specified index.
     *
     * @param index index to add the element
     * @param element data we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     * @throws IndexOutOfBoundsException if the passed in index is invalid. index == list.size() is valid
     */
    public void add(int index, E element) {
        if (element != null && index == 0) {
            add(element);
        } else if (element != null && index > 0 && index <= size) {
            Node<E> currNode = head;
            for (int i = 1; i < index; i++) {
                currNode = currNode.getNext();
            }
            Node<E> toBeAdded = new Node(element);
            toBeAdded.setNext(currNode.getNext());
            currNode.setNext(toBeAdded);
            size++;
        } else if (element != null) {
            throw new IndexOutOfBoundsException();
        } else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index index of element to be removed
     * @return the removed element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (size > 0 && index >= 0 && index < size) {
            if (index == 0) {
                return remove();
            } else {
                Node<E> currNode = head;
                for (int j = 0; j < index - 1; j++) {
                    currNode = currNode.getNext();
                }
                E removedHeadData = (E) currNode.getNext().getData();
                currNode.setNext(currNode.getNext().getNext());
                size--;
                return removedHeadData;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the specified element from the list and returns it.
     *
     * @param element data to be removed
     * @return the removed element from the list
     * @throws NoSuchElementException if the passed in element is not in the list
     * @throws IllegalArgumentException is passed in element is null
     */
    public E remove(E element) throws NoSuchElementException, IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> currNode;
        if (head.getData().equals(element)) {
            return remove();
        }
        currNode = head;
        while (currNode.getNext() != null) {
            if (currNode.getNext().getData().equals(element)) {
                E removedData = (E) currNode.getNext().getData();

                currNode.setNext(currNode.getNext().getNext());
                size--;
                return removedData;
            } else {
                currNode = currNode.getNext();
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Removes the head (first element) from the list and returns it.
     *
     * @return the removed element from the head of the list, null if the list is empty
     */
    public E remove() {
        if (size > 0) {
            E removedHeadData = head.getData();
            head = head.getNext();
            size--;
            return removedHeadData;
        } else {
            return null;
        }
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index index of the element to return
     * @return element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (size > 0 && index >= 0 && index < size) {
            if (index == 0) {
                return head.getData();
            }
            Node<E> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }
            E getData = currNode.getData();
            return getData;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Checks if a list contains a specific element.
     *
     * @param element data to check for in list
     * @return boolean representing if the list has the element or not
     * @throws IllegalArgumentException is passed in element is null
     */
    public boolean contains(E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        Iterator i = iterator();
        Node<E> currNode = head;
        while (i.hasNext()) {
            if (currNode.getData().equals(element)) {
                return true;
            }
            currNode = currNode.getNext();
            i.next();
        }
        return false;
    }

    /**
     * Replaces the element at a specific index with the passed in data.
     *
     * @param index index of the element to replace
     * @param element the element to set
     * @return element that has been replaced
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     * @throws IllegalArgumentException if the passed in element is null
     */
    public E set(int index, E element) {
        if (size > 0 && index >= 0 && index < size && element != null) {
            Node<E> currNode = head;
            for (int i = 0; i <= index - 1; i++) {
                currNode = currNode.getNext();
            }
            E oldData = currNode.getData();
            currNode.setData(element);
            return oldData;
        } else if (element == null) {
            throw new IllegalArgumentException();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes duplicate nodes in the LinkedList.
     */
    public void removeDuplicates() {
        Node<E> currNode = head;
        for (int i = 0; i < size; i++) {
            Node<E> currCheckNode = currNode;
            for (int j = 0; j < size - i; j++) {
                currCheckNode = currCheckNode.getNext();
                if (currNode.equals(currCheckNode)) {
                    remove(j + i + 1);
                    j--;
                }
            }
            currNode = currNode.getNext();
        }
    }

    /**
     * Creates an array from the LinkedList's nodes.
     *
     * @return an array of elements of the LinkedList
     */
    public E[] toArray() {
        E[] arr = (E[]) new Object[size];
        Iterator i = iterator();
        for (int j = 0; j < size; j++) {
            arr[j] = (E) i.next();
        }
        return arr;
    }

    /**
     * Clears the list.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     * @return int representing size of list
     */
    public int size() {
        return size;
    }

    /**
     * Creates an iterator for the LinkedList.
     *
     * @return the Iterator object for LinkedList
     */
    @Override
    public Iterator<E> iterator() {
        LinkedListIterator<E> i = new LinkedListIterator(head);
        return i;
    }
}
