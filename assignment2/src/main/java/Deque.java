import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rmanaloto on 7/1/14.
 */
public class Deque<Item> implements Iterable<Item> {

    private static class Node<Item> {
        private Item item;
        private Node<Item> prev = null;
        private Node<Item> next = null;

        private Node(Item item, Node<Item> node, boolean isFirst) {
            this.item = item;
            if (isFirst) {
                if (node != null) {
                    node.prev = this;
                }
                this.next = node;
            } else {
                if (node != null) {
                    node.next = this;
                }
                this.prev = node;
            }
        }
    }

    private static class DequeIterator<Item> implements Iterator<Item> {

        private Node<Item> node;

        private DequeIterator(Node<Item> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return (node != null);
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = node.item;
            this.node = this.node.next;
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
     * construct an empty deque
     */
    public Deque() {
        this.size = 0;
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
        Node<Item> oldNode = this.first;
        this.first = new Node<Item>(item, oldNode, true);
        if (this.last == null) {
            this.last = this.first;
        }
        size++;
        assert (isValid());
    }

    /**
     * // insert the item at the end
     *
     * @param item
     */
    public void addLast(Item item) {
        assertItemIsNotNull(item);
        final Node<Item> oldNode = this.last;
        this.last = new Node<Item>(item, oldNode, false);
        if (this.first == null) {
            this.first = this.last;
        }
        size++;
        assert (isValid());
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
        Item item = this.first.item;
        Node<Item> oldFirst = this.first;
        this.first = this.first.next;
        oldFirst.item = null;
        oldFirst = null;
        if (this.first != null) {
            this.first.prev = null;
        }
        size--;
        clear();
        assert (isValid());
        return item;
    }

    /**
     * @return
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Deque when calling removeLast");
        }
        Item item = this.last.item;
        Node<Item> oldLast = this.last;
        this.last = this.last.prev;
        oldLast.item = null;
        oldLast = null;
        if (this.last != null) {
            this.last.next = null;
        }
        size--;
        clear();
        assert (isValid());
        return item;
    }

    private void clear() {
        if (this.size == 0) {
            if (this.first != null) {
                this.first.item = null;
                this.first = null;
            }
            if (this.last != null) {
                this.last.item = null;
                this.last = null;
            }
            assert (this.first == null) : "first should be empty";
            assert (this.last == null) : "last should be empty";
        } else if (this.size == 1) {
            this.first = this.last;
            this.first.prev = null;
            this.first.next = null;
            this.last.prev = null;
            this.last.next = null;
        }
    }

    private boolean isValid() {
        return isValid(this.first) && isValid(this.last);
    }

    private boolean isValid(Node<Item> node) {
        boolean valid = true;
        if (node != null) {
            if (node.prev != null) {
                if (node.prev.item == null) {
                    valid = false;
                }
            }
            if (node.next != null) {
                if (node.next.item == null) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    /**
     * // return an iterator over items in order from front to end
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return new DequeIterator<Item>(this.first);
    }

    /**
     * // unit testing
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}