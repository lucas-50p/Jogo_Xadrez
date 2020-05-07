package br.chess.jogoxadrez.chess;

import br.chess.jogoxadrez.boardgame.Board;

/*Partida de Xadrez
 * Class onde vai ter as regra do jogo de xadrez*/
public class ChessMatch {

	private Board board;
	
	/*Construtor padrao
	 * Dimensão do tabuleiro de xadrez */
	public ChessMatch() {
		board = new Board(8, 8);
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
}
