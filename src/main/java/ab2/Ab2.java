package ab2;

import java.util.List;

import ab2.RandomAccessMachine;
import ab2.RandomAccessMachine.Instruction;

public interface Ab2 {

	/**
	 * Erzeugt eine neue Instanz einer Registermaschine (RAM). Eine RAM hat
	 * immer zumindest einen Akkumulator (Register 0). Die zusätzliche
	 * Anzahl zur Verfügung stehender Register wird hier übergeben. Alle
	 * Register beinhalten zu Beginn den Wert 0.
	 */
	public RandomAccessMachine createRAM(int numberOfRegisters);

	/**
	 * Erstellen Sie ein RAM-Programm, welches für zwei Zahlen (an den
	 * Speicherstellen T[0] und T[1]) das Maximum bestimmt. Benutzen Sie
	 * hierfür neben dem Akkumulator noch maximal vier weitere Register.
	 */
	public List<Instruction> max();

	/**
	 * Erstellen Sie ein RAM-Programm, welches für zwei Zahlen (an den
	 * Speicherstellen T[0] und T[1]) die ganzzahlige Division berechnet.
	 * Benutzen Sie hierfür neben dem Akkumulator noch maximal vier weitere
	 * Register. Ist T[1] gleich 0, so soll 0 zurückgegeben werden.
	 */
	public List<Instruction> div();

	/**
	 * Erstellen Sie ein RAM-Programm, welches an den ersten 16
	 * Speicherstellen entweder 1en oder 0en übergeben bekommt, die die
	 * vier Zeilen einer 4x4-Adjazenzmatrix eines Graphen mit vier Knoten
	 * repräsentieren, und bestimmt, ob es einen Weg vom Knoten 1 zum
	 * Knoten 4 gibt. Benutzen Sie hierfür neben dem Akkumulator noch
	 * maximal vier weitere Register.
	 */
	public List<Instruction> hasPath();
}
