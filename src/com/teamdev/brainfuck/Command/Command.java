package com.teamdev.brainfuck.command;

import com.teamdev.brainfuck.CommandVisitor;

public interface Command {

    void accept(CommandVisitor visitor);

    void incrementCountRepeat();
}
