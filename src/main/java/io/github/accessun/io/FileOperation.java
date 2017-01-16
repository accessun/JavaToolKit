package io.github.accessun.io;

import java.io.IOException;

public interface FileOperation {
    
    static final String LINE_BREAK = "\n";
    
    public String readFileToString(String filepath) throws IOException;
    
    public void copyFile(String src, String dest) throws IOException;
    
}
