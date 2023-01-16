package ab2;

import ab2.RandomAccessMachine.Instruction;
import ab2.RandomAccessMachine.Instruction.Type;
import ab2.impl.BaciuFroehlichHiebler.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ab2Tests {

    private static Ab2 factory = new Ab2Impl();

    private static int punkte = 0;

    // addition
    public static RandomAccessMachine ram1() {
        RandomAccessMachine m = factory.createRAM(4);

        m.setProgram(Arrays.asList(
                    new Instruction(Type.LoadConstant, 0), // 1
                    new Instruction(Type.Read, 0), // 2
                    new Instruction(Type.Store, 1), // 3
                    new Instruction(Type.LoadConstant, 1), // 4
                    new Instruction(Type.Read, 0), // 5
                    new Instruction(Type.Add, 1), // 6
                    new Instruction(Type.Halt, null) // 7
        ));
        
        return m;
    }

    // while
    public static RandomAccessMachine ram2() {
        RandomAccessMachine m = factory.createRAM(4);

        m.setProgram(Arrays.asList(
                    new Instruction(Type.LoadConstant, 0), // 1
                    new Instruction(Type.Read, 0), // 2
                    new Instruction(Type.Store, 2), // 3
                    new Instruction(Type.LoadConstant, 1), // 4
                    new Instruction(Type.Read, 0), // 5
                    new Instruction(Type.JumpIfZero, 14), // 6
                    new Instruction(Type.SubtractConstant, 1), // 7
                    new Instruction(Type.Store, 1), // 8
                    new Instruction(Type.Load, 2), // 9
                    new Instruction(Type.AddConstant, 1), // 10
                    new Instruction(Type.Store, 2), // 11
                    new Instruction(Type.Load, 1), // 12
                    new Instruction(Type.Jump, 6), // 13
                    new Instruction(Type.Load, 2) // 14
        ));
        
        return m;
    }

    public static RandomAccessMachine ram3() {
        RandomAccessMachine m = factory.createRAM(4);

        m.setProgram(Arrays.asList(
                    new Instruction(Type.Read, 0), // 1
                    new Instruction(Type.Store, 2), // 2
                    new Instruction(Type.LoadConstant, 1), // 3
                    new Instruction(Type.Read, 0), // 4
                    new Instruction(Type.Store, 1), // 5
                    new Instruction(Type.JumpIfZero, 23), // 6
                    new Instruction(Type.Half, null), // 7
                    new Instruction(Type.Store, 3), // 8
                    new Instruction(Type.Load, 1), // 9
                    new Instruction(Type.Subtract, 3), // 10
                    new Instruction(Type.Subtract, 3), // 11
                    new Instruction(Type.JumpIfZero, 16), // 12
                    new Instruction(Type.Load, 4), // 13
                    new Instruction(Type.Add, 2), // 14
                    new Instruction(Type.Store, 4), // 15
                    new Instruction(Type.Load, 2), // 16
                    new Instruction(Type.Add, 2), // 17
                    new Instruction(Type.Store, 2), // 18
                    new Instruction(Type.Load, 3), // 19
                    new Instruction(Type.Store, 1), // 20
                    new Instruction(Type.Load, 1), // 21
                    new Instruction(Type.Jump, 6), // 22
                    new Instruction(Type.Load, 4), // 23
                    new Instruction(Type.Halt, null) // 24
        ));
        
        return m;
    }

    @Test
    public void testEmptyRAM() {
        RandomAccessMachine m = factory.createRAM(0);
        assertEquals(0, m.execute());
        assertArrayEquals(new int[] { }, m.getTapeContent());
        m.reset();
        assertArrayEquals(new int[] { }, m.getTapeContent());

        punkte += 1;
    }

    @Test
    public void testRAM1() {
        RandomAccessMachine m = ram1();
        m.setTapeContent(new int[] { 1, 2, 3 });
        assertEquals(3, m.execute());
        assertArrayEquals(new int[] { 1, 2, 3 }, m.getTapeContent());
        m.reset();
        assertEquals(0, m.execute());
        assertArrayEquals(new int[] { }, m.getTapeContent());

        punkte += 1;
    }

    @Test
    public void testRAM2() {
        RandomAccessMachine m = ram2();
        m.setTapeContent(new int[] { 4, 5 });
        assertEquals(9, m.execute());
        assertArrayEquals(new int[] { 4, 5 }, m.getTapeContent());
        m.reset();
        assertEquals(0, m.execute());
        assertArrayEquals(new int[] { }, m.getTapeContent());

        punkte += 1;
    }

    @Test
    public void testRAM3() {
        RandomAccessMachine m = ram3();
        m.setTapeContent(new int[] { 4, 5 });
        assertEquals(20, m.execute());
        assertArrayEquals(new int[] { 4, 5 }, m.getTapeContent());

        punkte += 2;
    }

    @Test
    public void testMax() {
        RandomAccessMachine m = factory.createRAM(4);
        m.setProgram(factory.max());
        m.setTapeContent(new int[] { 4, 5 });
        assertEquals(5, m.execute());

        punkte += 3;
    }

    @Test
    public void testDiv() {
        RandomAccessMachine m = factory.createRAM(4);m.setProgram(factory.div());
        m.setTapeContent(new int[] { 10, 3 });
        assertEquals(3, m.execute());

        punkte += 3;
    }

    @Test
    public void testHasPath1() {
        RandomAccessMachine m = factory.createRAM(4);
        m.setProgram(factory.hasPath());
        m.setTapeContent(new int[] { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 });
        assertEquals(1, m.execute());

        punkte += 2;
    }

    @Test
    public void testHasPath2() {
        RandomAccessMachine m = factory.createRAM(4);
        m.setProgram(factory.hasPath());
        m.setTapeContent(new int[] { 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0 });
        assertEquals(0, m.execute());

        punkte += 2;
    }

    @AfterAll
    public static void printPoints() {
        System.out.println("Gesamtpunkte: " + punkte);
    }
}
