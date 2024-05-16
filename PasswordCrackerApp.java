import java.util.List;

public class PasswordCrackerApp extends CryptoUtils {
    public static void main(String[] args) {
         // Exemple de mots de passe à tester
         String password1 = "insa";
         String password2 = "crack";
         String password3 = "246810";
 
         // Créer des hash MD5 de ces mots de passe
         String hash1 = md5(password1);
         String hash2 = md5(password2);
         String hash3 = md5(password3);
 
         // Afficher les hash pour vérification
         System.out.println("Hash 1: " + hash1);
         System.out.println("Hash 2: " + hash2);
         System.out.println("Hash 3: " + hash3);
 
         // Créer une instance de BruteforceLocalCracker et tester
         BruteforceLocalCracker bruteforcer = new BruteforceLocalCracker();
         System.out.println("Testing Bruteforce Cracker:");
         bruteforcer.crackPassword(hash1);  // Devrait réussir pour des mots courts avec force brute
 
         // Créer une instance de DictionaryLocalCracker avec un petit dictionnaire
         List<String> dictionary = List.of("hello", "world", "password", "123456", "admin");
         DictionaryLocalCracker dictionaryCracker = new DictionaryLocalCracker(dictionary);
         System.out.println("Testing Dictionary Cracker:");
         dictionaryCracker.crackPassword(hash2);  // Devrait réussir avec une attaque de dictionnaire
         dictionaryCracker.crackPassword(hash3);  // Devrait aussi réussir
    }
}