package com.teamdev.brainfuck;

import com.teamdev.brainfuck.Command.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JavaScriptCompiler {

    public static final String PROGRAM = "++++++++[>++++[>++>+++>+++>+<<<<-]" +
            ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------" +
            ".>>+.>++.";

    public void compile(String brainfuckProgram, File outputJavaScriptFile) {

        final List<Command> commands = new Parser().parse(brainfuckProgram);

        final OptimizationVisitor optimizationVisitor = new OptimizationVisitor();

        for (Command command : commands) {
            command.accept(optimizationVisitor);
        }

        final List<Command> optimizedCommands =
                optimizationVisitor.getOptimizedCommands();

        // console out!
//        final ExecutionVisitor executionVisitor = new ExecutionVisitor();
//        for (Command command : optimizedCommands) {
//            command.accept(executionVisitor);
//        }

        // todo: generate JavaScript code (implement JavaScript code generation visitor)
        final JavaScriptVisitor javaScriptVisitor = new JavaScriptVisitor();
        for (Command command: optimizedCommands) {
            command.accept(javaScriptVisitor);
        }

        String javaScriptCode = javaScriptVisitor.getPhrases().toString();

//        System.out.println(javaScriptCode);

        try (FileWriter javaScriptFile = new FileWriter(outputJavaScriptFile)) {
            javaScriptFile.write(javaScriptCode);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("javaScript code wasn't written in file " + outputJavaScriptFile.toString());
        }
    }


    public static void main(String[] args) {

        final JavaScriptCompiler compiler = new JavaScriptCompiler();
        compiler.compile(PROGRAM, new File("./brainfuck.js"));

        final HtmlFile htmlFile = new HtmlFile();
        String htmlTemplate = htmlFile.createHtmlFile();

        try (FileWriter fileWriter = new FileWriter(new File("compiler.html"))) {
            fileWriter.write(htmlTemplate);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
