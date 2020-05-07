package br.chess.jogoxadrez.chess;

import br.chess.jogoxadrez.boardgame.Board;
import br.chess.jogoxadrez.boardgame.Position;
import br.chess.jogoxadrez.chess.pieces.King;
import br.chess.jogoxadrez.chess.pieces.Rook;

/*Partida de Xadrez
 * Class onde vai ter as regra do jogo de xadrez*/
public class ChessMatch {

	private Board board;
	
	/*Construtor padrao
	 * Dimensão do tabuleiro de xadrez */
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();//vou ter que chamar no inicio da minha partida
	}
	
	/*UPCASTING e  Downcasting:
	*UPCASTING:Casting da subclasse para superclasse
	• Uso comum: polimorfismo
	
	• Downcasting
	• Casting da superclasse para subclasse
	• Palavra instanceof
	• Uso comum: métodos que recebem parâmetros genéricos (ex: Equals)
	 */
	
	
	/*Ele vai retornar a matriz de xadrez, correspondente essa partida
	 * O board(tabuleiro) tem as peças; na classe(board)private Piece[][] pieces;//Matriz de peças;
	 * O meu metodo na class ChessMatch, ele retorna porque ->
	 * Estou na camada de xadrez (chesslayer), programa é feito em camadas*/
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		/*Percorrer a matriz de peça de tabuleiro(board)
		 * Para cada peça do meu tabuleiro eu vou fazer um downcasting para chessPiece 
		 * Para cada posição I e J do meu tabuleiro eu vou fazer a minha matriz*/
		for (int i = 0; i <board.getRows(); i++) {
			for (int j = 0; j <board.getColumns() ; j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;//quando terminar os dois for return a minha matriz mat, da minha partida de xadrez
	}
	
	/*Responsavel por iniciar uma partida de xadrez, colocando as peças no board*/
	public void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
