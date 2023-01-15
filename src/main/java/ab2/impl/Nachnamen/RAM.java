package ab2.impl.Nachnamen;

import ab2.RandomAccessMachine;

import java.util.ArrayList;
import java.util.List;

public class RAM implements RandomAccessMachine {

    private int numberOfRegisters;
    private int[] tapeContent = new int[]{};
    private List<Instruction> program = new ArrayList<>();
    private int instructionCount = 0;
    private boolean isHalt = false;
    private int[] registers;

    public RAM( int numberOfRegisters ){
        this.numberOfRegisters = numberOfRegisters + 2;
        registers = new int[numberOfRegisters];
    }

    @Override
    public void setProgram(List<Instruction> program) {
        this.program.clear();
        this.program.addAll(program);
    }

    @Override
    public void setTapeContent(int[] content) {
        tapeContent = content;
    }

    @Override
    /**
     * Returns the contents of the register engine's memory,excluding all 0s.
     * In particular, after the execute() method has been called, the memory content
     * should be returned after the RAM program has been processed.*/
    public int[] getTapeContent() {
        return tapeContent;
    }

    @Override
    /** Return the accumulator value
     * If the RAm is at the end of execution, it means it has the instruction "HALT"
     * */
    public int execute() {
        if (this.numberOfRegisters-2 == 0){
            return 0;
        }

        while(!isHalt) {

            if (instructionCount == program.size()-1){
                return registers[0];
            }
            Instruction instruction = program.get(instructionCount);


            switch (instruction.Type) {

                case Load -> registers[0] = registers[instruction.Argument];
                case LoadConstant -> registers[0] = instruction.Argument;
                case Store -> registers[instruction.Argument] = registers[0];

                case Read -> registers[0] = tapeContent[registers[instruction.Argument]] ;
                case Write -> tapeContent[registers[instruction.Argument]] = registers[0];

                case Add -> registers[0] = registers[0] + registers[instruction.Argument];  // ok
                case AddConstant -> registers[0] = registers[0] + instruction.Argument; // ok

                case Subtract -> {
                    if (registers[0] - registers[instruction.Argument] > 0) {
                        registers[0] = registers[0] - registers[instruction.Argument];
                    } else {
                        registers[0] = 0;
                    }
                }
                case SubtractConstant -> {
                    if (registers[0] - instruction.Argument > 0) {
                        registers[0] = registers[0] - instruction.Argument;
                    } else {
                        registers[0] = 0;
                    }
                }
                case Multiply -> registers[0] = registers[0] * registers[instruction.Argument]; // ok
                case MultiplyConstant -> registers[0] = registers[0] * instruction.Argument; // ok

                case Half -> registers[0] = registers[0] / 2;

                case Jump -> instructionCount = instruction.Argument;
                case JumpIfPositive -> {
                    if (registers[0] > 0) instructionCount = instruction.Argument-1 ;
                }

                case JumpIfZero -> {
                    if (registers[0] == 0) instructionCount = instruction.Argument-1 ;
                }
                case Halt -> isHalt = true;
            }
            instructionCount++;

        }
        return registers[0];
    }

    @Override
    public void reset() {
        setTapeContent(new int[]{});
        numberOfRegisters = 2;
        instructionCount = 0 ;
    }

}
