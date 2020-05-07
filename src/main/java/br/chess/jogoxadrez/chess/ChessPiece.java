package br.chess.jogoxadrez.chess;

import br.chess.jogoxadrez.boardgame.Board;
import br.chess.jogoxadrez.boardgame.Piece;

/*Peça de xadrez
 * Ela é uma subClass da Peece*/
public class ChessPiece extends Piece{
	
	
	private Color color;
	
	public ChessPiece() {
	}


	/*Contructor que recebe o board(tabuleiro)*/
	public ChessPiece(Board board, Color color) {
		super(board);/*Board repassa para chamada do construtor da super class(piece)*/
		this.color = color;
	}


	public Color getColor() {
		return color;
	}

	/*Tira o set, a cor no seja modificada*/
	/*public void setColor(Color color) {
		this.color = color;
	}*/

	
	
	

}
