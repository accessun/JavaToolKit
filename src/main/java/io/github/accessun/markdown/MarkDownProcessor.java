package io.github.accessun.markdown;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkDownProcessor {

    public void convert(String markdownFile, String htmlFile) throws IOException {
        String markdownStr = Files.readAllLines(Paths.get(markdownFile), StandardCharsets.UTF_8).stream()
                .collect(Collectors.joining("\n"));
        String htmlContent = getPrependedHtml() + markdownToHtml(markdownStr) + getAppendedHtml();
        Files.write(Paths.get(htmlFile), htmlContent.getBytes(StandardCharsets.UTF_8),
                new OpenOption[] { StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING });
    }

    private String markdownToHtml(String md) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(md);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    private String getPrependedHtml() {
        return "<!DOCTYPE html><html><head>" + "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">"
                + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">"
                + "<title>Document</title></head>\n<body>\n";
    }

    private String getAppendedHtml() {
        return "</body>\n</html>";
    }

    public static void main(String[] args) throws IOException {
        MarkDownProcessor processor = new MarkDownProcessor();
        String fromFile = "C:/Users/User/Desktop/test.md";
        String toFile = "C:/Users/User/Desktop/test_md.html";
        processor.convert(fromFile, toFile);
    }

}
