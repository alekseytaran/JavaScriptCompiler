package com.teamdev.brainfuck;

import com.teamdev.brainfuck.command.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JavaScriptVisitor implements CommandVisitor {

    private final StringBuilder javaScriptCode = new StringBuilder();

    private static final String POINTER = "pointer";
    private static final String MEMORY = "memory[pointer]";

    private final StringHeaders stringHeaders = new StringHeaders();

    public JavaScriptVisitor(){
        javaScriptCode.append(stringHeaders.createJSHeader());

        try (FileWriter fileWriter = new FileWriter(new File("compiler.html"))) {
            fileWriter.write(stringHeaders.createHtmlFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(MoveForwardCommand command) {
        if (command.getCounter() == 0) { return; }
        if (command.getCounter() == 1) {
            javaScriptCode.append(POINTER + "++;\n");
            return;
        }
        javaScriptCode.append(POINTER + " += " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(MoveBackwardCommand command) {
        if (command.getCounter() == 0) { return; }
        if (command.getCounter() == 1) {
            javaScriptCode.append(POINTER + "--;\n");
            return;
        }
        javaScriptCode.append(POINTER + " -= " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(IncrementCommand command) {
        if (command.getCounter() == 0) { return; }
        if (command.getCounter() == 1) {
            javaScriptCode.append(MEMORY + "++;\n");
            return;
        }
        javaScriptCode.append(MEMORY + " += " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(DecrementCommand command) {
        if (command.getCounter() == 0) { return; }
        if (command.getCounter() == 1) {
            javaScriptCode.append(MEMORY + "--;\n");
            return;
        }
        javaScriptCode.append(MEMORY + " -= " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(PrintCommand command) {
        if (command.getCounter() == 0) { return; }
        if (command.getCounter() == 1) {
            javaScriptCode.append("letter += String.fromCharCode(memory[pointer]);\n");
            return;
        }
        javaScriptCode.append("for(let i = 0; i < " + command.getCounter() + "; i++) {\n");
        javaScriptCode.append("\tletter += String.fromCharCode(memory[pointer]);\n");
        javaScriptCode.append("}\n");
    }

    @Override
    public void visit(LoopCommand command) {
        javaScriptCode.append("while (memory[pointer] != 0) {\n");
        for (Command innerCommand: command.getInnerCommands()) {
            innerCommand.accept(this);
        }
        javaScriptCode.append("}\n");
    }

    public StringBuilder getJSCode() {
        javaScriptCode.append("alert(letter);\n");
        return javaScriptCode;
    }
}
