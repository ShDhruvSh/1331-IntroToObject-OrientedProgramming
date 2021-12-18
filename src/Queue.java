/**
 * Creates a class that defines a queue using nodes.
 *
 * @author dsharma97
 * @version 11.0.12
 * @param <T> data to be held by node
 **/

public class Queue<T> {

    private int length;
    private QueueNode firstNode;
    private QueueNode lastNode;


    /**
     * Creates a Queue using the first-in, first-out protocol.
     */
    public Queue() {
        firstNode = new QueueNode();
        lastNode = firstNode;
        length = 0;
    }

    /**
     * Checks if queue is empty.
     *
     * @return whether queue is empty or not
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Adds an element to the queue.
     *
     * @param element to be added
     */
    public void enqueue(T element) {
        if (length == 0) {
            QueueNode tempNode = new QueueNode(element);
            firstNode = tempNode;
            lastNode = tempNode;
            length++;
        } else {
            QueueNode tempNode = new QueueNode(element);
            lastNode.setParent(tempNode);
            lastNode = tempNode;
            length++;
        }
    }

    /**
     * Removes and returns the first element.
     *
     * @return first node
     */
    public T dequeue() throws IndexOutOfBoundsException {
        QueueNode tempNode = peekNode();

        if (length > 1) {
            firstNode = peekNode().getParent();
            tempNode.setParent(null);
            length--;
            return (T) tempNode.getTData();
        } else if (length == 1) {
            firstNode = new QueueNode();
            lastNode = firstNode;
            length--;
            return (T) tempNode.getTData();
        } else {
            throw new IndexOutOfBoundsException("Your stack is empty!");
        }
    }

    /**
     * Outputs the size of the queue.
     *
     * @return size of queue.
     */
    public int size() {
        return length;
    }

    /**
     * Looks at the top node without removing.
     *
     * @return top node
     */
    public QueueNode peekNode() {
        return firstNode;
    }

    /**
     * Looks at the data of the top element without removing.
     *
     * @return top element's data
     */
    public T peek() {
        return (T) peekNode().getTData();
    }
}
