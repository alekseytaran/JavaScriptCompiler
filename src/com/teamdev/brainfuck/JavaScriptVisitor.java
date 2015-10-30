package com.teamdev.brainfuck;

import com.teamdev.brainfuck.Command.*;

public class JavaScriptVisitor implements GenerateCodeVisitor {

    private final StringBuilder javaScriptCode = new StringBuilder();

    public JavaScriptVisitor(){
        javaScriptCode.append("\"use strict\";\n");
        javaScriptCode.append("var memory = [];\n");
        javaScriptCode.append("var pointer = 0;\n");
        javaScriptCode.append("var currentValue = '';\n");
        javaScriptCode.append("for(var x =0; x < 30000; x++){\n");
        javaScriptCode.append("memory[x] = 0;\n");
        javaScriptCode.append("}\n");
    }

    @Override
    public StringBuilder getPhrases() {
        javaScriptCode.append("alert(currentValue);\n");
        return javaScriptCode;
    }

    @Override
    public void visit(MoveForwardCommand command) {
        javaScriptCode.append("pointer += " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(MoveBackwardCommand command) {
        javaScriptCode.append("pointer -= " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(IncrementCommand command) {
        javaScriptCode.append("memory[pointer] += " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(DecrementCommand command) {
        javaScriptCode.append("memory[pointer] -= " + command.getCounter() + ";\n");
    }

    @Override
    public void visit(PrintCommand command) {
        javaScriptCode.append("for(let i = 0; i < " + command.getCounter() + "; i++) {\n");
        javaScriptCode.append("currentValue += String.fromCharCode(memory[pointer]);\n");
        javaScriptCode.append("}\n");
    }

    @Override
    public void visit(LoopCommand command) {
        javaScriptCode.append("for( ; memory[pointer] != 0; ) {\n");
        for (Command innerCommand: command.getInnerCommands()) {
            innerCommand.accept(this);
        }
        javaScriptCode.append("}\n");
    }
}
