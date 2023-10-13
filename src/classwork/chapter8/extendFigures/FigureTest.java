package classwork.chapter8.extendFigures;

public class FigureTest {
    public static void main(String[] args) {

        Triangle triangle = new Triangle(10, 20);
        Rectangle rectangle = new Rectangle(10, 20);

        Figure figureResult;

        figureResult = triangle;
        System.out.println("Now is " + triangle.area());

        figureResult = rectangle;
        System.out.println("Now is " + rectangle.area());

    }
}
