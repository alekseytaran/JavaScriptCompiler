package com.teamdev.brainfuck.Command;

import com.teamdev.brainfuck.CommandVisitor;

public interface Command {
    void accept(CommandVisitor visitor);

    void incrementCountRepeat();
}
