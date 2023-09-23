package classwork.chapter7.box;

public class BoxTest {
    public static void main(String[] args) {
        Box boxWidthHeightDept = new Box(5, 12, 9); // width = 5; height = 12; depth = 9;
        Box boxCube = new Box(7); // width = 7; height = 7; depth = 7;
        Box boxClone = new Box(boxWidthHeightDept); // width = 5; height = 12; depth = 9;
        Box boxEmpty = new Box(); // width = -1; height = -1; depth = -1;

        System.out.println("Printing volume boxWidthHeightDept - " + boxWidthHeightDept.volume());
        System.out.println("Printing volume boxCube - " + boxCube.volume());
        System.out.println("Printing volume boxClone - " + boxClone.volume());
        System.out.println("Printing volume - " + boxEmpty.volume());

    }
}
