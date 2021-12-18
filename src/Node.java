/**
 * Creates a simple node class to be used in the LinkedList class.
 *
 * @author dsharma97
 * @version 11.0.12
 * @param <T> data to be held by node
 **/

public class Node<T> {

    private Node<T> next;
    private T data;

    /**
     * No parameter constructor.
     */
    public Node() {
        //empty
    }

    /**
     * One parameter constructor.
     *
     * @param data the data of the current node
     */
    public Node(T data) {
        this.data = data;
        next = null;
    }

    /**
     * Two parameter constructor.
     *
     * @param data the data of the current node
     * @param next the parent node
     */
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }


    /**
     * Outputs the parent node.
     *
     * @return returns next instance variable
     */
    public Node getNext() {
        return next;
    }

    /**
     * Outputs the data of the node it is called upon.
     *
     * @return returns tData instance variable
     */
    public T getData() {
        return data;
    }

    /**
     * Overwrites next instance variable.
     *
     * @param next new parent that replaces the current parent
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Overwrites the data of the node it is called upon.
     *
     * @param data overwrites data instance variable
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Outputs a String of information about the node it is called upon.
     *
     * @return data as a string
     */
    public String toString() {
        return "Node: " + data.toString();
    }

    /**
     * Compares data instance variable to another object's data instance variable.
     *
     * @param obj other object that is being compared to the node that the
     *            method is being called upon
     * @return whether data is the same or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return data.equals(((Node) obj).getData());
        } else {
            return false;
        }
    }
}