public class BruteforceLocalCracker extends CryptoUtils implements PasswordCracker {
    
    public void crackPassword(String hashedPassword) {
        bruteForceCrack(hashedPassword);
    }

    public static void bruteForceCrack(String hashedPassword) {
        System.out.println("Cracking password by brute force...");
        // Longueur maximale du mot de passe à générer pour le craquage par force brute
        int maxLength = 5;

        for (int length = 1; length <= maxLength; length++) {
            bruteForceHelper(hashedPassword, "", length);
        }
    }

    private static void bruteForceHelper(String hashedPassword, String attempt, int length) {
        // Caractères possibles pour le craquage par force brute
        char[] charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        if (length == 0) {
            // Calculer le hash MD5 de la tentative
            String hashedAttempt = md5(attempt);
            if (hashedAttempt.equals(hashedPassword)) {
                System.out.println("Password cracked by brute force: " + attempt);
                return;
            }
        } else {
            for (char c : charset) {
                bruteForceHelper(hashedPassword, attempt + c, length - 1);
            }
        }
    }
}