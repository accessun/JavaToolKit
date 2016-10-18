package io.github.accessun.string;

import org.junit.Test;

public class AllSamplesToJsonArrayUtil {

    public StringBuilder fileToJsonDocument() {
        StringBuilder result = new StringBuilder();
        
        return result;
    }
    
    public void combineJsonDocumentsToJsonArray() {
    }
    
    @Test
    public void testInsert() {
        StringBuilder stringBuilder = new StringBuilder(" { \"A\": \"a\", \"B\": \"b\" },");
        System.out.println(stringBuilder.toString());
        int point = stringBuilder.indexOf("}");
        stringBuilder.insert(point, ", \"sample_id\":\"S00001\"");
        System.out.println(stringBuilder.toString());
    }
}
