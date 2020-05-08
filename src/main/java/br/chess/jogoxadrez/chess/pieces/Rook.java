package br.chess.jogoxadrez.chess.pieces;

import br.chess.jogoxadrez.boardgame.Board;
import br.chess.jogoxadrez.chess.ChessPiece;
import br.chess.jogoxadrez.chess.Color;

/*Torre - Tabuleiro*/
public class Rook extends ChessPiece{
	

	/*Esse construtor vai repassar essa chamada para a super class*/
	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}

	
}
