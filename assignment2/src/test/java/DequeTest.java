import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void testIsEmpty() throws Exception {
        Deque<String> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    public void testAddFirst_RemoveFirst() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 1;
        for (int i = 0; i < N; i++) {
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeFirst();
            final Integer value = deque.removeFirst();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testAddFirst_RemoveLast() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 1;
        for (int i = 0; i < N; i++) {
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeLast();
            final Integer value = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testAddFirstAddLast_RemoveFirstRemoveLast() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 1;
        for (int i = 0; i < N; i++) {
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeFirst();
            final Integer value = deque.removeFirst();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeLast();
            final Integer value = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testAddFirstAddLast_RemoveLastRemoveFirst() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 1;
        for (int i = 0; i < N; i++) {
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeLast();
            final Integer value = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeFirst();
            final Integer value = deque.removeFirst();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testMultipleAddFirst_MultipleRemoveFirst() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeFirst();
            final Integer value = deque.removeFirst();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testMultipleAddFirst_MultipleRemoveLast() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeLast();
            final Integer value = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testAddLast_RemoveLast() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 1;
        for (int i = 0; i < N; i++) {
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeLast();
            final Integer value = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testMultipleAddLast_MultipleRemoveLast() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeLast();
            final Integer value = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testMultipleAddLast_MultipleRemoveFirst() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            final Integer javaValue = javaDeque.removeFirst();
            final Integer value = deque.removeFirst();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaValue, value);
        }
    }

    @Test
    public void testMultipleAddFirstAddLast_MultipleRemoveLast() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            //first
            final Integer javaFirstValue = javaDeque.removeLast();
            final Integer firstValue = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaFirstValue, firstValue);

            //last
            final Integer javaLastValue = javaDeque.removeLast();
            final Integer lastValue = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaLastValue, lastValue);
        }
    }

    @Test
    public void testFirstAndLast2() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N*2; i++) {
            //first
            final Integer javaFirstValue = javaDeque.removeLast();
            final Integer firstValue = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaFirstValue, firstValue);
        }
    }

    @Test
    public void testFirstAndLast3() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N*2; i++) {
            //last
            final Integer javaLastValue = javaDeque.removeLast();
            final Integer lastValue = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaLastValue, lastValue);
        }
    }

    @Test
    public void testLastAndFirst() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());

            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N; i++) {
            //last
            final Integer javaLastValue = javaDeque.removeLast();
            final Integer lastValue = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaLastValue, lastValue);
        }
    }

    @Test
    public void testLastAndFirst3() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());

            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        for (int i = 0; i < N*2; i++) {
            //first
            final Integer javaFirstValue = javaDeque.removeLast();
            final Integer firstValue = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaFirstValue, firstValue);
        }
    }

    @Test
    public void testAddLastAddLast_RemoveLastRemoveFirst() throws Exception {
        java.util.Deque<Integer> javaDeque = new LinkedList<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());

            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        final int size = javaDeque.size();
        assertEquals(N*2, size);
        assertEquals(javaDeque.size(), deque.size());
        for (int i = 0; i < N; i++) {
            //last
            final Integer javaLastValue = javaDeque.removeLast();
            final Integer lastValue = deque.removeLast();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaLastValue, lastValue);

            //first
            final Integer javaFirstValue = javaDeque.removeFirst();
            final Integer firstValue = deque.removeFirst();
            assertEquals(javaDeque.size(), deque.size());
            assertEquals(javaFirstValue, firstValue);
        }
    }

    @Test
    public void testAddFirst_Iterator() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddLast_Iterator() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddFirstAddLast_Iterator() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddLastAddFirst_Iterator() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());

            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());
        }
        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddFirstAddLast_RemoveFirstRemoveLast_Iterator() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }

        for (int i = 0; i < N/2; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());
        }

        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddFirstAddLast_RemoveFirstRemoveLast_Iterator3() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 10;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            if(i % 3 == 0 && !javaDeque.isEmpty()) {
                //first
                javaDeque.removeFirst();
                deque.removeFirst();
                assertEquals(javaDeque.size(), deque.size());
            }
            if(i % 7 == 0 && !javaDeque.isEmpty()) {
                //last
                javaDeque.removeLast();
                deque.removeLast();
                assertEquals(javaDeque.size(), deque.size());
            }

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());

            if(i % 3 == 0 && !javaDeque.isEmpty()) {
                //last
                javaDeque.removeLast();
                deque.removeLast();
                assertEquals(javaDeque.size(), deque.size());
            }
            if(i % 7 == 0 && !javaDeque.isEmpty()) {
                //first
                javaDeque.removeFirst();
                deque.removeFirst();
                assertEquals(javaDeque.size(), deque.size());
            }
        }

        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        System.out.println(i);
        assertFalse(javaIterator.hasNext());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddFirstAddLast_RemoveFirstRemoveLast_Iterator2() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());

            if(i % 2 == 0) {
                //first
                javaDeque.removeFirst();
                deque.removeFirst();
                assertEquals(javaDeque.size(), deque.size());

                //last
                javaDeque.removeLast();
                deque.removeLast();
                assertEquals(javaDeque.size(), deque.size());
            }
        }

        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddLastAddFirst_RemoveFirstRemoveLast_Iterator3() throws Exception {
        java.util.Deque<Integer> javaDeque = new ArrayDeque<>();
        Deque<Integer> deque = new Deque<>();
        final int N = 100;
        for (int i = 0; i < N; i++) {
            //last
            javaDeque.addLast(i);
            deque.addLast(i);
            assertEquals(javaDeque.size(), deque.size());

            //first
            javaDeque.addFirst(i);
            deque.addFirst(i);
            assertEquals(javaDeque.size(), deque.size());

            if(i % 2 == 0) {
                //first
                javaDeque.removeFirst();
                deque.removeFirst();
                assertEquals(javaDeque.size(), deque.size());

                //last
                javaDeque.removeLast();
                deque.removeLast();
                assertEquals(javaDeque.size(), deque.size());
            }
        }

        final Iterator<Integer> javaIterator = javaDeque.iterator();
        final Iterator<Integer> iterator = deque.iterator();
        int i =0;
        while(javaIterator.hasNext()) {
            final Integer javaNext = javaIterator.next();
            final Integer next = iterator.next();
            assertEquals(javaNext, next);
            i++;
        }
        assertFalse(iterator.hasNext());
    }
}