package model;

import java.util.ArrayList;

public class Bullpen implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4002796328568793576L;
	ArrayList<Piece> piece;
	int pieceSelected = 0;

	/**
	 * Create sample data for Bullpen
	 */
	public Bullpen(){

	}
	
	/**
	 * create a bull pen from array of piece
	 * @param piece
	 */
	public Bullpen(ArrayList<Piece> piece){
		this.piece = piece;

	}


	public ArrayList<Piece> getPieces(){
		return piece;
	}
	
	public boolean removepiece(Piece p){
		return this.piece.remove(p);
	}

	public boolean addpiece(Piece p){
		return this.piece.add(p);
	}
	
	public void setPieceSelected(int p){
		pieceSelected = p;
	}
	
	public int getPieceSelected(){
		return pieceSelected;
	}
	
	public void removePiece(int pNum){
		piece.remove(pNum);		
	}
}
