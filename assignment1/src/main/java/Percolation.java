/**
 * Created by rmanaloto on 6/26/14.
 */
public class Percolation {

//    private enum State {
//        BLOCKED, OPEN, FULL;
//    }

    private static final byte BLOCKED = 0;
    private static final byte OPEN = 1 << 0;
    private static final byte FULL = 1 << 1;
    private static final byte TOP_CONNECTED = 1 << 2;
    private static final byte BOTTOM_CONNECTED = 1 << 3;
    private static final byte LEFT_CONNECTED = 1 << 4;
    private static final byte RIGHT_CONNECTED = 1 << 5;

    private static final int INVALID_INDEX = -1;

    private final int N;
    private final int cellCount;
    private final int size;
    private final WeightedQuickUnionUF unionFind;
    //    private final WeightedQuickUnionUF bottomRowUnionFind;
    private boolean percolates = false;
    private final int topRow;
    private final int bottomRow;
    private final int leftColumn;
    private final int rightColumn;
    private final int virtualTop;
    //    private final int virtualBottom;
    private final byte[] siteStates;

//    private int percolationIndex = INVALID_INDEX;

    /**
     * create N-by-N grid, with all sites blocked
     *
     * @param N
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Invalid grid dimension " + N);
        }
        this.N = N;
        this.cellCount = N * N;
        this.size = cellCount + 1;
        this.virtualTop = cellCount;
        unionFind = new WeightedQuickUnionUF(this.size);
        topRow = 1;
        bottomRow = N;
        leftColumn = 1;
        rightColumn = N;

        siteStates = new byte[cellCount + 1];
//        Arrays.fill(states, State.BLOCKED);

        //connect top row to virtual top
        for (int i = 0; i < N; i++) {
            unionFind.union(virtualTop, i);
        }
//        for(int i=0; i<N; i++) {
//            final int root = weightedQuickUnionUF.find(i);
//            System.out.println("[i="+i+"][root="+root+"]");
//        }
//        //connect top row to virtual bottom
//        for (int i = (cellCount - N); i < cellCount; i++) {
//            weightedQuickUnionUF.union(virtualBottom, i);
//        }
//        for(int i=(cellCount-N); i<cellCount; i++) {
//            final int root = weightedQuickUnionUF.find(i);
//            System.out.println("[i="+i+"][root="+root+"]");
//        }
//        this.virtualBottom = N;
//        bottomRowUnionFind = new WeightedQuickUnionUF(N + 1);
//        for (int i = 0; i < N; i++) {
//            bottomRowUnionFind.union(virtualBottom, i);
//        }
    }

    /**
     * open site (row i, column j) if it is not already
     *
     * @param i
     * @param j
     */
    public void open(int i, int j) {
        final int index = validateAndGetIndex(i, j);
        if (siteStates[index] == BLOCKED) { //not open
            int oldRoot = unionFind.find(index);
            final boolean top = isTop(i);
            final boolean bottom = isBottom(i);

            final int topIndex = getTopIndex(i, j);
            final int bottomIndex = getBottomIndex(i, j);
            final int leftIndex = getLeftIndex(i, j);
            final int rightIndex = getRightIndex(i, j);

            siteStates[index] |= OPEN;
            siteStates[oldRoot] |= OPEN;

            unionIndexes(topIndex, index);
            unionIndexes(bottomIndex, index);
            unionIndexes(leftIndex, index);
            unionIndexes(rightIndex, index);

            int newRoot = unionFind.find(index);

            siteStates[newRoot] |= OPEN;

            final boolean connectedToVirtualTop =
                    unionFind.connected(index, virtualTop);

            if (connectedToVirtualTop) {
                siteStates[index] |= FULL;
                siteStates[oldRoot] |= FULL;
                siteStates[newRoot] |= FULL;
            }

            if (top) {
                siteStates[index] |= TOP_CONNECTED;
                siteStates[oldRoot] |= TOP_CONNECTED;
                siteStates[newRoot] |= TOP_CONNECTED;
            }

            if (bottom) {
                siteStates[index] |= BOTTOM_CONNECTED;
                siteStates[oldRoot] |= BOTTOM_CONNECTED;
                siteStates[newRoot] |= BOTTOM_CONNECTED;
            }

            if (hasState(siteStates[newRoot], TOP_CONNECTED)
                    && hasState(siteStates[newRoot], BOTTOM_CONNECTED)) {
                percolates = true;
            }


//                final boolean bottom = isBottom(i);
//                if (bottom) {
//                    final boolean connectedToVirtualTop =
//                            weightedQuickUnionUF.connected(index, virtualTop);
//                    if (connectedToVirtualTop) {
//                        percolates = true;
////                        System.out.println(
////                                "percolates: [i=" + i + "][j=" + j + "]");
////                        percolationIndex = index;
//                    }
//                }


//            if (bottom) {
//                bottomRowUnionFind.union(j, virtualBottom);
//            }
//            checkPercolates(index);
        }
    }

