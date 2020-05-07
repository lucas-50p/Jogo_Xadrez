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
	
	/*Ele vai retorn a minha matriz pieces*/
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	/*Sobrecarga
	 * retorna peça pela posição */
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/*colocar peça*/
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
}
