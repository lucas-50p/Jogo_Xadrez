package br.chess.jogoxadrez.main;

import br.chess.jogoxadrez.chess.ChessMatch;


public class Program {

	public static void main(String[] args) {
		
	ChessMatch chessMatch = new ChessMatch();
	UI.printBoard(chessMatch.getPieces());
	}
}
