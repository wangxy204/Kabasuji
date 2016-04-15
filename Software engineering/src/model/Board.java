package model;

public class Board implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8260314857254020443L;
	Square[] square ;
	boolean cover;
	Hint hints = null;
	Piece[] piece =null;
	int squareLeft;
	
	/**
	 * Create an example Board with 6 x 6 squares
	 */
	public Board(){
		int row = 0;
		int col = 0;
		square = new Square[36];
		for (int i = 0; i < 36; i++){
			square[i] = new Square(col, row);
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
 		}
		hints = new Hint();
	}
	
	/**
	 * Create board using the given array
	 * @param square
	 */
	public Board(Square[] square){

		this.square = square;
	}
	
	public void coverBoard(Piece[] piece,Square[] square ){
		//...
	}
	public Square[] getSquare(){
		return square; //get the array square 
	}
	public Hint getHint(){
		return hints;
	}
	
	public void removepiece(Piece[] piece){
		
			
		}
	
	public Piece[] getpiece(){
		return piece;
	}
	
	public void sethint(Hint hints){
		this.hints = hints;
		
	}
	
	public void addpiece(Piece piece){
		if (piece==null){
			this.piece = new Piece[1];
			//this.piece[0] = new Piece();
		}
		else{
			this.piece = new Piece[1];
		}
	}
	
}
