package io.github.accessun.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import org.junit.Test;

public class FileOperationIO implements FileOperation {

    @Override
    public String readFileToString(String filepath) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (Reader r = new FileReader(new File(filepath)); BufferedReader reader = new BufferedReader(r)) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(LINE_BREAK);
            }
        }

        return builder.toString();
    }

    @Override
    public void copyFile(String src, String dest) throws IOException {
        try (InputStream is = new FileInputStream(new File(src));
                OutputStream os = new FileOutputStream(new File(dest))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        }
    }

    @Test
    public void testReadTextFileToString() throws IOException {
        String filePath = "C:/Users/User/Desktop/read.txt";
        System.out.println(readFileToString(filePath));
    }

    @Test
    public void testCopyFile() throws IOException {
        String src = "C:/Users/User/Desktop/read.txt";
        String dest = "C:/Users/User/Desktop/read2.txt";
        copyFile(src, dest);
    }

    @Override
    public void deleteAll(String rootDir) throws IOException {
        // TODO Auto-generated method stub
        
    }
    
}
