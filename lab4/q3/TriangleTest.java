package lab4.q3;

public class TriangleTest {

    public static void main(String[] args) {

        Triangle t1 = new EquilateralTriangle(5.0);

        System.out.println(t1.getLongestSideLength());
        System.out.println(t1.getPerimeter());
        System.out.println(t1.getLargestAngle());

        Triangle t2 = new RightTriangle(3.0, 4.0, 5.0);

        System.out.println(t2.getLongestSideLength());
        System.out.println(t2.getPerimeter());
        System.out.println(t2.getLargestAngle());
    }
}
