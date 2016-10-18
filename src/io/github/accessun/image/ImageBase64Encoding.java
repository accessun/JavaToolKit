package io.github.accessun.image;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class ImageBase64Encoding {
    
    public static String encode(String imagePath) throws IOException {
        String base64Image = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(imagePath)));
        final String prependStr = "data:image/png;base64, ";
        return prependStr + base64Image;
    }
}
