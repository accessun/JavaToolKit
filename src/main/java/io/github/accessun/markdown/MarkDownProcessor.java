package io.github.accessun.markdown;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkDownProcessor {

    // convert markdown string to html string
    public String mdToHtml(String md) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(md);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
    
    // convert markdown file to html file
    public void convert(String mdFile, String htmlFile) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(mdFile));
        String md = new String(encoded, Charset.forName("UTF-8"));
        String html = getPrependedHtml() + mdToHtml(md) + getAppendedHtml();
        Files.write(Paths.get(htmlFile), html.getBytes());
    }
    
    public static void main(String[] args) throws IOException {
        MarkDownProcessor processor = new MarkDownProcessor();
        String fromFile = "C:/Users/User/Desktop/bigDataDev.md";
        String toFile = "C:/Users/User/Desktop/bigDataDev.html";
        processor.convert(fromFile, toFile);
    }
    
    private String getPrependedHtml() {
        return "<!DOCTYPE html><html><head>"
                + "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">"
                + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">"
                + "<title>Document</title></head>\n<body>\n";
    }
    
    private String getAppendedHtml() {
        return "</body>\n</html>";
    }
    
}
