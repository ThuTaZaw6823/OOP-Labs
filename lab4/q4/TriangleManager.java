package lab4.q4;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TriangleManager {

    private List<Triangle> triangles;

    public TriangleManager(boolean useArrayList) {

        if (useArrayList) {
            triangles = new ArrayList<>();
        } else {
            triangles = new LinkedList<>();
        }
    }

    public void addTriangle(Triangle t) {

        if (t == null) {
            throw new IllegalArgumentException("Triangle cannot be null");
        }

        triangles.add(t);
    }

    public Triangle findTriangleWithLargestPerimeter() {

        if (triangles.isEmpty()) {
            return null;
        }

        Triangle largest = triangles.get(0);

        for (Triangle t : triangles) {
            if (t.getPerimeter() > largest.getPerimeter()) {
                largest = t;
            }
        }

        return largest;
    }
}
