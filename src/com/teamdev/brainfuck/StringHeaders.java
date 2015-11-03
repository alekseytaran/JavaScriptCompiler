package com.teamdev.brainfuck;

public class StringHeaders {

    public String createHtmlFile() {
        String htmlTemplate =
                "<head></head>\n" +
                        "<body>\n" +
                        "<script src = \"brainfuck.js\">" + "</script>\n" +
                        "</body>\n";
        return htmlTemplate;
    }

    public String createJSHeader() {
        String JSHeader= "\"use strict\"\n" +
                "var memory = [];\n" +
                "var pointer = 0;\n" +
                "var letter = '';\n" +
                "for(var i = 0; i < 30000; i++) { memory[i] = 0; }\n\n";
        return JSHeader;
    }
}
