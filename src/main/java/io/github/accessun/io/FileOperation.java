package io.github.accessun.io;

import java.io.IOException;

public interface FileOperation {
    
    static final String LINE_BREAK = "\n";
    
    String readFileToString(String filepath) throws IOException;
    
    void copyFile(String src, String dest) throws IOException;
    
    void deleteAll(String rootDir) throws IOException;
    
}
