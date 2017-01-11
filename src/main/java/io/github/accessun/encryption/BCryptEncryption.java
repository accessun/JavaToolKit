package io.github.accessun.encryption;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptEncryption {

    public String encrypt(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(10)); // default param is 10
    }

    public boolean checkMatch(String plaintext, String storedHash) {
        boolean isMatch = false;
        if (BCrypt.checkpw(plaintext, storedHash))
            isMatch = true;
        return isMatch;
    }

    @Test
    public void testBCryptPasswordEncryption() {
        String plaintext = UUID.randomUUID().toString();
        String encPassword = encrypt(plaintext);

        Assert.assertTrue(checkMatch(plaintext, encPassword));
        Assert.assertFalse(encPassword.equals(encrypt(plaintext)));
    }
}
