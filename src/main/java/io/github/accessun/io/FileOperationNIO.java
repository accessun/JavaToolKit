package io.github.accessun.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
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

    @Override
    public void deleteAll(String rootDir) throws IOException {
        Path path = Paths.get(rootDir);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
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

    @Test
    public void testDeleteAll() throws IOException {
        String rootDir = "C:/Users/User/Desktop/deleteTest";
        deleteAll(rootDir);
    }

}
