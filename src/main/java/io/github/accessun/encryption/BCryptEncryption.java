package io.github.accessun.encryption;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Plain text encryption using BCrypt algorithm brought by Spring framework.
 */
public class BCryptEncryption {

    /**
     * Encrypt plain text. This method utilizes salt to enhance encryption strength.
     *
     * @param plainText
     * @return
     */
    public String encrypt(String plainText) {
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(plainText, salt);
    }

    /**
     * Check plain text against encrypted hash (usually stored in database).
     *
     * @param plaintext
     * @param storedHash
     * @return
     */
    public boolean checkMatch(String plaintext, String storedHash) {
        return BCrypt.checkpw(plaintext, storedHash);
    }

    @Test
    public void testBCryptPasswordEncryption() {
        String plaintext = UUID.randomUUID().toString();
        String encPassword = encrypt(plaintext);

        Assert.assertTrue(checkMatch(plaintext, encPassword));

        // this is false due to addition of salt during encryption
        Assert.assertFalse(encPassword.equals(encrypt(plaintext)));
    }
}
