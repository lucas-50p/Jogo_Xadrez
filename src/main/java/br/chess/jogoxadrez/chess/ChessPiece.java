package br.chess.jogoxadrez.chess;

import br.chess.jogoxadrez.boardgame.Board;
import br.chess.jogoxadrez.boardgame.Piece;
import br.chess.jogoxadrez.boardgame.Position;

/*Peça de xadrez
 * Ela é uma subClass da Peece*/
public abstract class ChessPiece extends Piece{
	
	
	private Color color;
	


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

	
	/*Se tem peça adversaria*/
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
