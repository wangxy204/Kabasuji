package model;

import java.awt.Color;
import java.io.File;

import move.*;

public class ReleaseLevel extends Level{
	/**
	 * Generated serrialized
	 */
	private static final long serialVersionUID = 4710492805516683152L;
	int Sets;
	int redCounter;
	int yellowCounter;
	int blueCounter;
	
	int[] squareNum;
	Color[] cl;
	
	
	public ReleaseLevel(int LevelNumber, String LevelType, Board b, Bullpen p,int[] squareNum,Color[] cl) {
		super(LevelNumber, LevelType, b, p);
		this.squareNum=squareNum;
		this.cl =cl;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove(IMove m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadLevel(File f) {
		// TODO Auto-generated method stub
		
	}
	
	public int[] getSquareNum(){
		return squareNum;
	}
	
	public Color[] getCl(){
		return cl;
	}

}
