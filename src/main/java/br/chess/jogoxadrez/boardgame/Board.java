package br.chess.jogoxadrez.boardgame;

public class Board {

	private int rows;//linha
	private int columns;//colunas
	private Piece[][] pieces;//Matriz de peças
	
	
	public Board() {
	}
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {/*quantida linhas tem que ser pelo menos 1 */
			throw new BoardException("Erro ao criar quadro: deve haver pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];//Colocar manualmente
	}

	public int getRows() {
		return rows;
	}

	/*Retirar "Set" Não seja alterado set rows columns */
	
	public int getColumns() {
		return columns;
	}

	
	/*Ele vai retorn a minha matriz pieces*/
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return pieces[row][column];
	}
	
	/*Sobrecarga
	 * retorna peça pela posição */
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/*colocar peça*/
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça na posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	/*Remove Peça do xadrez da posição do tabuleiro*/
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	
	/*Metodo aux
	 * Mais facil testa pela linha e coluna, que pela posição
	 * a linha tem que ser maior que 0 - row >=0
	 * essa linha tem que ser menor que linha do tabuleiro  - row < rows
	 * */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	/*Essa posição existe*/
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	/*Essa tem peça ness posição
	 * piece e do metodo da sobrcarga(class board) */
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return piece(position) != null;
	}
}
