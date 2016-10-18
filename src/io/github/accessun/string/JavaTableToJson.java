package io.github.accessun.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class JavaTableToJson {
    
    public void tableTxtToJson(File fromFile, File toFile, String sampleId) throws IOException {
        InputStream in = new FileInputStream(fromFile);
        InputStreamReader inReader = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inReader);
        FileWriter writer = new FileWriter(toFile);
        
        String[] firstLineTitles = reader.readLine().split("\\t+");
        int column = firstLineTitles.length;
        
        String line;
        String line2;
        String[] tempLineContents;
        StringBuilder tempLine;
        
        line = reader.readLine();
        line2 = reader.readLine();
        writer.write("{\n");
        writer.write("\"sample_id\": " + "\"" + sampleId + "\",\n");
        writer.write("\"data\": \n");
        writer.write("[\n");
        
        while (true) {
            tempLine = new StringBuilder();
            tempLineContents = line.split("\\t+");
            tempLine.append("  { ");
            
            for (int i = 0; i < column - 1; i++) {
                tempLine.append("\"").append(firstLineTitles[i]).append("\": ")
                .append("\"").append(tempLineContents[i]).append("\", ");
            }
            
            tempLine.append("\"").append(firstLineTitles[column - 1]).append("\": ")
            .append("\"").append(tempLineContents[column - 1]).append("\" }");
            
            if (line2 != null) {
                tempLine.append(",\n");
                line = line2;
                line2 = reader.readLine();
                writer.write(tempLine.toString());
            } else {
                tempLine.append("\n]\n}");
                writer.write(tempLine.toString());
                break;
            }
        }
        
        writer.close();
        reader.close();
        inReader.close();
        in.close();
    }
    
    @Test
    public void testTableTxtToJson() throws IOException {
        File fromFile = new File("C:/Users/User/Desktop/2015-S00011-SNP-Filter.vcf.avinput.anno.hg19_multianno.txt");
        File toFile = new File("C:/Users/User/Desktop/testResult.json");
        long start = System.currentTimeMillis();
        tableTxtToJson(fromFile, toFile, "S00011");
        long end = System.currentTimeMillis();
        System.out.println("Time spent: " + ((end - start) / 1000.) + " seconds");
    }
}
