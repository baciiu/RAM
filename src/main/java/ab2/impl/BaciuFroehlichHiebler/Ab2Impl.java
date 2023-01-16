package ab2.impl.Nachnamen;

import ab2.Ab2;
import ab2.RandomAccessMachine;
import ab2.RandomAccessMachine.Instruction;

import java.util.ArrayList;
import java.util.List;

import static ab2.RandomAccessMachine.Instruction.Type.*;

public class Ab2Impl implements Ab2 {

    @Override
    public RandomAccessMachine createRAM(int numberOfRegisters) {
        return new RAM(numberOfRegisters);
    }

    @Override
    public List<Instruction> max() {
        List<Instruction> list = new ArrayList<>(16);

        list.add(0,new Instruction(LoadConstant,0));
        list.add(1,new Instruction(Read,0));
        list.add(2,new Instruction(Store,1));
        list.add(3,new Instruction(LoadConstant,1));
        list.add(4,new Instruction(Read,0));
        list.add(5,new Instruction(Store,2));
        list.add(6,new Instruction(Add,1));
        list.add(7,new Instruction(Load,1));
        list.add(8,new Instruction(Subtract,2));
        list.add(9,new Instruction(Store,3));
        list.add(10,new Instruction(Load,2));
        list.add(11,new Instruction(Subtract,1));
        list.add(12,new Instruction(Add,3));
        list.add(13,new Instruction(Add,2));
        list.add(14,new Instruction(Add,1));
        list.add(15,new Instruction(Half,null));


        return list;
    }

    @Override
    public List<Instruction> div() {
        List<Instruction> list = new ArrayList<>(19);

        list.add(0,new Instruction(LoadConstant,1));
        list.add(1,new Instruction(Read,0));
        list.add(2,new Instruction(Store,2));
        list.add(3,new Instruction(LoadConstant,0));
        list.add(4,new Instruction(Read,0)); //R2 = 3

        list.add(5,new Instruction(AddConstant,1));
        list.add(6,new Instruction(Subtract,2));
        list.add(7,new Instruction(JumpIfZero,18));
        list.add(8,new Instruction(SubtractConstant,1));
        list.add(9,new Instruction(Store,1));

        list.add(10,new Instruction(Load,3)); // R3 = counter
        list.add(11,new Instruction(AddConstant,1));
        list.add(12,new Instruction(Store,3));
        list.add(13,new Instruction(Load,1)); // R1 = x-(c)y
        list.add(14,new Instruction(AddConstant,1));

        list.add(15,new Instruction(Subtract,2));
        list.add(16,new Instruction(Jump,8));
        list.add(17,new Instruction(Load,3));
        list.add(18,new Instruction(Halt,null));


        return list;
    }

    @Override
    public List<Instruction> hasPath() {
        List<Instruction> list = new ArrayList<>(47);

        list.add(0, new Instruction(LoadConstant, 3)); // maybe 4, loop counter, stored in register 4
        list.add(1, new Instruction(JumpIfZero, 46));
        list.add(2, new Instruction(SubtractConstant, 1));
        list.add(3, new Instruction(Store, 4));

        list.add(4, new Instruction(Load, 1));
        list.add(5, new Instruction(AddConstant, 1));
        list.add(6, new Instruction(Store, 1));
        list.add(7, new Instruction(Read, 1));

        list.add(8, new Instruction(JumpIfZero, 13));
        list.add(9, new Instruction(Load, 2));
        list.add(10, new Instruction(AddConstant, 1));
        list.add(11, new Instruction(Store, 2));

        list.add(12, new Instruction(Load, 1));
        list.add(13, new Instruction(AddConstant, 1));
        list.add(14, new Instruction(Store, 1));
        list.add(15, new Instruction(Read, 1));

        list.add(16, new Instruction(JumpIfZero, 21));
        list.add(17, new Instruction(Load, 3));
        list.add(18, new Instruction(AddConstant, 1));
        list.add(19, new Instruction(Store, 3));
        list.add(20, new Instruction(Load, 1));
        list.add(21, new Instruction(AddConstant, 1));
        list.add(22, new Instruction(Store, 1));
        list.add(23, new Instruction(Read, 1));

        list.add(24, new Instruction(JumpIfPositive, 46));

        list.add(25, new Instruction(Load, 2));
        list.add(26, new Instruction(JumpIfZero, 36));
        list.add(27, new Instruction(SubtractConstant, 1));
        list.add(28, new Instruction(JumpIfPositive, 36));
        list.add(29, new Instruction(AddConstant, 2));
        list.add(30, new Instruction(Store, 2));
        list.add(31, new Instruction(LoadConstant, 4));
        list.add(32, new Instruction(Store, 1));
        list.add(33, new Instruction(Load, 4));
        list.add(34, new Instruction(Jump, 2));

        list.add(35, new Instruction(Load, 3));
        list.add(36, new Instruction(JumpIfZero, 46));
        list.add(37, new Instruction(SubtractConstant, 1));
        list.add(38, new Instruction(JumpIfPositive, 46));
        list.add(39, new Instruction(AddConstant, 2));
        list.add(40, new Instruction(Store, 3));
        list.add(41, new Instruction(LoadConstant, 8));
        list.add(42, new Instruction(Store, 1));
        list.add(43, new Instruction(Load, 4));
        list.add(44, new Instruction(Jump, 2));
        list.add(45, new Instruction(Halt, null));

        return list;
    }
}
