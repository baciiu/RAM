package ab2;

import java.util.List;

/**
 * Simuliert eine Registermaschine (RAM), die zusätzlich zu den Befehlen, die
 * in der VO besprochen wurden, auch den Befehl "mult" unterstützt, welcher
 * gleich wie "add" funktioniert, aber die Multiplikation zweier Zahlen
 * errechnet.
 */
public interface RandomAccessMachine {

	/**
	 * Übergibt das Programm, welches die RAM abarbeiten soll.
	 */
	public void setProgram(List<Instruction> program);

	/**
	 * Übergibt den Speicherinhalt der ersten content.length
	 * Speicherzellen. Die restlichen, folgenden Speicherstellen beinhalten
	 * den Wert 0.
	 */
	public void setTapeContent(int[] content);

	/**
	 * Gibt den Speicherinhalt der Registermaschine zurück, mit Ausnahme
	 * aller folgenden 0en. Im Speziellen soll nach einem Aufruf der
	 * execute()-Methode der Speicherinhalt nach Abarbeitung des
	 * RAM-Programms zurückgegeben werden.
	 */
	public int[] getTapeContent();


	/** Führt das Programm der RAM auf dem aktuellen Speicherinhalt
	 * aus und gibt am Ende den Inhalt des Akkumulators (= Register 0)
	 * zurück. Erreicht die RAM das Ende des Programms, so ist dies
	 * gleichbedeutend mit der Ausführung des Befehls "halt".
	 *
	 * @return den Wert des Akkumulators (Register 0) nach Abarbeitung
	 */
	public int execute();

	/**
	 * Löscht Programm, Speicherinhalt und Registerinhalt.
	 */
	public void reset();

	/**
	 * Repräsentiert einen vollständigen Befehl samt Argument (sofern benötigt).
	 */
	public class Instruction {

		/**
		 * Zählt die Befehlstypen auf (siehe VO).
		 */
		public enum Type {
			Read,
			Write,
			Store,
			Load,
			LoadConstant,
			Add,
			AddConstant,
			Subtract,
			SubtractConstant,
			Multiply,
			MultiplyConstant,
			Half,
			Jump,
			JumpIfPositive,
			JumpIfZero,
			Halt
		}

		public Type Type;
		public Integer Argument;

		public Instruction(Type type, Integer argument) {
			this.Type = type;
			this.Argument = argument;
		}
	}
}
