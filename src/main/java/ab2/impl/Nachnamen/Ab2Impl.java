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
        List<Instruction> list = new ArrayList<>(14);

        list.add(1,new Instruction(Read,0));
        list.add(2,new Instruction(Store,1));
        list.add(3,new Instruction(Read,1));
        list.add(4,new Instruction(Subtract,1));
        list.add(5,new Instruction(Store,1)); // (y-x)

        list.add(6,new Instruction(Read,1));
        list.add(7,new Instruction(Store,2));
        list.add(8,new Instruction(Read,0));
        list.add(9,new Instruction(Subtract,2));
        list.add(10,new Instruction(Store,2));// (x-y)

        list.add(11,new Instruction(Read,0));
        list.add(12,new Instruction(Add,1));
        list.add(13,new Instruction(Add,2));

        return list;
    }

    @Override
    public List<Instruction> hasPath() {
	return null;
    }
}
