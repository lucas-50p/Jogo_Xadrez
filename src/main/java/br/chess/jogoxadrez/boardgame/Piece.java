package br.chess.jogoxadrez.boardgame;

public abstract class Piece {

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
	
	
	/*Metodo concreto que ele esta utilizando o metodo abstrato; faz um gancho com a sub class
	 * Consegue fornece um implementação padrao de um metodo que depende do metodo abstrato
	 * 
	 * template metodo*/
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}	
	
	/*Existe pelo menos um movimento para minha peça*/
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
