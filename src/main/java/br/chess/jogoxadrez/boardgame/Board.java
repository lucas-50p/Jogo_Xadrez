package br.chess.jogoxadrez.boardgame;

public class Board {

	private int rows;//linha
	private int columns;//colunas
	private Piece[][] pieces;//Matriz de peças
	
	
	public Board() {
	}
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];//Colocar manualmente
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	/*Pices por enquanto no*/
	
}
