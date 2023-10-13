package classwork.chapter8.extendFigures;

public class Triangle extends Figure{
    Triangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("Triangle area is equals");
        return dim1 * dim2 / 2;
    }
}
