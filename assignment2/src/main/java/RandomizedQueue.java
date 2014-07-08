import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rmanaloto on 7/1/14.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private static class RandomizedQueueIterator<Item> implements Iterator<Item> {

        private final Item[] items;
        private final int[] indexes;
        private int index;

        private RandomizedQueueIterator(Item[] items, int size) {
            this.items = items;
            this.indexes = new int[size];
            for (int i = 0; i < size; i++) {
                this.indexes[i] = i;
            }
            this.index = 0;
            shuffle(this.indexes);
        }

        @Override
        public boolean hasNext() {
            return index < indexes.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = items[indexes[index++]];
            assert (item != null) : "item is null at index " + (index - 1);
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private Item[] items;
    private int size = 0;

    /**
     * // construct an empty randomized queue
     */
    public RandomizedQueue() {
        this.size = 0;
        this.items = (Item[]) (new Object[2]);
    }

    /**
     * // is the queue empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * // return the number of items on the queue
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * add the item
     *
     * @param item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("null item");
        }
        if (this.items.length == size) {
            resize(2 * items.length);
        }
        this.items[size++] = item;
    }

    private void resize(int newSize) {
        Item[] newItems = (Item[]) (new Object[newSize]);
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                newItems[count] = items[i];
                count++;
                if (count == size) {
                    break;
                }
            }
        }
        this.items = newItems;
    }

    /**
     * // delete and return a random item
     *
     * @return
     */
    public Item dequeue() {
        Item item;
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue underflow");
        int randomIndex = StdRandom.uniform(this.size);
        item = items[randomIndex];
        assert (item != null) : "Null item at randomIndex " + randomIndex;
        this.items[randomIndex] = null;
        this.size--;
        exchange(items, randomIndex, size);
        // shrink size of array if necessary
        if (size > 0 && size == items.length / 4) resize(items.length / 2);
        return item;
    }


    /**
     * // return (but do not delete) a random item
     *
     * @return
     */
    public Item sample() {
        Item item;
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue underflow");
        int randomIndex = StdRandom.uniform(this.size);
        item = items[randomIndex];
        assert (item != null) : "Null item at randomIndex " + randomIndex;
        return item;
    }

    /**
     * // return an independent iterator over items in random order
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<Item>(this.items, this.size);
    }

    /**
     * // unit testing
     *
     * @param args
     */
    public static void main(String[] args) {
    }

    private static <T> void shuffle(T[] values) {
        for (int i = 0; i < values.length; i++) {
            final int j = StdRandom.uniform(values.length);
            exchange(values, i, j);
        }
    }

//    private static void shuffle(int[] values) {
//        for (int i = 0; i < values.length; i++) {
//            final int j = StdRandom.uniform(values.length);
//            exchange(values, i, j);
//        }
//    }

    private static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // choose index uniformly in [i, N-1]
            int r = i + (int) (StdRandom.uniform() * (N - i));
            if (i != r) {
                int swap = a[r];
                a[r] = a[i];
                a[i] = swap;
            }
        }
    }

    private static <T> void exchange(T[] items, int i, int j) {
        if (i != j) {
            T item = items[i];
            items[i] = items[j];
            items[j] = item;
        }
    }


    private static void exchange(int[] items, int i, int j) {
        if (i != j) {
            int item = items[i];
            items[i] = items[j];
            items[j] = item;
        }
    }
}
