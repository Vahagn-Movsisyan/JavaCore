package classwork.chapter8.extendBox;

public class BoxWeightDemo {
    public static void main(String[] args) {

        BoxWeight myBox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight myBox2 = new BoxWeight(2, 3, 4, 0.076);
        Box box = new Box();
        double vol1, vol2, vol3, vol4, vol5;


        vol1 = myBox1.volume();
        vol2 = myBox2.volume();


        System.out.println("My box1 volume is equals " + vol1);
        System.out.println("My box1 weight is equals " + myBox1.weight);
        System.out.println();

        System.out.println("My box2 volume is equals " + vol2);
        System.out.println("My box1 weight is equals " + myBox2.weight);
        System.out.println();

        box = myBox1;

        vol3 = box.volume();
        System.out.println("Box volume is equals " + vol3);


        Box box1 = new BoxWeight(4, 5, 6, 12);
        vol4 = box1.volume();
        System.out.println("Box 1 volume is equals " + vol4);
        System.out.println();

        BoxShipment boxShipment = new BoxShipment(12, 11, 13, 15, 25);
        vol5 = boxShipment.volume();

        System.out.println("Box shipment volume is equals " + vol5);
        System.out.println("Box shipment weight " + boxShipment.weight);
        System.out.println("Box shipment is cos " + boxShipment.cost);
    }
}


