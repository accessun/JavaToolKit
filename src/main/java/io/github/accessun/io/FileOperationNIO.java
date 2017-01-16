package io.github.accessun.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

import org.junit.Test;

public class FileOperationNIO implements FileOperation {

    @Override
    public String readFileToString(String filepath) throws IOException {
        return Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8).stream()
                .collect(Collectors.joining(LINE_BREAK));
    }

    @Override
    public void copyFile(String src, String dest) throws IOException {
        Files.copy(Paths.get(src), Paths.get(dest), new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
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

}
