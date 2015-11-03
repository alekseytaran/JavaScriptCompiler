package com.teamdev.brainfuck;

import java.util.ArrayList;
import java.util.List;

public class OptimizationVisitor implements CommandVisitor {

    private final List<Command> optimizedCommands = new ArrayList<>();

    public List<Command> getOptimizedCommands() {
        return optimizedCommands;
    }

    private void fillInCommandList(Command command, Class currentClass) {
        if (optimizedCommands.isEmpty() ||
                (optimizedCommands.get(optimizedCommands.size() - 1).getClass() != currentClass)) {
            optimizedCommands.add(command);
        } else {
            optimizedCommands.remove(command);
        }

        optimizedCommands.get(optimizedCommands.size() - 1).incrementCountRepeat();
    }

    @Override
    public void visit(MoveForwardCommand command) {
        fillInCommandList(command, MoveForwardCommand.class);
    }

    @Override
    public void visit(MoveBackwardCommand command) {
        fillInCommandList(command, MoveBackwardCommand.class);
    }

    @Override
    public void visit(IncrementCommand command) {
        fillInCommandList(command, IncrementCommand.class);
    }

    @Override
    public void visit(DecrementCommand command) {
        fillInCommandList(command, DecrementCommand.class);
    }

    @Override
    public void visit(PrintCommand command) {
        fillInCommandList(command, PrintCommand.class);
    }

    @Override
    public void visit(LoopCommand command) {
        final List<Command> innerCommands = command.getInnerCommands();

        new LoopCommand(getCommandsInLoop(innerCommands, new OptimizationVisitor()));
        optimizedCommands.add(command);
    }

    public List<Command> getCommandsInLoop(List<Command> program, OptimizationVisitor optimizationVisitor) {
        for (Command command : program) {
            command.accept(optimizationVisitor);
        }
        return getOptimizedCommands();
    }
}
