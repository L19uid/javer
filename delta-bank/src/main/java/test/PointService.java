package test;

import java.util.ArrayList;
import java.util.List;

public class PointService {
    private List<Point> points;

    private PointFactory pointFactory;

    private PointPrint pointPrint;

    public PointService(PointFactory pointFactory, PointPrint pointPrint) {
        this.points = new ArrayList<Point>();
        this.pointFactory = pointFactory;
        this.pointPrint = pointPrint;
    }

    public Point createPoint(int x, int y) {
        Point p = pointFactory.createPoint(x, y);
        points.add(p);

        return p;
    }
}
