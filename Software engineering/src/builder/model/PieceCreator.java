package builder.model;
import model.Piece;
import model.Square;

public class PieceCreator {
	Square base[] = new Square[36];
	Piece piece;
	boolean[] selectedSquare = new boolean[36];
	
	public PieceCreator(){
		init();
	}
	
	private void init(){
		int row = 0;
		int col = 0;
		for (int i = 0; i < 36; i++){
			base[i] = new Square(col, row);
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
			
		}
	}
	
	public boolean validPiece(){
		
		return (this.piece.isPiece())&&(dfsSquare(piece.getHead()));

	}
	
	private boolean dfsSquare(Square head){
		Square tempsqRt = new Square(head.getColumn()+1, head.getRow());
		Square tempsqLt = new Square(head.getColumn()-1, head.getRow());
		Square tempsqUp = new Square(head.getColumn(), head.getRow()+1);
		Square tempsqDn = new Square(head.getColumn(), head.getRow()-1);
		if((piece.containSquare(tempsqRt))&& (!(tempsqRt.getVisit()))){
			dfsSquare(tempsqRt);
		}
		if((piece.containSquare(tempsqLt))&& (!(tempsqLt.getVisit()))){
			dfsSquare(tempsqLt);
		}
		if((piece.containSquare(tempsqDn))&& (!(tempsqDn.getVisit()))){
			dfsSquare(tempsqDn);
		}
		if((piece.containSquare(tempsqUp))&& (!(tempsqUp.getVisit()))){
			dfsSquare(tempsqUp);
		}
		
		return piece.allVisited();
		
	}
	
	public boolean createPiece(){
		
		int counter = 0;
		int row = 0;
		int col = 0;
		Square[] s = new Square[6];
		for(int i = 0; i<36;i++){
			if(selectedSquare[i]){
				if (counter > 5) return false;
				s[counter] = new Square(col,row);
				counter++;
			}
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
			
		}
		
		
		this.piece = new Piece(0, 0,s, s[0], 0);
		
		return true;
	}
	
	public Square[] getSquares(){
		return base;
	}
	
	public boolean[] getSelected(){
		return selectedSquare;
	}
	public Piece getPiece(){
		return this.piece;
	}
	
	public void selectSquare(int row, int column){
		this.selectedSquare[row * 6 + column] = true;
	}
	
	
}
