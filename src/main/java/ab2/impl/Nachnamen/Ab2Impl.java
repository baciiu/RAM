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
        //R0 = 1,3,0,10,11,8,7,0,1,7,8,5,4,1,2,4,5,2,1,2,3,1,2,0,3
        //R1 = 7,4,1,
        //R2 = 3,
        //R3 = 1,2,3,

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
	return null;
    }
}
