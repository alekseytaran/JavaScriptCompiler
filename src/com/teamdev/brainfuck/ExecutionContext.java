package com.teamdev.brainfuck;

public class ExecutionContext {

    public static final int MEMORY_SIZE = 30000;

    private final byte[] memory = new byte[MEMORY_SIZE];
    private int pointer;

    public void movePointerForward() {
        pointer++;

        if (pointer >= MEMORY_SIZE) {
            throw new IllegalStateException("Pointer is out of memory: " + pointer);
        }
    }

    public void movePointerForward(int counterRepeat) {
        pointer += counterRepeat;

        if (pointer >= MEMORY_SIZE) {
            throw new IllegalStateException("Pointer is out of memory: " + pointer);
        }
    }

    public void movePointerBackward() {
        pointer--;

        if (pointer < 0) {
            throw new IllegalStateException("Pointer is out of memory: " + pointer);
        }
    }

    public void movePointerBackward(int counterRepaet) {
        pointer -= counterRepaet;

        if (pointer < 0) {
            throw new IllegalStateException("Pointer is out of memory: " + pointer);
        }
    }

    public byte getCurrentValue() {
        return memory[pointer];
    }

    public void incrementCurrentValue() {
        memory[pointer]++;
    }

    public void incrementCurrentValue(int counterRepeat) {
        memory[pointer] += counterRepeat;
    }

    public void decrementCurrentValue() {
        memory[pointer]--;
    }

    public void decrementCurrentValue(int counterRepeat) {
        memory[pointer] -= counterRepeat;
    }

}
