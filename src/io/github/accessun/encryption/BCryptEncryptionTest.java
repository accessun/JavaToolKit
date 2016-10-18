package io.github.accessun.encryption;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class BCryptEncryptionTest {
    @Test
    public void testBCryptPasswordEncryption() {

        String plaintext = UUID.randomUUID().toString();
        String encPassword = BCryptEncryption.encrypt(plaintext);

        Assert.assertTrue(BCryptEncryption.checkMatch(plaintext, encPassword));
        Assert.assertFalse(encPassword.equals(BCryptEncryption.encrypt(plaintext)));

    }
}
