package br.chess.jogoxadrez.chess.pieces;

import br.chess.jogoxadrez.boardgame.Board;
import br.chess.jogoxadrez.chess.ChessPiece;
import br.chess.jogoxadrez.chess.Color;

/*Rei - Tabuleiro*/
public class King extends ChessPiece{

	/*Esse construtor vai repassar essa chamada para a super class*/
	public King(Board board, Color color) {
		super(board, color);
	}

	/* Essa letra no tabuleiro*/
	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
}
