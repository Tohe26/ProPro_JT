/* (C) 2025 TUDA AI1 team - ProPro 2025 - Chess */
package tuda.ai1.propro25.model;

import java.util.Objects;

/**
 * Coordinates bzw. Koordinaten sind ein einfaches Datenpaar aus rank (Zeile)
 * und File (Linien)
 */
public final class Coordinate {
	private final int file;
	private final int rank;

	/**
	 * @param file
	 *            Spalte/Linie
	 * @param rank
	 *            Reihe/Zeile
	 */
	public Coordinate(int file, int rank) {
		this.file = file;
		this.rank = rank;
	}
	
	public int getFile() {
		return file;
	}

	public int getRank() {
		return rank;
	}
	
	/**
	 * Methode zur Umwandlung der numerischen Spaltenwerte in algebraische (Schach)Notationen
	 * @return die zusammengesetzte algebraische (Schach)Notation
	 */
	public String getAlgebraicNotation() {
		// String-Array für die Spaltenbuchstaben
		String[] spaltenBuchstaben = {"a", "b", "c", "d", "e", "f", "g", "h"};
		String buchstabe = spaltenBuchstaben[file];
		// Zeilenzahl(rank) + 1, da die Zahlen auf dem Schachbrett bei 1 beginnen
		int zahl = rank + 1;
		return buchstabe + zahl;
	}
	
	/**
	 * Methode um die Gültigkeit der Koordinaten zu prüfen
	 * @return true, falls die Koordinate auf dem Brett liegt / false, falls nicht
	 */
	public boolean isOnBoard() {
		return file >= 0 && file < Board.BOARD_SIZE && rank >= 0 && rank < Board.BOARD_SIZE;
	}
	
	/**
	 * Methode überschreibt toString, sodass die Koordinate in Form der Schachnotation zurückgegeben wird
	 * @return Notations-String 
	 */
	public String toString() {
		return getAlgebraicNotation();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		var that = (Coordinate) obj;
		return this.file == that.file && this.rank == that.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(file, rank);
	}
	
}
