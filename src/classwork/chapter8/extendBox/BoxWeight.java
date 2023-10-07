package classwork.chapter8.extendBox;

public class BoxWeight extends Box {

    double weight;


    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth, weight);
        this.weight = weight;
    }

    BoxWeight() {
        super();
        weight = -1;
    }

    BoxWeight(double len, double weight) {
        super(len);
        this.weight = weight;
    }

}
