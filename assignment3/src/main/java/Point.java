import java.util.Comparator;

/**
 * Created by rmanaloto on 7/5/14.
 */
public class Point implements Comparable<Point> {

    /**
     * compare points by slope
     * <p/>
     * The SLOPE_ORDER comparator should compare
     * points by the slopes they make with the invoking point (x0, y0).
     * Formally, the point (x1, y1) is less than the point (x2, y2)
     * if and only if the
     * slope (y1 − y0) / (x1 − x0) is less than the slope (y2 − y0) / (x2 − x0).
     * Treat horizontal, vertical, and degenerate line segments as in the slopeTo() method.
     */
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            final double slope1 = Point.this.slopeTo(o1);
            final double slope2 = Point.this.slopeTo(o2);
            if (slope1 < slope2) {
                return -1;
            } else if (slope1 > slope2) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    /**
     * x coordinate
     */
    private final int x;
    /**
     * y coordinate
     */
    private final int y;

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * slope between this point and that point
     * <p/>
     * The slopeTo() method should return the slope between the invoking point (x0, y0)
     * and the argument point (x1, y1),
     * which is given by the formula (y1 − y0) / (x1 − x0).
     * Treat the slope of a horizontal line segment as positive zero;
     * treat the slope of a vertical line segment as positive infinity;
     * treat the slope of a degenerate line segment (between a point and itself)
     * as negative infinity.
     *
     * @param that
     * @return
     */
    public double slopeTo(Point that) {
        final int xDiff = this.x - x;
        if (xDiff == 0) {
            return 0;
        }
        final int yDiff = that.y - y;
        double slopeTo = yDiff / xDiff;
        return slopeTo;
    }

    /**
     * is this point lexicographically smaller than that one?
     * comparing y-coordinates and breaking ties by x-coordinates
     * <p/>
     * The compareTo() method should compare points by their y-coordinates,
     * breaking ties by their x-coordinates.
     * Formally, the invoking point (x0, y0) is less than the argument point (x1, y1)
     * if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that
     * @return
     */
    public int compareTo(Point that) {
        if (y < that.y) {
            return -1;
        } else if (y > that.y) {
            return 1;
        } else {
            if (x < that.x) {
                return -1;
            } else if (x > that.x) {
                return 1;
            }
        }
        return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}
