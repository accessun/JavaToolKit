package io.github.accessun.regex;

import org.junit.Test;

public class RegexTest {
    
    @Test
    public void removePartOfString() {
        final String APPENDED_STR = "_croppedVersion";
        String originalName = "185das1d685r1e" + APPENDED_STR + ".png";
        String processedName = originalName.replaceAll(APPENDED_STR, "");
        System.out.println(originalName);
        System.out.println(processedName);
    }

}
