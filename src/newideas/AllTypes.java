package newideas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllTypes {
    public static void main(String[] args) {
        System.out.println("Welcome to Types. " +
                "Now use demo tools to test all types, enter 'all'");
            changeTypes();
    }

    static void changeTypes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many you want to change int numbers, or '0' to access other tools:");
        int changeCount = scanner.nextInt();

        if (changeCount == 0) {
            allTools();
            return;
        }

        int i;
        int enterNum = 0;
        List<Integer> changedNumbers = new ArrayList<>();

        for (i = 0; i < changeCount; i++) {
            System.out.println((i + 1) + " Enter an int number for conversion");
            enterNum = scanner.nextInt();

            scanner.nextLine();

            System.out.println("""
                    For double enter - d
                    For byte enter - b
                    For long enter - l
                    """);

            String selectType = scanner.nextLine();

            switch (selectType) {
                case "d" -> {
                    System.out.println((double) enterNum);
                    changedNumbers.add(enterNum);
                }
                case "b" -> {
                    System.out.println((byte) enterNum);
                    changedNumbers.add(enterNum);
                }
                case "l" -> {
                    System.out.println((long) enterNum);
                    changedNumbers.add(enterNum);
                }
                default -> System.out.println("You have entered an error");
            }
        }
        System.out.println("Changing successfully finished your numbers:");
        for (int cleanNumber : changedNumbers) {
            System.out.println("The numbers - " + cleanNumber + " ");
        }
    }

    static void useAllTools() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is a premium edition, so you can use all types. Enter the how many numbers you want to change:");
        int countPremiumChange = scanner.nextInt();
        scanner.nextLine();

        List<Double> changedPremiumNumbers = new ArrayList<>();

        for (int i = 0; i < countPremiumChange; i++) {
            System.out.println("Enter the " + (i + 1) + " number to change:");
            double enterPremiumType = Double.parseDouble(scanner.nextLine());

            System.out.println("""
                    For int enter - i
                    For double enter - d
                    For byte enter - b
                    For long enter - l
                    """);

            String changePremiumType = scanner.nextLine();

            switch (changePremiumType) {
                case "i":
                    int intValue = (int) enterPremiumType;
                    System.out.println(intValue);
                    changedPremiumNumbers.add((double) intValue);
                    break;
                case "b":
                    byte byteValue = (byte) enterPremiumType;
                    System.out.println(byteValue);
                    changedPremiumNumbers.add((double) byteValue);
                    break;
                case "l":
                    long longValue = (long) enterPremiumType;
                    System.out.println(longValue);
                    changedPremiumNumbers.add((double) longValue);
                    break;
                case "d":
                    System.out.println(enterPremiumType);
                    changedPremiumNumbers.add(enterPremiumType);
                    break;
                default:
                    System.out.println("You entered an invalid choice");
                    changedPremiumNumbers.add(enterPremiumType);
                    break;
            }
        }

        System.out.println("Successfully finished changing your numbers:");
        for (double cleanPremiumNumber : changedPremiumNumbers) {
            System.out.println("The numbers - " + cleanPremiumNumber);
        }
    }

    static void allTools() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To access all tools, you must buy a subscription - enter 'watch'. To enter promo-codes, enter 'promo'");
        String allToolsWatch = scanner.nextLine();

        switch (allToolsWatch) {
            case "watch":
                System.out.println("""
                        1 month - 45$
                        3 months - 75$
                        12 months - 350$
                        """);
                break;

            case "promo":
                System.out.println("Enter the promo-code to get a subscription");
                String promoCode = scanner.nextLine();
                String[] validPromoCodes = {
                        "PMRJ9F8X5L2K",
                        "G7D2C6H1W9P3",
                        "V5T6Y2Q8E1A4",
                        "N0Z3B8M7K6D",
                        "L1R4W9J2X7S",
                        "U6F2C7P5H8M",
                        "E3Q8V9T4Y0N",
                        "I2O5A1B4Z6E",
                        "T9G6H3D7N1F"
                };

                boolean isValidPromoCode = false;

                if (promoCode.length() != 12) {
                    System.out.println("Invalid promo-code length. Access denied.");
                    allTools();
                }

                for (String code : validPromoCodes) {
                    if (code.equals(promoCode)) {
                        isValidPromoCode = true;
                        break;
                    }
                }

                if (isValidPromoCode) {
                    int months = 0;

                    if (promoCode.equals("PMRJ9F8X5L2K") || promoCode.equals("G7D2C6H1W9P3") ||
                            promoCode.equals("V5T6Y2Q8E1A4") || promoCode.equals("N0Z3B8M7K6D")) {
                        months = 12;
                    } else if (promoCode.equals("L1R4W9J2X7S") || promoCode.equals("U6F2C7P5H8M") ||
                            promoCode.equals("E3Q8V9T4Y0N")) {
                        months = 3;
                    } else if (promoCode.equals("I2O5A1B4Z6E") || promoCode.equals("T9G6H3D7N1F")) {
                        months = 1;
                    }

                    System.out.println("Promo-code is valid. You now have access to all tools for " + months + " months!");
                    useAllTools();
                } else {
                    System.out.println("Invalid promo-code. Access denied.");
                }
                break;
            default:
                System.out.println("Invalid input. Access denied.");
        }
    }
}
