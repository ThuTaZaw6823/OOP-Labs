package lab4.q4;

public class TriangleManagerTest {

    public static void main(String[] args) {

        TriangleManager manager = new TriangleManager(true);

        Triangle t1 = new EquilateralTriangle(5.0);
        Triangle t2 = new RightTriangle(3.0, 4.0, 5.0);
        Triangle t3 = new EquilateralTriangle(10.0);

        manager.addTriangle(t1);
        manager.addTriangle(t2);
        manager.addTriangle(t3);

        Triangle largest = manager.findTriangleWithLargestPerimeter();

        System.out.println("Largest perimeter: " + largest.getPerimeter());
        System.out.println("Longest side: " + largest.getLongestSideLength());
        System.out.println("Largest angle: " + largest.getLargestAngle());

        try {
            manager.addTriangle(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}