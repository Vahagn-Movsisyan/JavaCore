package classwork.chapter7.box;

public class Box {
    double width;
    double height;
    double depth;

    Box(Box ob){
       width = ob.width;
       height = ob.height;
       depth = ob.depth;
    }

    Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    Box(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width * height * depth;
    }
}
