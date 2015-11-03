package com.teamdev.brainfuck;

public class MoveBackwardCommand implements Command {

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
