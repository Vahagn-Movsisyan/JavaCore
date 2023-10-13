package classwork.chapter8.extendFigures;

public abstract class Figure {
    double dim1;
    double dim2;

    Figure (double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    abstract double area();
}
