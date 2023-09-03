package classwork.chapter5;

import java.io.IOException;

public class IfForDoWhileSwitch {
    public static void main(String[] args) throws IOException {
        char select;

        do {
            System.out.println("""
                    For watch a top 5 capital cities, select '1':
                    For watch a top 5 football clubs, select '2':
                    For watch a top 5 car marks, select '3':
                    For watch a top 5 programming languages, select '4':
                    For watch a top 5 films, select '5':
                    To quit, select 'q':
                    """);
            select = (char) System.in.read();
            while (System.in.read() != '\n');
        } while (select < '1' || select > '5');

        System.out.println();

        switch (select) {
            case '1' -> {
                System.out.println("""
                        Top 5 Capital Cities:
                        1. London, United Kingdom
                        2. Paris, France
                        3. Tokyo, Japan
                        4. Beijing, China
                        5. New Delhi, India
                        """);
                break;
            }
            case '2' -> {
                System.out.println("""
                        Top 5 Football Clubs:
                        1. FC Barcelona (Spain)
                        2. Real Madrid CF (Spain)
                        3. Manchester United FC (United Kingdom)
                        4. Bayern Munich (Germany)
                        5. AC Milan (Italy)
                        """);
                break;
            }
            case '3' -> {
                System.out.println("""
                        Top 5 Car Manufacturers:
                        1. Toyota
                        2. Volkswagen Group
                        3. Ford
                        4. Honda
                        5. General Motors (Chevrolet, GMC, Cadillac, etc.)
                        """);
                break;
            }
            case '4' -> {
                System.out.println("""
                        Top 5 Programming Languages:
                        1. JavaScript
                        2. Python
                        3. Java
                        4. C++
                        5. Ruby
                        """);
                break;
            }
            case '5' -> {
                System.out.println("""
                        Top 5 Films:
                        1. Avatar (2009)
                        2. Avengers: Endgame (2019)
                        3. Titanic (1997)
                        4. Star Wars: The Force Awakens (2015)
                        5. Jurassic World (2015)
                        """);
                break;
            }
            default -> System.out.println("Invalid selection. Please select a number between 1 and 5 or 'q' to quit.");
        }
    }
}
