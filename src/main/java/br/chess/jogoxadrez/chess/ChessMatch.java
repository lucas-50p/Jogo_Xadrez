package br.chess.jogoxadrez.chess;

import br.chess.jogoxadrez.boardgame.Board;
import br.chess.jogoxadrez.boardgame.Piece;
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
	
	/*possiveis movimentos
	 * Para que eu possa print na aplicação a partir da posição de origem*/
	public boolean [][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);//validar se realmente, nesta posição existe um peça
		validateTagetPosition(source, target);//posição destino
		Piece capturedPiece = makeMove(source, target);//makeMove: Realizar o movimento da peça
		return (ChessPiece) capturedPiece;
	}
	
	/*Posição de origem para destino*/
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);//Retirei peça de origem
		Piece capturedPiece = board.removePiece(target);//Remove uma possivel peça,Peça capturada
		board.placePiece(p, target);
		return capturedPiece;
	}

	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {//Se no existir peça nesta posição
			throw new ChessException("Não há nenhuma peça na posição de origem");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {//Se no tiver nenhum movimento possivel
			throw new ChessException("Não há movimentos possíveis para a peça escolhida");
		}
	}
	
	/*Se para peça de origem, a posição de destino, no é um movimento possivel
	 * Significa que eu no posso mexer para lá posição de destino*/
	private void validateTagetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("A peça escolhida não pode se mover para a posição alvo");
		}
	}
	
	/*coordenadas  do xadrez*/
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	/*Responsavel por iniciar uma partida de xadrez, colocando as peças no board*/
	public void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
