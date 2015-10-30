package com.teamdev.brainfuck;

import com.teamdev.brainfuck.Command.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OptimizationVisitor implements CommandVisitor {

    private final List<Command> optimizedCommands = new ArrayList<>();

    public List<Command> getOptimizedCommands() {
        return optimizedCommands;
    }

    @Override
    public void visit(MoveForwardCommand command) {
        if (optimizedCommands.isEmpty() ||
                (optimizedCommands.get(optimizedCommands.size() - 1).getClass() != MoveForwardCommand.class)) {
            optimizedCommands.add(command);
        }

        optimizedCommands.get(optimizedCommands.size() - 1).incrementCountRepeat();


    }

    @Override
    public void visit(MoveBackwardCommand command) {
        if (optimizedCommands.isEmpty() ||
                optimizedCommands.get(optimizedCommands.size() - 1).getClass() != MoveBackwardCommand.class) {
            optimizedCommands.add(command);
        }

        optimizedCommands.get(optimizedCommands.size() - 1).incrementCountRepeat();
    }

    @Override
    public void visit(IncrementCommand command) {
        if (optimizedCommands.isEmpty() ||
                (optimizedCommands.get(optimizedCommands.size() - 1).getClass() != IncrementCommand.class)) {
            optimizedCommands.add(command);
        }

        optimizedCommands.get(optimizedCommands.size() - 1).incrementCountRepeat();
    }

    @Override
    public void visit(DecrementCommand command) {
        if (optimizedCommands.isEmpty() ||
                optimizedCommands.get(optimizedCommands.size() - 1).getClass() != DecrementCommand.class) {
            optimizedCommands.add(command);
        }
        optimizedCommands.get(optimizedCommands.size() - 1).incrementCountRepeat();
    }

    @Override
    public void visit(PrintCommand command) {
        if (optimizedCommands.isEmpty() ||
                optimizedCommands.get(optimizedCommands.size() - 1).getClass() != PrintCommand.class) {
            optimizedCommands.add(command);
        }

        optimizedCommands.get(optimizedCommands.size() - 1).incrementCountRepeat();
    }

    @Override
    public void visit(LoopCommand command) {

        final List<Command> innerCommands = command.getInnerCommands();
        // todo: optimize!

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
