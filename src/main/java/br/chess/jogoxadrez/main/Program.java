package br.chess.jogoxadrez.main;

import java.util.Scanner;

import br.chess.jogoxadrez.chess.ChessMatch;
import br.chess.jogoxadrez.chess.ChessPiece;
import br.chess.jogoxadrez.chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChesPosition(sc);

			System.out.println();
			System.out.print("Target: ");
			ChessPosition taget = UI.readChesPosition(sc);

			ChessPiece capturesPiece = chessMatch.performChessMove(source, taget);
		}

	}
}
