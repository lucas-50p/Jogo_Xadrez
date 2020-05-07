package br.chess.jogoxadrez.chess;

import br.chess.jogoxadrez.boardgame.Position;

/*Xadrez - Posição*/
public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro ao instanciar o ChessPosition. Os valores válidos são de a1 a h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	/*Retirar "Set" Não seja alterado livremente set rows columns */

	/*matrix_row = 8 - chess_row
	 * 
	 * matrix_column = chess_column - 'a'
	 * 
	 * ---------
	 * -Pegar unicode da letra 'a'
	 * 
	 * 'a' - 'a' = 0
	 * 'b' - 'a' = 1
	 * 'c' - 'a' = 2
	 * 
	 * --------
	 * coluna ---
	 * a= 0
	 * b= 1
	 * c= 2
	 * d= 3
	 * ----------
	 * 
	 * linha 8 do xadrez corresponde 8 - 8 = 0 da matriz
	 * a linha 7 do xadrez corresponde 8 - 7 = 1 da matriz
	 * linha ex tá marcado em parentes ()
	 * 
	 * ----
	 * 8 (-0) - - - - - - - 
	 * 7 (-1) - - - - - - - 
	 * 6 (-) - - - - - - - 
	 * 5 (-) - - - - - - - 
	 * 4 (-) - - - - - - - 
	 * 3 (-) - - - - - - - 
	 * 2 (-) - - - - - - - 
	 * 1 (-) - - - - - - - 
	 * 	  a  b c d e f g h
	 * */
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}

	/*a 1
	 * concatenação de strings ""*/
	@Override
	public String toString() {
		return "" + column +  row;
	}
	
	
}
