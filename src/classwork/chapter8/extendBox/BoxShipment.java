package classwork.chapter8.extendBox;

public class BoxShipment extends BoxWeight {
    double cost;

    BoxShipment(BoxShipment ob) {
        super(ob);
        cost= ob.cost;
    }

    BoxShipment(double width, double height, double depth, double weight, double cost) {
        super(width, height, depth, weight);
        this.cost = cost;
    }

    BoxShipment() {
        super();
        cost = -1;
    }

    BoxShipment(double len, double cost) {
        super(len, cost);
        this.cost = cost;
    }
}
