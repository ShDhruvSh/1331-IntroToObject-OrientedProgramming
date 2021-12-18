/**
 * Creates a simple node class to be used in the Queue class.
 *
 * @author dsharma97
 * @version 11.0.12
 * @param <T> data to be held by node
 **/

public class QueueNode<T> {

    private QueueNode parentNode;
    private T tData;

    /**
     * No parameter constructor to be used by Queue during initialization.
     */
    public QueueNode() {
        //empty
    }

    /**
     * One parameter constructor used during enqueue in Queue.
     *
     * @param data the data of the current node
     */
    public QueueNode(T data) { // 1 param
        tData = data;
        parentNode = null;
    }

    /**
     * Two parameter constructor for a node (in case it is required, not used during Queue).
     *
     * @param data the data of the current node
     * @param parent the parent node
     */
    public QueueNode(T data, QueueNode parent) { // 2 param
        tData = data;
        parentNode = parent;
    }

    /**
     * Outputs the parent node.
     *
     * @return returns parentNode instance variable
     */
    public QueueNode getParent() {
        return parentNode;
    }

    /**
     * Outputs the data of the node it is called upon.
     *
     * @return returns tData instance variable
     */
    public T getTData() {
        return tData;
    }

    /**
     * Overwrites parentNode instance variable.
     *
     * @param parent new parent that replaces the current parent
     */
    public void setParent(QueueNode parent) {
        parentNode = parent;
    }

    /**
     * Overwrites the data of the node it is called upon.
     *
     * @param data overwrites tData instance variable
     */
    public void newTData(T data) {
        tData =  data;
    }

    /**
     * Outputs a String of information about the node it is called upon.
     *
     * @return tData as a string
     */
    public String toString() {
        return "Node: " + tData.toString();
    }

    /**
     * Compares tData instance variable to another object's tData instance variable.
     *
     * @param obj other object that is being compared to the node that the
     *            method is being called upon
     * @return whether tData is the same or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof QueueNode) {
            return tData == ((QueueNode) obj).getTData();
        } else {
            return false;
        }
    }

}