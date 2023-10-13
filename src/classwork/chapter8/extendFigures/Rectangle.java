package classwork.chapter8.extendFigures;

public class Rectangle extends Figure {
    Rectangle (double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("Rectangle are is equals");
        return dim1 * dim2;
    }
}
