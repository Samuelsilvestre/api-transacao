package transaction.api.api_transaction.service;

import org.jasypt.util.text.StrongTextEncryptor;


public class EncryptorService {

    private static final StrongTextEncryptor encryptor;

    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword(System.getenv("password"));
    }

    public static String encrypt(String rawText) {
        return encryptor.encrypt(rawText);
    }

    public static String decrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }

}    