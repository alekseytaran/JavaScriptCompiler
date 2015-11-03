package com.teamdev.brainfuck.command;


import com.teamdev.brainfuck.CommandVisitor;

public class IncrementCommand implements Command {

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
