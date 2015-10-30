package com.teamdev.brainfuck.Command;


import com.teamdev.brainfuck.CommandVisitor;

public class PrintCommand implements Command {

    private int counter;

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void incrementCountRepeat() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
