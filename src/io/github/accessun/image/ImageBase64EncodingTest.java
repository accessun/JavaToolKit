package io.github.accessun.image;

import java.io.IOException;

import org.junit.Test;

public class ImageBase64EncodingTest {
    
    @Test
    public void testImageEncoding() throws IOException {
        String imagePath = "C:/Users/User/Desktop/mytmp.PNG";
        String encodedStr = ImageBase64Encoding.encode(imagePath);
        System.out.println(encodedStr);
    }
}
