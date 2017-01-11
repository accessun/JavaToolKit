package io.github.accessun.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class FileOperation {

    public String readTextFileToString(String filePath) {
        FileInputStream inputStream = null;
        StringWriter writer = null;
        try {
            inputStream = new FileInputStream(filePath);
            writer = new StringWriter();
            IOUtils.copy(inputStream, writer, "utf-8");
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void copyFile(String src, String dest) {
        // note that to copy files larger than 2GB, use copyLarge instead
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            IOUtils.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testReadTextFileToString() {
        String filePath = "C:/Users/User/Desktop/proc.sql";
        System.out.println(readTextFileToString(filePath));
    }

    @Test
    public void testCopyFile() {
        String src = "C:/Users/User/Desktop/proc.sql";
        String dest = "C:/Users/User/Desktop/proc1.sql";
        copyFile(src, dest);
    }
}
