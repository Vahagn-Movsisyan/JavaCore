package homeworks.hm1FigurePainter;

import java.util.Scanner;

public class FigurePainter {
    public static String symbol;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write what symbol you would like to see");
        symbol = scanner.nextLine();
        System.out.println("""
                For watch first figure  enter - '1',  For watch second figure  enter - '2'
                For watch third figure  enter - '3',  For watch fourth figure  enter - '4'
                                    For watch fifth figure  enter - '5'
                """);
        int enterFigure = scanner.nextInt();

        switch (enterFigure){
            case 1 -> figure1();
            case 2 -> figure2();
            case 3 -> figure3();
            case 4 -> figure4();
            case 5 -> figure5();
            default -> System.out.println("You are entered an error");
        }
    }
    static void figure1(){
        //Figure triangle 1
        System.out.println("Figure - 1");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
    static void figure2(){
        //Figure revers triangle 2
        System.out.println("Figure - 2\n");
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    static void figure3(){
        //Figure triangle 3
        System.out.println("Figure 3\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    static void figure4(){
        //Figure triangle 4
        System.out.println("Figure 4");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print(" ");
            }
            for (int k = 4; k >= i ; k--) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    static void figure5(){

        //Figure triangle and revers triangle 5
        System.out.println("Figure - 5");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i ; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(" " + symbol);
            }
            System.out.println();
        }
        for (int i = 5; i >= 2; i--) {
            for (int j = 5; j >= i ; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i - 2 ; k++) {
                System.out.print(" " + symbol);
            }
            System.out.println();
        }
    }
}
