package io.github.accessun.image;

import org.junit.Test;

public class VerificationCodeGeneratorTest {

    @Test
    public void testGenCode() {
        String outputPath = "C:/Users/User/Desktop/code.jpeg";
        new VerificationCodeGenerator().genCode(outputPath);
    }

}
