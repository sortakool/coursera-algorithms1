import java.util.Set;
import java.util.TreeSet;

/**
 * Created by rmanaloto on 8/8/14.
 */
public class KdTree {

    private static class Node {
        private Point2D p;      // the point
        private boolean vertical;   //
        private int N;              //size
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree

        public Node(Point2D p, RectHV rect, boolean vertical) {
            this.p = p;
            this.rect = rect;
            this.vertical = vertical;
        }
    }

    private Node root;
    private boolean debug;

    /**
     * construct an empty set of points
     */
    public KdTree() {
    }

    /**
     * is the set empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * number of points in the set
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    /**
     * add the point p to the set (if it is not already in the set)
     *
     * @param p
     */
    public void insert(Point2D p) {
        root = insert(root, p);
    }

    private Node insert(Node x, Point2D p) {
        if (x == null) {
            RectHV rect = new RectHV(p.x(), p.y(), p.x(), p.y());
            final Node node = new Node(p, rect, true);
            node.N = 1;
            return node;
        }
        final int compareTo = compareTo(x, p);
        if (compareTo < 0) {
            x.lb = insert(x.lb, p);
            x.lb.vertical = !x.vertical;
        } else if (compareTo > 0) {
            x.rt = insert(x.rt, p);
            x.rt.vertical = !x.vertical;
        } else {
            //same point, do nothing
            return x;
        }

        x.N = size(x.lb) + size(x.rt) + 1;
        updateRect(x, p);
        return x;
    }

    private void updateRect(Node x, Point2D p) {
        if ((x != null) && (x.rect != null)) {
            if ((p.x() < x.rect.xmin()) && (p.y() < x.rect.ymin())) {
                x.rect = new RectHV(p.x(), p.y(), x.rect.xmax(), x.rect.ymax());
            } else if ((p.x() > x.rect.xmax()) && (p.y() > x.rect.ymax())) {
                x.rect = new RectHV(x.rect.xmin(), x.rect.ymin(), p.x(), p.y());
            }
        }
    }

    private int compareTo(Node x, Point2D p) {
        int compareTo = 0;
        if ((x != null) && (x.p != null)) {
            if (x.vertical) {
                compareTo = Double.compare(p.x(), x.p.x());
                if (compareTo == 0) {
                    int compareTo2 = Double.compare(p.y(), x.p.y());
                    if (compareTo2 != 0) {
                        compareTo = 1;
                    }
                }
            } else {
                compareTo = Double.compare(p.y(), x.p.y());
                if (compareTo == 0) {
                    int compareTo2 = Double.compare(p.x(), x.p.x());
                    if (compareTo2 != 0) {
                        compareTo = 1;
                    }
                }
            }
        }
        return compareTo;
    }

    /**
     * does the set contain the point p?
     *
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {
        final Node node = get(p);
        return (node != null);
    }

    private Node get(Point2D p) {
        return get(root, p);
    }

    private Node get(Node x, Point2D p) {
        if (x == null) {
            return null;
        }
        if (!x.rect.contains(p)) {
            return null;
        }
        final int compareTo = compareTo(x, p);
        if (compareTo < 0) {
            return get(x.lb, p);
        } else if (compareTo > 0) {
            return get(x.rt, p);
        } else {
            return x;
        }
    }

    /**
     * draw all of the points to standard draw
     */
    public void draw() {
        draw(null, root);
    }