    private void checkPercolates(int index) {
        final int column = getYCoordinate(index);
        if (!percolates) {
            final boolean connectedToVirtualTop =
                    unionFind.connected(index, virtualTop);
            if (connectedToVirtualTop) {
                siteStates[index] |= FULL;
                for (int bottomRowIndex = (cellCount - N);
                     bottomRowIndex < cellCount;
                     bottomRowIndex++) {
                    if (siteStates[bottomRowIndex] != BLOCKED) {
                        boolean connectedToBottomRow =
                                unionFind.connected(bottomRowIndex, index);
                        if (connectedToBottomRow) {
                            percolates = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void unionIndexes(int adjacentIndex, int index) {
        if ((adjacentIndex != INVALID_INDEX)
                && (siteStates[adjacentIndex] != BLOCKED)) {
            unionFind.union(adjacentIndex, index);
        }
    }

    /**
     * is site (row i, column j) open?
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isOpen(int i, int j) {
        final int index = validateAndGetIndex(i, j);
        return hasState(siteStates[index], OPEN);
    }

    /**
     * is site (row i, column j) full?
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isFull(int i, int j) {
        boolean full = false;
        final int index = validateAndGetIndex(i, j);
        full = hasState(siteStates[index], FULL);
//        return (states[index] == State.FULL);
//        boolean isOpen = siteStates[index];
//        if (isOpen) {
//            full = unionFind.connected(index, virtualTop);
////            if (percolates) {
////                final int root = weightedQuickUnionUF.find(index);
////                full = (root == virtualTop);
////            }
//        }
        return full;
    }

    private boolean hasState(byte siteValue, byte state) {
        final int andValue = siteValue & state;
        return (andValue != 0);
    }

    /**
     * does the system percolate?
     *
     * @return
     */
    public boolean percolates() {
        return percolates;
    }

    private int validateAndGetIndex(int i, int j) {
        validate(i, j);
        return getIndex(i, j);
    }

    private boolean isTop(int i) {
        return i == 1;
    }

    private boolean isBottom(int i) {
        return i == N;
    }

    private int getTopIndex(int i, int j) {
        int calculatedIndex = INVALID_INDEX;
        if ((i > topRow)) {
            int temp = i - 1;
            calculatedIndex = getIndex(temp, j);
        }
        return calculatedIndex;
    }

    private int getBottomIndex(int i, int j) {
        int calculatedIndex = INVALID_INDEX;
        if ((i < bottomRow)) {
            int temp = i + 1;
            calculatedIndex = getIndex(temp, j);
        }
        return calculatedIndex;
    }

    private int getLeftIndex(int i, int j) {
        int calculatedIndex = INVALID_INDEX;
        if ((j > leftColumn)) {
            int temp = j - 1;
            calculatedIndex = getIndex(i, temp);
        }
        return calculatedIndex;
    }

    private int getRightIndex(int i, int j) {
        int calculatedIndex = INVALID_INDEX;
        if ((j < rightColumn)) {
            int temp = j + 1;
            calculatedIndex = getIndex(i, temp);
        }
        return calculatedIndex;
    }

    private void validate(int i, int j) {
        if (i < 1) {
            throw new IndexOutOfBoundsException("Invalid row " + i);
        }
        if (i > N) {
            throw new IndexOutOfBoundsException("Invalid row " + i);
        }
        if (j < 1) {
            throw new IndexOutOfBoundsException("Invalid column " + i);
        }
        if (j > N) {
            throw new IndexOutOfBoundsException("Invalid column " + i);
        }
    }

    private int getIndex(int i, int j) {
        int index = ((i - 1) * N) + (j - 1);
        return index;
    }

    private int getXCoordinate(int index) {
        int x = (index / N) + 1;
        return x;
    }

    private int getYCoordinate(int index) {
        int y = (index % N) + 1;
        return y;
    }
}
