package io.github.accessun.encryption;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptEncryption {

    public static String encrypt(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(10)); // default param is 10
    }

    public static boolean checkMatch(String plaintext, String storedHash) {
        boolean isMatch = false;
        if (BCrypt.checkpw(plaintext, storedHash))
            isMatch = true;
        return isMatch;
    }

}