    private void draw(Node parent, Node child) {
        if (child != null) {
            StdDraw.setPenRadius(.01);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(child.p.x(), child.p.y());
            StdDraw.setPenRadius(.01);
            if (parent == null) {
                if (child.vertical) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.line(child.p.x(), 0, child.p.x(), 1);
                    if (debug) {
                        System.out.println("\tRed Vertical line: " + new Point2D(child.p.x(), 0) + " to " + new Point2D(child.p.x(), 1));
                    }
                } else {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.line(0, child.p.y(), 1, child.p.y());
                    if (debug) {
                        System.out.println("\tBlue Horizontal line: " + new Point2D(0, child.p.y()) + " to " + new Point2D(1, child.p.y()));
                    }
                }
            } else {
                if (parent.vertical) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    if (parent.p.x() < child.p.x()) {
                        StdDraw.line(parent.p.x(), child.p.y(), 1, child.p.y());
                        if (debug) {
                            System.out.println("\tBlue Horizontal line: " + new Point2D(parent.p.x(), child.p.y()) + " to " + new Point2D(1, child.p.y()));
                        }
                    } else if (parent.p.x() >= child.p.x()) {
                        StdDraw.line(0, child.p.y(), parent.p.x(), child.p.y());
                        if (debug) {
                            System.out.println("\tBlue Horizontal line: " + new Point2D(0, child.p.y()) + " to " + new Point2D(parent.p.x(), child.p.y()));
                        }
                    }
                } else {    //parent horizontal
                    StdDraw.setPenColor(StdDraw.RED);
                    if (parent.p.y() < child.p.y()) {
                        StdDraw.line(child.p.x(), parent.p.y(), child.p.x(), 1);
                        if (debug) {
                            System.out.println("\tRed Vertical line: " + new Point2D(child.p.x(), parent.p.y()) + " to " + new Point2D(child.p.x(), 1));
                        }
                    } else if (parent.p.y() >= child.p.y()) {
                        StdDraw.line(child.p.x(), 0, child.p.x(), parent.p.y());
                        if (debug) {
                            System.out.println("\tRed Vertical line: " + new Point2D(child.p.x(), 0) + " to " + new Point2D(child.p.x(), parent.p.y()));
                        }
                    }
                }
            }
            draw(child, child.lb);
            draw(child, child.rt);
        }
    }

//    /**
//     * draw all of the points to standard draw
//     */
//    public void draw() {
//        for (Point2D point : levelOrder()) {
//            StdDraw.point(point.x(), point.y());
//        }
//    }
//
//    private List<Point2D> levelOrder() {
//        List<Point2D> points = new ArrayList<>();
//        levelOrder(points, root);
//        return points;
//    }
//
//    private void levelOrder(List<Point2D> points, Node x) {
//        if (x != null) {
//            points.add(x.p);
//            levelOrder(points, x.lb);
//            levelOrder(points, x.rt);
//        }
//
//    }

    /**
     * all points in the set that are inside the rectangle
     *
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        Set<Point2D> points = new TreeSet<>();
        range(points, root, rect);
        return points;
    }

    private void range(Set<Point2D> points, Node x, RectHV rect) {
        if (x == null) {
            return;
        }
        if (x.rect.intersects(rect)) {
            if (rect.contains(x.p)) {
                points.add(x.p);
            }
            range(points, x.lb, rect);
            range(points, x.rt, rect);
        }
    }

    /**
     * a nearest neighbor in the set to p; null if set is empty
     *
     * @param p
     * @return
     */
    public Point2D nearest(Point2D p) {
        Set<Point2D> visitedPoints = null;
        if (debug) {
            visitedPoints = new TreeSet<>();
        }
        final Node nearest = nearest(root, p, root, Double.MAX_VALUE, visitedPoints);
        final Point2D nearestPoint = (nearest != null) ? nearest.p : null;
        if (debug) {
            System.out.println("Visited Size: " + visitedPoints.size() + " " + visitedPoints);
        }
        return nearestPoint;
    }

    private Node nearest(Node x, Point2D p,
                         Node nearestNode, double nearestDistance, Set<Point2D> visitedPoints) {
        if (x == null) {
            return nearestNode;
        }
        if (x.p.equals(p)) {
            return x;
        }
        if (!x.rect.contains(p)) {
            return nearestNode;
        }
        if (debug && (visitedPoints != null)) {
            visitedPoints.add(x.p);
        }

        boolean updatedNearest = false;
        final double distanceTo = p.distanceSquaredTo(x.p);
        if (distanceTo < nearestDistance) {
            nearestNode = x;
            nearestDistance = distanceTo;
            updatedNearest = true;
        }

        final int compareTo = compareTo(x, p);
        if (compareTo < 0) {
            nearestNode = nearest(x.lb, p, nearestNode, nearestDistance, visitedPoints);
            if (!updatedNearest) {
                nearestNode = nearest(x.rt, p, nearestNode, nearestDistance, visitedPoints);
            }
        } else if (compareTo > 0) {
            nearestNode = nearest(x.rt, p, nearestNode, nearestDistance, visitedPoints);
            if (!updatedNearest) {
                nearestNode = nearest(x.lb, p, nearestNode, nearestDistance, visitedPoints);
            }
        } else {
            nearestNode = x;
//            nearestDistance = 0;
        }

        return nearestNode;
    }

//    public void setDebug(boolean debugFlag) {
//        this.debug = debugFlag;
//    }
}
