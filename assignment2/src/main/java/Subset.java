import java.util.Iterator;

/**
 * Created by rmanaloto on 7/4/14.
 */
public class Subset {

    /**
     * Write a client program Subset.java that takes a command-line integer k;
     * reads in a sequence of N strings from standard input using StdIn.readString();
     * and prints out exactly k of them, uniformly at random.
     * Each item from the sequence can be printed out at most once.
     * You may assume that
     * k ≥ 0 and no greater than the number of string N on standard input.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new RuntimeException("Invalid number of arguments");
        }
        int k = Integer.valueOf(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        String value = null;
        while (!StdIn.isEmpty()) {
            value = StdIn.readString().trim();
            randomizedQueue.enqueue(value);
        }
        Out out = new Out(System.out);
        final Iterator<String> iterator = randomizedQueue.iterator();
        for (int i = 0; i < k; i++) {
            out.println(iterator.next());
        }
    }

}
