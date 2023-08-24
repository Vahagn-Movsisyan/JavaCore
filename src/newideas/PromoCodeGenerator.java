package newideas;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class PromoCodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 12;
    private static final int NUM_CODES = 100000;

    public static void main(String[] args) {
        Set<String> promoCodes = generatePromoCodes(NUM_CODES);
        for (String promoCode : promoCodes) {
            System.out.println(promoCode);
        }
    }

    public static Set<String> generatePromoCodes(int numCodes) {
        Set<String> promoCodes = new HashSet<>();
        SecureRandom random = new SecureRandom();

        while (promoCodes.size() < numCodes) {
            StringBuilder codeBuilder = new StringBuilder();
            for (int i = 0; i < CODE_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(randomIndex);
                codeBuilder.append(randomChar);
            }
            promoCodes.add(codeBuilder.toString());
        }

        return promoCodes;
    }
}
