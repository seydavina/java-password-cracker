import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.List;

public class DictionaryLocalCracker extends CryptoUtils implements PasswordCracker {
    private List<String> dictionary;

    public DictionaryLocalCracker(List<String> dictionary) {
        this.dictionary = dictionary;
    }

    public void crackPassword(String hashedPassword) {
        dictionaryAttack(hashedPassword);
    }

    public List<String> getDictionary() {
        return dictionary;
    }

    private void dictionaryAttack(String hashedPassword) {
        if (dictionary == null) {
            System.out.println("Default dictionary is not set.");
            return;
        }

        dictionaryAttack(hashedPassword, dictionary);
    }


    public void dictionaryAttack(String hashedPassword, List<String> customDictionary) {
        System.out.println("Cracking password using dictionary...");

       // Précalculez les hachages du dictionnaire
       HashSet<String> hashedDictionary = new HashSet<>();
       for (String word : customDictionary) {
           hashedDictionary.add(md5(word));
       }
       
       // Recherche dans le dictionnaire
       for (String hashedWord : hashedDictionary) {
           if (hashedWord.equals(hashedPassword)) {
               System.out.println("Password cracked using dictionary.");
               return;
           }
       }
       
       System.out.println("Password not found in dictionary.");
   }
}