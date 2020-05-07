package br.chess.jogoxadrez.boardgame;

public class Piece {

	//protect simple de matriz, não seja visível na camada do campo de xadrez
	protected Position position;
	private Board board;
	
	public Piece() {
	}
	
	public Piece(Board board) {
		this.board = board;
		position = null;//a peça no foi colocada ainda(no precisa coloca essa variavel, o java já coloca null)
	}

	//protected: somente class dentro do mesmo pacote, e subclass vão poder acessar tabuleiro, de uma peça
	protected Board getBoard() {
		return board;
	}

	/*tirar o set para o meu tabuleiro no seja alterado*/
	
	
	
	
	
}
