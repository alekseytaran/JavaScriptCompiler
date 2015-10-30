package com.teamdev.brainfuck;

public interface GenerateCodeVisitor extends CommandVisitor {

    StringBuilder getPhrases();

}
