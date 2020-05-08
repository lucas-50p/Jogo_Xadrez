package br.chess.jogoxadrez.boardgame;

public class Position {

	private int row;
	private int column;
	
	public Position() {
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/*imprimir a posição da tela*/
	@Override/*É a implementação de um método de uma superclasse na subclasse*/
	public String toString() {
		return row + ", " + column;
	}
	
	
	
}
