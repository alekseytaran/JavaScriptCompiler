package com.teamdev.brainfuck;

public class ExecutionVisitor implements CommandVisitor {

    final private ExecutionContext context = new ExecutionContext();

    @Override
    public void visit(MoveForwardCommand command) {
        context.movePointerForward(command.getCounter());
    }

    @Override
    public void visit(MoveBackwardCommand command) {
        context.movePointerBackward(command.getCounter());
    }

    @Override
    public void visit(IncrementCommand command) {
        context.incrementCurrentValue(command.getCounter());
    }

    @Override
    public void visit(DecrementCommand command) {
        context.decrementCurrentValue(command.getCounter());
    }

    @Override
    public void visit(PrintCommand command) {
        for (int i = 0; i < command.getCounter(); i++) {
            System.out.print((char) context.getCurrentValue());
        }
    }

    @Override
    public void visit(LoopCommand command) {
        while (context.getCurrentValue() != 0) {
            for (Command innerCommand : command.getInnerCommands()) {
                innerCommand.accept(this);
            }
        }
    }

}
