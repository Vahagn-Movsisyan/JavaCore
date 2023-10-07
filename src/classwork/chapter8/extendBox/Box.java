package classwork.chapter8.extendBox;


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

    Box(double width, double height, double depth, double len) {
        this.width = this.height = this.depth = len;
    }

    Box(double len) {
        this.width = len;
        this.height = len;
        this.depth = len;
    }

    double volume() {
        return width * height * depth;
    }
}
