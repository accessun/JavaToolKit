package io.github.accessun.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class ApacheIOUitlsTest {

    @Test
    public void test() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("C:/Users/User/Desktop/file-1471587918832.txt"));
        
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "utf-8");
        String result = writer.toString();
        System.out.println(result);
    }
}
