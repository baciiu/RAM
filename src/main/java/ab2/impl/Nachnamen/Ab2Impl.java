package ab2.impl.Nachnamen;

import ab2.Ab2;
import ab2.RandomAccessMachine;
import ab2.RandomAccessMachine.Instruction;

import java.util.ArrayList;
import java.util.List;

public class Ab2Impl implements Ab2 {

    @Override
    public RandomAccessMachine createRAM(int numberOfRegisters) {
        return new RAM(numberOfRegisters);
    }

    @Override
    public List<Instruction> max() {
        List<Instruction> list = new ArrayList<>();
        list.add(new Instruction(Instruction.Type.Read,0));
        return list;
    }

    @Override
    public List<Instruction> div() {
	return null;
    }

    @Override
    public List<Instruction> hasPath() {
	return null;
    }
}
