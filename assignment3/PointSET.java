import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by rmanaloto on 8/8/14.
 */
public class PointSET {

    private TreeSet<Point2D> points;

    /**
     * construct an empty set of points
     */
    public PointSET() {
        points = new TreeSet<>();
    }

    /**
     * is the set empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return points.isEmpty();
    }

    /**
     * number of points in the set
     *
     * @return
     */
    public int size() {
        return points.size();
    }

    /**
     * add the point p to the set (if it is not already in the set)
     *
     * @param p
     */
    public void insert(Point2D p) {
        points.add(p);
    }

    /**
     * does the set contain the point p?
     *
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {
        return points.contains(p);
    }

    /**
     * draw all of the points to standard draw
     */
    public void draw() {
        for (Point2D point : points) {
            StdDraw.point(point.x(), point.y());
        }
    }

    /**
     * all points in the set that are inside the rectangle
     *
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        List<Point2D> pointsInRange = new ArrayList<>(size());
        if (rect != null) {
            for (Point2D point : points) {
                if (rect.contains(point)) {
                    pointsInRange.add(point);
                }
            }
        }
        return pointsInRange;
    }

    /**
     * a nearest neighbor in the set to p; null if set is empty
     *
     * @param p
     * @return
     */
    public Point2D nearest(Point2D p) {
        Point2D nearest = null;
        double nearestDistance = Double.MAX_VALUE;
        for (Point2D point : points) {
            if (point.equals(p)) {
                nearest = point;
                break;
            }
            final double distanceTo = point.distanceSquaredTo(p);
            if (distanceTo < nearestDistance) {
                nearest = point;
            }
        }
        return nearest;
    }
}
