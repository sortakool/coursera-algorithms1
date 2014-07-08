import org.junit.Assert;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedQueueTest {

    private static final Random random = new Random();

    @org.junit.Test
    public void testIsEmpty() throws Exception {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        Assert.assertTrue(queue.isEmpty());
    }

    @org.junit.Test
    public void testNotIsEmpty() throws Exception {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("test");
        Assert.assertFalse(queue.isEmpty());
    }

    @org.junit.Test
    public void testSize() throws Exception {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("test");
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());
    }

    @org.junit.Test
    public void testDequeue() throws Exception {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        final String item1 = "test";
        queue.enqueue(item1);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());
        final String dequeueItem1 = queue.dequeue();
        Assert.assertEquals(item1, dequeueItem1);

    }

    @org.junit.Test
    public void testDequeue2() throws Exception {
        final int N = 100;
        final int iterations = 10;
        for (int i = 1; i < N; i++) {
            for (int iteration = 0; iteration < iterations; iteration++) {
                doDequeue(i);
            }
        }
    }

    private void doDequeue(final int N) {
        System.out.println("-----" + N + "-----");
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        Set<Integer> set = new HashSet<Integer>(N, 1.0f);
//        for(int i=0; i<N; i++) {
//            final int randomInt = random.nextInt();
//            set.add(randomInt);
//            queue.enqueue(randomInt);
//            Assert.assertEquals(i+1, queue.size());
//        }
        int i = 0;
        while (set.size() < N) {
            final int randomInt = Math.max(0, random.nextInt());
            final boolean add = set.add(randomInt);
            if (add) {
                queue.enqueue(randomInt);
                Assert.assertEquals(i + 1, queue.size());
                System.out.println("adding: [i=" + i + "][value=" + randomInt + "]");
                i++;
            }
        }
        for (i = 0; i < N; i++) {
            final Integer dequeueInt = queue.dequeue();
            System.out.println("removing: [i=" + i + "][value=" + dequeueInt + "]");
            final boolean removed = set.remove(dequeueInt);
            Assert.assertTrue(removed);
            Assert.assertEquals(set.size(), queue.size());
            System.out.println("removed: [i=" + i + "][value=" + dequeueInt + "][removed=" + removed + "]");
        }
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals(0, queue.size());
    }

    @org.junit.Test
    public void testSample() throws Exception {
//        doDequeue(8);
    }

    @org.junit.Test
    public void testIterator() throws Exception {

    }
}