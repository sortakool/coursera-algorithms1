import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rmanaloto on 7/1/14.
 */
public class Deque2<Item> implements Iterable<Item> {

    private static class Node<Item> {
        private Item item;
        private Node<Item> prev = null;
        private Node<Item> next = null;

        private Node(Item item, Node<Item> prev, Node<Item> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;

            if (this.next != null) {
                this.next.prev = this;
            }
            if (this.prev != null) {
                this.prev.next = this;
            }
        }
    }

    private static class DequeIterator<Item> implements Iterator<Item> {

        private Node<Item> firstNode;
        private Node<Item> lastNode;

        private DequeIterator(Node<Item> firstNode, Node<Item> lastNode) {
            this.firstNode = firstNode;
            this.lastNode = lastNode;
        }

        @Override
        public boolean hasNext() {
            return (firstNode != null) || (lastNode != null);
        }

        @Override
        public Item next() {
            Item item = null;
            //fist
            if (firstNode != null) {
                item = firstNode.item;
                firstNode = firstNode.next;
            }
//            //last
//            if (lastNode != null) {
//                item = firstNode.item;
//                firstNode = firstNode.next;
//            }
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private int size = 0;
    private Node<Item> first;
    private Node<Item> last;

    /**
     * // construct an empty deque
     */
    public Deque2() {
        this.size = 0;
//        this.node = new Node<Item>();
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * // return the number of items on the deque
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * // insert the item at the front
     *
     * @param item
     */
    public void addFirst(Item item) {
        assertItemIsNotNull(item);
        Node<Item> oldFirst;
        if (first != null) {
            oldFirst = first;
        } else {
            oldFirst = last;
        }
        final Node<Item> newFirst = new Node<Item>(item, null, oldFirst);
        this.first = newFirst;
        if (this.last == null) {
            this.last = newFirst;
        } else if (this.last.prev == null) {
            this.last.prev = oldFirst;
        }
        size++;
    }

    /**
     * // insert the item at the end
     *
     * @param item
     */
    public void addLast(Item item) {
        assertItemIsNotNull(item);
        final Node<Item> oldLast;
        if (last != null) {
            oldLast = last;
        } else {
            oldLast = first;
        }
        final Node<Item> newLast = new Node<Item>(item, oldLast, null);
        this.last = newLast;
        if (this.first == null) {
            this.first = newLast;
        } else if (this.first.next == null) {
            this.first.next = oldLast;
        }
        size++;
    }

    private void assertItemIsNotNull(Item item) {
        if (item == null) {
            throw new NullPointerException("item cannot be null");
        }
    }

    /**
     * @return
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Deque when calling removeFirst");
        }
        Item item = null;
        if (this.first != null) {
            item = this.first.item;
            this.first = this.first.next;
        }
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        }
        size--;
        return item;
    }

    /**
     * @return
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Deque when calling removeLast");
        }
        Item item = null;
        if (this.last != null) {
            item = this.last.item;
            this.last = this.last.prev;
        }
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        }
        size--;
        return item;
    }


    /**
     * // return an iterator over items in order from front to end
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return new DequeIterator<Item>(first, last);
    }

    /**
     * // unit testing
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}