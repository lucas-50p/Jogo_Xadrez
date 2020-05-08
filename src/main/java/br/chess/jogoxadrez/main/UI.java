package br.chess.jogoxadrez.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.chess.jogoxadrez.chess.ChessPiece;
import br.chess.jogoxadrez.chess.ChessPosition;


/*user interface*/
public class UI {
	
	/*Parte para rodar git bash
	https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	Codigos especiais das cores, para print no console
	Cor do text
	public static final String ANSI_RESET = "\u001B[0m";//Para resetar a cor
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	Cor do fundo
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	*/
	
	
	/*Ler a posição do xadrez*/
	public static ChessPosition readChesPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);// Letra A
			int row = Integer.parseInt(s.substring(1));// number 1
			return new ChessPosition(column, row);
		} catch (RuntimeException e) {
			// Erro no lançamento de dados
			throw new InputMismatchException("Erro ao ler ChessPosition. Os valores válidos são de a1 a h8.");
		}
	}

	/*Colocando pieces.length matriz vai ser quadrada*/
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);//false, indicando que nenhuma peça é para ter um fundo color
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	/*Imprimir uma unica peça*/
	private static void printPiece(ChessPiece piece, boolean background) {
		if (background) {
			System.out.print("*");
		}
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

	
}
