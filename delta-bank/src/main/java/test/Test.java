package test;

public class Test {
    public static void main(String[] args) {
        PointFactory pf = new PointFactory();
        PointPrint pp = new PointPrint();
        PointService ps = new PointService(pf,pp);

        ps.createPoint(10, 10);
    }
}
