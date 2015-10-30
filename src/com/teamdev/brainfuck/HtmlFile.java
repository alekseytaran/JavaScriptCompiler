package com.teamdev.brainfuck;

public class HtmlFile {

    public String createHtmlFile() {
        String htmlTemplate =
                "<head></head>\n" +
                        "<body>\n" +
                        "<script src = \"brainfuck.js\">" + "</script>\n" +
                        "</body>\n";
        return htmlTemplate;
    }
}
